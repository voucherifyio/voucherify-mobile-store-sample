package io.voucherify.android.sample.store.ui.flow

import android.content.Context

interface Navigator {

    fun openSplashActivity(context: Context)

    fun openLoginActivity(context: Context)

    fun openDashboardAdminActivity(context: Context)
}