package dev.mustaq.martian.helper

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


/**
Created by Mustaq Sameer on 25/12/20
 **/

fun <T> LiveData<T>.observeLiveData(lifecycleOwner: LifecycleOwner, function: (T) -> Unit) {
    this.observe(lifecycleOwner, Observer {
        if (it != null)
            function.invoke(it)
    })
}