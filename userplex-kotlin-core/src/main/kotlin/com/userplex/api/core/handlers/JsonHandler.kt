@file:JvmName("JsonHandler")

package com.userplex.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.userplex.api.core.http.HttpResponse
import com.userplex.api.core.http.HttpResponse.Handler
import com.userplex.api.errors.UserplexInvalidDataException

internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            try {
                return jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw UserplexInvalidDataException("Error reading response", e)
            }
        }
    }
