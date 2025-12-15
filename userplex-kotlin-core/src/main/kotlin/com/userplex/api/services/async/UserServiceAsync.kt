// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.userplex.api.core.ClientOptions
import com.userplex.api.core.RequestOptions
import com.userplex.api.core.http.HttpResponseFor
import com.userplex.api.models.users.UserIdentifyParams
import com.userplex.api.models.users.UserIdentifyResponse

interface UserServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UserServiceAsync

    /**
     * Creates or updates an end user in InstantDB with the provided information. Requires a valid
     * API key for authentication.
     */
    suspend fun identify(
        params: UserIdentifyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserIdentifyResponse

    /** A view of [UserServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UserServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/identify`, but is otherwise the same as
         * [UserServiceAsync.identify].
         */
        @MustBeClosed
        suspend fun identify(
            params: UserIdentifyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserIdentifyResponse>
    }
}
