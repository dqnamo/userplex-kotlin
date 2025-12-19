// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.services.async

import com.userplex.api.TestServerExtension
import com.userplex.api.client.okhttp.UserplexOkHttpClientAsync
import com.userplex.api.core.JsonValue
import com.userplex.api.models.logs.LogBatchParams
import com.userplex.api.models.logs.LogNewParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class LogServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun batch() {
        val client =
            UserplexOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val logServiceAsync = client.logs()

        val response =
            logServiceAsync.batch(
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
            )

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun new() {
        val client =
            UserplexOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val logServiceAsync = client.logs()

        val response =
            logServiceAsync.new(
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
            )

        response.validate()
    }
}
