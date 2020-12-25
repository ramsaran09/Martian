package dev.mustaq.martian.model

import android.os.Bundle


/**
Created by Mustaq Sameer on 25/12/20
 **/

data class NavigationModel(
    val clazz: Class<*>,
    val finishCurrent: Boolean = false,
    val extras: Bundle? = null
)