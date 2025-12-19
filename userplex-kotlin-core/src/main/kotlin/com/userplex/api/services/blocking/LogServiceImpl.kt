// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.services.blocking

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
import com.userplex.api.core.prepare
import com.userplex.api.models.logs.LogBatchParams
import com.userplex.api.models.logs.LogBatchResponse
import com.userplex.api.models.logs.LogNewParams
import com.userplex.api.models.logs.LogNewResponse

class LogServiceImpl internal constructor(private val clientOptions: ClientOptions) : LogService {

    private val withRawResponse: LogService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): LogService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): LogService =
        LogServiceImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun batch(params: LogBatchParams, requestOptions: RequestOptions): LogBatchResponse =
        // post /api/logs/batch
        withRawResponse().batch(params, requestOptions).parse()

    override fun new(params: LogNewParams, requestOptions: RequestOptions): LogNewResponse =
        // post /api/log
        withRawResponse().new(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        LogService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): LogService.WithRawResponse =
            LogServiceImpl.WithRawResponseImpl(clientOptions.toBuilder().apply(modifier).build())

        private val batchHandler: Handler<LogBatchResponse> =
            jsonHandler<LogBatchResponse>(clientOptions.jsonMapper)

        override fun batch(
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
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

        override fun new(
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
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
