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
import com.userplex.api.models.events.EventNewParams
import com.userplex.api.models.events.EventNewResponse

class EventServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    EventServiceAsync {

    private val withRawResponse: EventServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): EventServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EventServiceAsync =
        EventServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun new(
        params: EventNewParams,
        requestOptions: RequestOptions,
    ): EventNewResponse =
        // post /api/event
        withRawResponse().new(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EventServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): EventServiceAsync.WithRawResponse =
            EventServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val newHandler: Handler<EventNewResponse> =
            jsonHandler<EventNewResponse>(clientOptions.jsonMapper)

        override suspend fun new(
            params: EventNewParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EventNewResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "event")
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
