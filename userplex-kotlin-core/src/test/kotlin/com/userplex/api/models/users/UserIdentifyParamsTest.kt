// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.models.users

import com.userplex.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserIdentifyParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.userId()).isEqualTo("user_id")
        assertThat(body.email()).isEqualTo("dev@stainless.com")
        assertThat(body.name()).isEqualTo("name")
        assertThat(body.properties())
            .isEqualTo(
                UserIdentifyParams.Properties.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = UserIdentifyParams.builder().userId("user_id").build()

        val body = params._body()

        assertThat(body.userId()).isEqualTo("user_id")
    }
}
