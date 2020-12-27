package dev.mustaq.martian.responsehandler


/**
Created by Mustaq Sameer on 27/12/20
 **/

sealed class CustomResponse<out V, out E> {

    data class Success<out V>(val data: V) : CustomResponse<V, Nothing>()

    data class Failure<out E>(val error: E) : CustomResponse<Nothing, E>()

}