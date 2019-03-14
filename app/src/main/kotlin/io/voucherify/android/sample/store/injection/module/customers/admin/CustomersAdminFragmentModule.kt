package io.voucherify.android.sample.store.injection.module.customers.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.customers.CustomersAdminFragment

@Module
abstract class CustomersAdminFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            CustomersAdminModule::class]
    )
    abstract fun customersAdminFragment(): CustomersAdminFragment
}