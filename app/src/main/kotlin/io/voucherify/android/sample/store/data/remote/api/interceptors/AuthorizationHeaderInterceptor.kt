package io.voucherify.android.sample.store.data.remote.api.interceptors

import io.voucherify.android.sample.store.data.local.AccountLocalPreferencesStorable
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthorizationHeaderInterceptor(private val accountLocalPreferences: AccountLocalPreferencesStorable) : Interceptor {

    private val HEADER_AUTHORIZATION = "Authorization"
    private val HEADER_NO_AUTHORIZATION = "No-Authorization"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        if (request.header(HEADER_NO_AUTHORIZATION) == null) {
            val id = accountLocalPreferences.load()?.id ?: ""

            request = request.newBuilder()
                    .header(HEADER_AUTHORIZATION, "Bearer $id")
                    .build()
        }

        return chain.proceed(request)
    }
}