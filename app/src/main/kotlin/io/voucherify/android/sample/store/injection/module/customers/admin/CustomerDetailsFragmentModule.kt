package io.voucherify.android.sample.store.injection.module.customers.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.customers.details.CustomerDetailsFragment

@Module
abstract class CustomerDetailsFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            CustomerDetailsModule::class]
    )
    abstract fun customerDetailsFragment(): CustomerDetailsFragment
}
