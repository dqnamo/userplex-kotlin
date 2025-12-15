// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.services.async

import com.userplex.api.TestServerExtension
import com.userplex.api.client.okhttp.UserplexOkHttpClientAsync
import com.userplex.api.core.JsonValue
import com.userplex.api.models.users.UserIdentifyParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UserServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun identify() {
        val client =
            UserplexOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.users()

        val response =
            userServiceAsync.identify(
                UserIdentifyParams.builder()
                    .userId("user_id")
                    .email("dev@stainless.com")
                    .name("name")
                    .properties(
                        UserIdentifyParams.Properties.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        response.validate()
    }
}
