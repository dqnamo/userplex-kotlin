// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.services.async

import com.userplex.api.TestServerExtension
import com.userplex.api.client.okhttp.UserplexOkHttpClientAsync
import com.userplex.api.core.JsonValue
import com.userplex.api.models.events.EventNewParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EventServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun new() {
        val client =
            UserplexOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val eventServiceAsync = client.events()

        val response =
            eventServiceAsync.new(
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
            )

        response.validate()
    }
}
