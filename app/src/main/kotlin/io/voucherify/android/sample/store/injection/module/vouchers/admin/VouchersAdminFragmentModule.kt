package io.voucherify.android.sample.store.injection.module.vouchers.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.VouchersAdminFragment

@Module
abstract class VouchersAdminFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            VouchersAdminModule::class]
    )
    abstract fun vouchersAdminFragment(): VouchersAdminFragment

}
