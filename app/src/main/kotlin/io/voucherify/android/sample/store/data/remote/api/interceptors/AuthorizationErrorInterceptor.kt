package io.voucherify.android.sample.store.data.remote.api.interceptors

import android.content.Context
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.ui.flow.Navigator
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationErrorInterceptor(
    private val context: Context,
    private val userService: UserService,
    private val navigator: Navigator
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val response = chain.proceed(request)

        if (response.code() == 401) {
            userService.removeCurrentUser()
            navigator.openLoginActivity(context = context)
        }

        return response
    }
}
