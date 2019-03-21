package io.voucherify.android.sample.store.injection.module.vouchers.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.details.VoucherAdminDetailsFragment

@Module
abstract class VoucherAdminDetailsFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            VoucherAdminDetailsModule::class]
    )
    abstract fun voucherAdminDetailsFragment(): VoucherAdminDetailsFragment
}
