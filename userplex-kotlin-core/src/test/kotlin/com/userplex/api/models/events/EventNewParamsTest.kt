// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.models.events

import com.userplex.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventNewParamsTest {

    @Test
    fun create() {
        EventNewParams.builder()
            .name("name")
            .userId("user_id")
            .properties(
                EventNewParams.Properties.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
            .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .build()
    }

    @Test
    fun body() {
        val params =
            EventNewParams.builder()
                .name("name")
                .userId("user_id")
                .properties(
                    EventNewParams.Properties.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.userId()).isEqualTo("user_id")
        assertThat(body.properties())
            .isEqualTo(
                EventNewParams.Properties.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.timestamp()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = EventNewParams.builder().name("name").userId("user_id").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.userId()).isEqualTo("user_id")
    }
}
