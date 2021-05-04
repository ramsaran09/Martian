package dev.muthuram.martian.helper

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData


fun <T> LiveData<T>.observeLiveData(lifecycleOwner: LifecycleOwner, function: (T) -> Unit) {
    this.observe(lifecycleOwner, {
        if (it != null)
            function.invoke(it)
    })
}