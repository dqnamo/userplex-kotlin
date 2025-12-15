// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.services.blocking

import com.userplex.api.TestServerExtension
import com.userplex.api.client.okhttp.UserplexOkHttpClient
import com.userplex.api.core.JsonValue
import com.userplex.api.models.users.UserIdentifyParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UserServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun identify() {
        val client =
            UserplexOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()

        val response =
            userService.identify(
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
