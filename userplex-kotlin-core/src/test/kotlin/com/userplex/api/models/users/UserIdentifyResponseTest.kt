// File generated from our OpenAPI spec by Stainless.

package com.userplex.api.models.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.userplex.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserIdentifyResponseTest {

    @Test
    fun create() {
        val userIdentifyResponse = UserIdentifyResponse.builder().success(true).build()

        assertThat(userIdentifyResponse.success()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userIdentifyResponse = UserIdentifyResponse.builder().success(true).build()

        val roundtrippedUserIdentifyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userIdentifyResponse),
                jacksonTypeRef<UserIdentifyResponse>(),
            )

        assertThat(roundtrippedUserIdentifyResponse).isEqualTo(userIdentifyResponse)
    }
}
