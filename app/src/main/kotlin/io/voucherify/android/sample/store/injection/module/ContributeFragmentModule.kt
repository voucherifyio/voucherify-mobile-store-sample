package io.voucherify.android.sample.store.injection.module

import dagger.Module
import io.voucherify.android.sample.store.injection.module.customers.admin.CustomersAdminFragmentModule
import io.voucherify.android.sample.store.injection.module.settings.admin.SettingsAdminFragmentModule

@Module(
    includes = [
        SettingsAdminFragmentModule::class,
        CustomersAdminFragmentModule::class
    ]
)
abstract class ContributeFragmentModule