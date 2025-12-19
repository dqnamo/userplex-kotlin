// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.models.logs

import com.userplex.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogBatchParamsTest {

    @Test
    fun create() {
        LogBatchParams.builder()
            .addLog(
                LogBatchParams.Log.builder()
                    .name("name")
                    .userId("user_id")
                    .data(
                        LogBatchParams.Log.Data.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .properties(
                        LogBatchParams.Log.Properties.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            LogBatchParams.builder()
                .addLog(
                    LogBatchParams.Log.builder()
                        .name("name")
                        .userId("user_id")
                        .data(
                            LogBatchParams.Log.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .properties(
                            LogBatchParams.Log.Properties.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.logs())
            .containsExactly(
                LogBatchParams.Log.builder()
                    .name("name")
                    .userId("user_id")
                    .data(
                        LogBatchParams.Log.Data.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .properties(
                        LogBatchParams.Log.Properties.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            LogBatchParams.builder()
                .addLog(LogBatchParams.Log.builder().name("name").userId("user_id").build())
                .build()

        val body = params._body()

        assertThat(body.logs())
            .containsExactly(LogBatchParams.Log.builder().name("name").userId("user_id").build())
    }
}
