package com.userplex.api.errors

class UserplexInvalidDataException(message: String? = null, cause: Throwable? = null) :
    UserplexException(message, cause)
