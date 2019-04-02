package io.voucherify.android.sample.store.injection.module.shoppingcart

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.customer.shoppingcart.ShoppingCartActivity

@Module
abstract class ShoppingCartActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            ShoppingCartModule::class]
    )
    abstract fun shoppingCartActivity(): ShoppingCartActivity
}