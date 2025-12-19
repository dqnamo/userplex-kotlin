// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.client

import com.userplex.api.core.ClientOptions
import com.userplex.api.core.getPackageVersion
import com.userplex.api.services.async.LogServiceAsync
import com.userplex.api.services.async.LogServiceAsyncImpl
import com.userplex.api.services.async.UserServiceAsync
import com.userplex.api.services.async.UserServiceAsyncImpl

class UserplexClientAsyncImpl(private val clientOptions: ClientOptions) : UserplexClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: UserplexClient by lazy { UserplexClientImpl(clientOptions) }

    private val withRawResponse: UserplexClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val logs: LogServiceAsync by lazy { LogServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): UserplexClient = sync

    override fun withRawResponse(): UserplexClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UserplexClientAsync =
        UserplexClientAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun users(): UserServiceAsync = users

    override fun logs(): LogServiceAsync = logs

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UserplexClientAsync.WithRawResponse {

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val logs: LogServiceAsync.WithRawResponse by lazy {
            LogServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): UserplexClientAsync.WithRawResponse =
            UserplexClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun users(): UserServiceAsync.WithRawResponse = users

        override fun logs(): LogServiceAsync.WithRawResponse = logs
    }
}
