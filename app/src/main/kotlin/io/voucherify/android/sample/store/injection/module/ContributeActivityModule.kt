package io.voucherify.android.sample.store.injection.module

import dagger.Module
import io.voucherify.android.sample.store.injection.module.customers.admin.CustomerDetailsActivityModule
import io.voucherify.android.sample.store.injection.module.dashboard.DashboardAdminActivityModule
import io.voucherify.android.sample.store.injection.module.login.LoginActivityModule
import io.voucherify.android.sample.store.injection.module.products.admin.ProductAdminDetailsActivityModule
import io.voucherify.android.sample.store.injection.module.splash.SplashActivityModule
import io.voucherify.android.sample.store.injection.module.vouchers.admin.VoucherAdminDetailsActivityModule

@Module(
    includes = [
        SplashActivityModule::class,
        LoginActivityModule::class,
        DashboardAdminActivityModule::class,
        CustomerDetailsActivityModule::class,
        ProductAdminDetailsActivityModule::class,
        VoucherAdminDetailsActivityModule::class
    ]
)
abstract class ContributeActivityModule