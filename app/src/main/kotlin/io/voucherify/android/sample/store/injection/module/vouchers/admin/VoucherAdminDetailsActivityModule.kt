package io.voucherify.android.sample.store.injection.module.vouchers.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.details.VoucherAdminDetailsActivity

@Module
abstract class VoucherAdminDetailsActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun voucherAdminDetailsActivity(): VoucherAdminDetailsActivity
}