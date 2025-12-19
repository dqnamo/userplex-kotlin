// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.models.logs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.userplex.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogBatchResponseTest {

    @Test
    fun create() {
        val logBatchResponse = LogBatchResponse.builder().count(0.0).success(true).build()

        assertThat(logBatchResponse.count()).isEqualTo(0.0)
        assertThat(logBatchResponse.success()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val logBatchResponse = LogBatchResponse.builder().count(0.0).success(true).build()

        val roundtrippedLogBatchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(logBatchResponse),
                jacksonTypeRef<LogBatchResponse>(),
            )

        assertThat(roundtrippedLogBatchResponse).isEqualTo(logBatchResponse)
    }
}
