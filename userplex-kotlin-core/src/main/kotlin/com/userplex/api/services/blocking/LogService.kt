// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.userplex.api.core.ClientOptions
import com.userplex.api.core.RequestOptions
import com.userplex.api.core.http.HttpResponseFor
import com.userplex.api.models.logs.LogBatchParams
import com.userplex.api.models.logs.LogBatchResponse
import com.userplex.api.models.logs.LogNewParams
import com.userplex.api.models.logs.LogNewResponse

interface LogService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): LogService

    /**
     * Records multiple log occurrences in a single request. Requires a valid API key for
     * authentication.
     */
    fun batch(
        params: LogBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LogBatchResponse

    /**
     * Creates or uses an existing log and records a log occurrence for an end user. Requires a
     * valid API key for authentication.
     */
    fun new(
        params: LogNewParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LogNewResponse

    /** A view of [LogService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): LogService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/logs/batch`, but is otherwise the same as
         * [LogService.batch].
         */
        @MustBeClosed
        fun batch(
            params: LogBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LogBatchResponse>

        /**
         * Returns a raw HTTP response for `post /api/log`, but is otherwise the same as
         * [LogService.new].
         */
        @MustBeClosed
        fun new(
            params: LogNewParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LogNewResponse>
    }
}
