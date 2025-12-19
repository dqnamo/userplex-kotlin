// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.models.logs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.userplex.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogNewResponseTest {

    @Test
    fun create() {
        val logNewResponse = LogNewResponse.builder().success(true).build()

        assertThat(logNewResponse.success()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val logNewResponse = LogNewResponse.builder().success(true).build()

        val roundtrippedLogNewResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(logNewResponse),
                jacksonTypeRef<LogNewResponse>(),
            )

        assertThat(roundtrippedLogNewResponse).isEqualTo(logNewResponse)
    }
}
