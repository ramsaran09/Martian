package dev.mustaq.martian.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dev.mustaq.martian.R
import dev.mustaq.martian.adapter.MarsImageAdapter
import dev.mustaq.martian.helper.observeLiveData
import dev.mustaq.martian.helper.startActivity
import dev.mustaq.martian.model.MarsImageDataModel
import dev.mustaq.martian.model.NavigationModel
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
Created by Mustaq Sameer on 25/12/20
 **/
class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val marsImageAdapter by lazy { MarsImageAdapter(this, ::onMoreDetailClick) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupUi()
    }

    private fun setupUi() {
        setupAdapter()
        homeViewModel.navigate.observeLiveData(this, ::navigate)
        homeViewModel.error.observeLiveData(this, ::handleError)
        homeViewModel.loader.observeLiveData(this, ::handleLoaderVisibility)
        homeViewModel.marsImageData.observeLiveData(this, ::addListToAdapter)
    }

    private fun setupAdapter() {
        uiRvMarsImages.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = marsImageAdapter
        }
    }

    private fun navigate(navigationModel: NavigationModel) {
        startActivity(navigationModel)
    }

    private fun onMoreDetailClick(marsImageDataModel: MarsImageDataModel) {
        homeViewModel.moreDetails(marsImageDataModel)
    }

    private fun handleError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    private fun handleLoaderVisibility(isLoading: Boolean) {
        uiAnimationLoader.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun addListToAdapter(marsImageData: ArrayList<MarsImageDataModel>) {
        marsImageAdapter.updateList(marsImageData)
    }
}