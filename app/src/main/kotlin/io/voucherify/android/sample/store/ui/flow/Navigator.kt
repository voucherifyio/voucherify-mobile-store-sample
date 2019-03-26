package io.voucherify.android.sample.store.ui.flow

import android.content.Context
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse

interface Navigator {

    fun openSplashActivity(context: Context)

    fun openLoginActivity(context: Context)

    fun openDashboardAdminActivity(context: Context)

    fun openDashboardCustomerActivity(context: Context)

    fun openCustomerDetails(context: Context, customerResponse: CustomerResponse)

    fun openAdminProductDetails(context: Context, productResponse: ProductResponse)

    fun openCustomerProductDetails(context: Context, productResponse: ProductResponse)

    fun openVoucherAdminDetails(context: Context, voucherResponse: VoucherResponse)
}