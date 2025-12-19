// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.services.async

import com.userplex.api.core.ClientOptions
import com.userplex.api.core.RequestOptions
import com.userplex.api.core.handlers.errorBodyHandler
import com.userplex.api.core.handlers.errorHandler
import com.userplex.api.core.handlers.jsonHandler
import com.userplex.api.core.http.HttpMethod
import com.userplex.api.core.http.HttpRequest
import com.userplex.api.core.http.HttpResponse
import com.userplex.api.core.http.HttpResponse.Handler
import com.userplex.api.core.http.HttpResponseFor
import com.userplex.api.core.http.json
import com.userplex.api.core.http.parseable
import com.userplex.api.core.prepareAsync
import com.userplex.api.models.logs.LogBatchParams
import com.userplex.api.models.logs.LogBatchResponse
import com.userplex.api.models.logs.LogNewParams
import com.userplex.api.models.logs.LogNewResponse

class LogServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    LogServiceAsync {

    private val withRawResponse: LogServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): LogServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): LogServiceAsync =
        LogServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun batch(
        params: LogBatchParams,
        requestOptions: RequestOptions,
    ): LogBatchResponse =
        // post /api/logs/batch
        withRawResponse().batch(params, requestOptions).parse()

    override suspend fun new(params: LogNewParams, requestOptions: RequestOptions): LogNewResponse =
        // post /api/log
        withRawResponse().new(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        LogServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): LogServiceAsync.WithRawResponse =
            LogServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val batchHandler: Handler<LogBatchResponse> =
            jsonHandler<LogBatchResponse>(clientOptions.jsonMapper)

        override suspend fun batch(
            params: LogBatchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<LogBatchResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "logs", "batch")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { batchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val newHandler: Handler<LogNewResponse> =
            jsonHandler<LogNewResponse>(clientOptions.jsonMapper)

        override suspend fun new(
            params: LogNewParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<LogNewResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "log")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { newHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
