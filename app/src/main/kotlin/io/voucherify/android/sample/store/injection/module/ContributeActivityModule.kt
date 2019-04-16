package io.voucherify.android.sample.store.injection.module

import dagger.Module
import io.voucherify.android.sample.store.injection.module.customers.admin.CustomerDetailsActivityModule
import io.voucherify.android.sample.store.injection.module.dashboard.DashboardAdminActivityModule
import io.voucherify.android.sample.store.injection.module.dashboard.customer.DashboardCustomerActivityModule
import io.voucherify.android.sample.store.injection.module.history.details.CustomerOrderHistoryDetailsActivityModule
import io.voucherify.android.sample.store.injection.module.login.LoginActivityModule
import io.voucherify.android.sample.store.injection.module.onboarding.OnboardingActivityModule
import io.voucherify.android.sample.store.injection.module.order.OrderActivityModule
import io.voucherify.android.sample.store.injection.module.products.admin.ProductAdminDetailsActivityModule
import io.voucherify.android.sample.store.injection.module.products.customer.details.CustomerProductDetailsActivityModule
import io.voucherify.android.sample.store.injection.module.shoppingcart.ShoppingCartActivityModule
import io.voucherify.android.sample.store.injection.module.splash.SplashActivityModule
import io.voucherify.android.sample.store.injection.module.vouchers.admin.VoucherAdminDetailsActivityModule

@Module(
    includes = [
        SplashActivityModule::class,
        LoginActivityModule::class,
        DashboardAdminActivityModule::class,
        DashboardCustomerActivityModule::class,
        CustomerDetailsActivityModule::class,
        ProductAdminDetailsActivityModule::class,
        VoucherAdminDetailsActivityModule::class,
        OnboardingActivityModule::class,
        VoucherAdminDetailsActivityModule::class,
        CustomerProductDetailsActivityModule::class,
        ShoppingCartActivityModule::class,
        OrderActivityModule::class,
        CustomerOrderHistoryDetailsActivityModule::class
    ]
)
abstract class ContributeActivityModule