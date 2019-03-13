package io.voucherify.android.sample.store.injection.module

import dagger.Module
import io.voucherify.android.sample.store.injection.module.settings.admin.SettingsAdminFragmentModule

@Module(
    includes = [
        SettingsAdminFragmentModule::class
    ]
)
abstract class ContributeFragmentModule