package io.voucherify.android.sample.store.injection.module.products.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.products.ProductsAdminFragment

@Module
abstract class ProductsAdminFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            ProductsAdminModule::class]
    )
    abstract fun productsAdminFragment(): ProductsAdminFragment

}
