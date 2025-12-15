// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.userplex.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventNewResponseTest {

    @Test
    fun create() {
        val eventNewResponse = EventNewResponse.builder().success(true).build()

        assertThat(eventNewResponse.success()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventNewResponse = EventNewResponse.builder().success(true).build()

        val roundtrippedEventNewResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventNewResponse),
                jacksonTypeRef<EventNewResponse>(),
            )

        assertThat(roundtrippedEventNewResponse).isEqualTo(eventNewResponse)
    }
}
