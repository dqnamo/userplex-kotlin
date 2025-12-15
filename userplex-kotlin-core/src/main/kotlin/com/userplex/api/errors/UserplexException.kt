package com.userplex.api.errors

open class UserplexException(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
