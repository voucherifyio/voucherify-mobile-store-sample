package io.voucherify.android.sample.store.injection.module.customers.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.customers.CustomersService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.customers.CustomersAdminFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.customers.CustomersAdminViewModel

@Module
class CustomersAdminModule {

    private class CustomersAdminViewModelFactory(private val customersService: CustomersService) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CustomersAdminViewModel(customersService = customersService) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideCustomersAdminViewModel(
        fragment: CustomersAdminFragment,
        customersService: CustomersService
    ): CustomersAdminViewModel =
        ViewModelProviders.of(
            fragment,
            CustomersAdminViewModelFactory(customersService = customersService)
        ).get(CustomersAdminViewModel::class.java)

}