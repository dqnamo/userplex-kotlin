// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.userplex.api.core.ClientOptions
import com.userplex.api.core.RequestOptions
import com.userplex.api.core.http.HttpResponseFor
import com.userplex.api.models.events.EventNewParams
import com.userplex.api.models.events.EventNewResponse

interface EventService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EventService

    /**
     * Creates or uses an existing event and records an event occurrence for an end user. Requires a
     * valid API key for authentication.
     */
    fun new(
        params: EventNewParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventNewResponse

    /** A view of [EventService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EventService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/event`, but is otherwise the same as
         * [EventService.new].
         */
        @MustBeClosed
        fun new(
            params: EventNewParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventNewResponse>
    }
}
