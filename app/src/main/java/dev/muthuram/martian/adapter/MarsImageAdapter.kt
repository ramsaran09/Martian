package dev.muthuram.martian.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.muthuram.martian.R
import dev.muthuram.martian.model.MarsImageDataModel
import kotlinx.android.synthetic.main.model_mar_image_list.view.*


class MarsImageAdapter(
    val context: Context,
    val onMoreDetailsClick: (MarsImageDataModel) -> Unit
) :
    ListAdapter<MarsImageDataModel, MarsImageAdapter.MarsImageViewHolder>(object :
        DiffUtil.ItemCallback<MarsImageDataModel>() {
        override fun areItemsTheSame(
            oldItem: MarsImageDataModel,
            newItem: MarsImageDataModel
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MarsImageDataModel,
            newItem: MarsImageDataModel
        ): Boolean = oldItem == newItem
    }) {

    private val marsData : ArrayList<MarsImageDataModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsImageViewHolder =
        MarsImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.model_mar_image_list, parent, false)
        )

    override fun onBindViewHolder(holder: MarsImageViewHolder, position: Int) {
        val item = currentList[position]
        holder.id.text = item.id
        holder.camera.text = item.camera.name
        holder.earthDate.text = item.earth_date

        Glide.with(context)
            .load(item.img_src)
            .placeholder(R.drawable.ic_image_placeholder)
            .into(holder.marsImage)
    }

    fun updateList(marsImageData: ArrayList<MarsImageDataModel>){
        marsData.clear()
        marsData.addAll(marsImageData)
        submitList(marsData)
        notifyDataSetChanged()
    }

    inner class MarsImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val marsImage: AppCompatImageView = view.uiIvMarsImage
        val id: AppCompatTextView = view.uiTvId
        val camera: AppCompatTextView = view.uiTvCamera
        val earthDate: AppCompatTextView = view.uiTvEarthDate
        private val more: AppCompatTextView = view.uiTvMore

        init {
            more.setOnClickListener { onMoreDetailsClick.invoke(currentList[adapterPosition]) }
        }
    }
}