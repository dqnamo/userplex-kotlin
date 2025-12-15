// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.errors

import com.userplex.api.core.JsonValue
import com.userplex.api.core.http.Headers

abstract class UserplexServiceException
protected constructor(message: String, cause: Throwable? = null) :
    UserplexException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
