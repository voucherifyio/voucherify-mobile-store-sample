package io.voucherify.android.sample.store.injection.module.products.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.products.details.ProductAdminDetailsFragment

@Module
abstract class ProductAdminDetailsFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            ProductAdminDetailsModule::class]
    )
    abstract fun productAdminDetailsFragment(): ProductAdminDetailsFragment
}
