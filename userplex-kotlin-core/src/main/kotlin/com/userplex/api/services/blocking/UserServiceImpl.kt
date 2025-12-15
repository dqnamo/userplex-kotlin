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
import com.userplex.api.models.users.UserIdentifyParams
import com.userplex.api.models.users.UserIdentifyResponse

class UserServiceImpl internal constructor(private val clientOptions: ClientOptions) : UserService {

    private val withRawResponse: UserService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): UserService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UserService =
        UserServiceImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun identify(
        params: UserIdentifyParams,
        requestOptions: RequestOptions,
    ): UserIdentifyResponse =
        // post /api/identify
        withRawResponse().identify(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UserService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): UserService.WithRawResponse =
            UserServiceImpl.WithRawResponseImpl(clientOptions.toBuilder().apply(modifier).build())

        private val identifyHandler: Handler<UserIdentifyResponse> =
            jsonHandler<UserIdentifyResponse>(clientOptions.jsonMapper)

        override fun identify(
            params: UserIdentifyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserIdentifyResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "identify")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { identifyHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
