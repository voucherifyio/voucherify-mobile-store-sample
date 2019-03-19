package io.voucherify.android.sample.store.ui.flow

import android.content.Context
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse

interface Navigator {

    fun openSplashActivity(context: Context)

    fun openLoginActivity(context: Context)

    fun openDashboardAdminActivity(context: Context)

    fun openCustomerDetails(context: Context, customerResponse: CustomerResponse)

    fun openProductAdminDetails(context: Context, productResponse: ProductResponse)
}