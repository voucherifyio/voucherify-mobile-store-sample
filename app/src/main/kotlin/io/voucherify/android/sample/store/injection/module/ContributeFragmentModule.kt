package io.voucherify.android.sample.store.injection.module

import dagger.Module
import io.voucherify.android.sample.store.injection.module.customers.admin.CustomerDetailsFragmentModule
import io.voucherify.android.sample.store.injection.module.customers.admin.CustomersAdminFragmentModule
import io.voucherify.android.sample.store.injection.module.products.admin.ProductAdminDetailsFragmentModule
import io.voucherify.android.sample.store.injection.module.products.admin.ProductsAdminFragmentModule
import io.voucherify.android.sample.store.injection.module.settings.admin.SettingsAdminFragmentModule
import io.voucherify.android.sample.store.injection.module.vouchers.admin.VouchersAdminFragmentModule

@Module(
    includes = [
        SettingsAdminFragmentModule::class,
        CustomersAdminFragmentModule::class,
        CustomerDetailsFragmentModule::class,
        ProductsAdminFragmentModule::class,
        ProductAdminDetailsFragmentModule::class,
        VouchersAdminFragmentModule::class
    ]
)
abstract class ContributeFragmentModule