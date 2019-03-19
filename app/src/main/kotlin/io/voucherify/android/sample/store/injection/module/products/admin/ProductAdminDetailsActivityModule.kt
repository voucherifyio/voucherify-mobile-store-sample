package io.voucherify.android.sample.store.injection.module.products.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.dashboard.admin.products.details.ProductAdminDetailsActivity

@Module
abstract class ProductAdminDetailsActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun productAdminDetailsActivity(): ProductAdminDetailsActivity
}