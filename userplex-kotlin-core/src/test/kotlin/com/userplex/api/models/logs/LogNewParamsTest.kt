// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.models.logs

import com.userplex.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogNewParamsTest {

    @Test
    fun create() {
        LogNewParams.builder()
            .name("name")
            .userId("user_id")
            .data(
                LogNewParams.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
            .properties(
                LogNewParams.Properties.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
            .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .build()
    }

    @Test
    fun body() {
        val params =
            LogNewParams.builder()
                .name("name")
                .userId("user_id")
                .data(
                    LogNewParams.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .properties(
                    LogNewParams.Properties.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.userId()).isEqualTo("user_id")
        assertThat(body.data())
            .isEqualTo(
                LogNewParams.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.properties())
            .isEqualTo(
                LogNewParams.Properties.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.timestamp()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = LogNewParams.builder().name("name").userId("user_id").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.userId()).isEqualTo("user_id")
    }
}
