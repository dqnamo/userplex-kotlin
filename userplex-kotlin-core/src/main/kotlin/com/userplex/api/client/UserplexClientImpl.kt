// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.client

import com.userplex.api.core.ClientOptions
import com.userplex.api.core.getPackageVersion
import com.userplex.api.services.blocking.EventService
import com.userplex.api.services.blocking.EventServiceImpl
import com.userplex.api.services.blocking.UserService
import com.userplex.api.services.blocking.UserServiceImpl

class UserplexClientImpl(private val clientOptions: ClientOptions) : UserplexClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: UserplexClientAsync by lazy { UserplexClientAsyncImpl(clientOptions) }

    private val withRawResponse: UserplexClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val users: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    private val events: EventService by lazy { EventServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): UserplexClientAsync = async

    override fun withRawResponse(): UserplexClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UserplexClient =
        UserplexClientImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun users(): UserService = users

    override fun events(): EventService = events

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UserplexClient.WithRawResponse {

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val events: EventService.WithRawResponse by lazy {
            EventServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): UserplexClient.WithRawResponse =
            UserplexClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun users(): UserService.WithRawResponse = users

        override fun events(): EventService.WithRawResponse = events
    }
}
