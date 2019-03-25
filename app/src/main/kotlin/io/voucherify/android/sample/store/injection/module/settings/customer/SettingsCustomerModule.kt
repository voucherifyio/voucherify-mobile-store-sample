package io.voucherify.android.sample.store.injection.module.settings.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.settings.SettingsCustomerFragment
import io.voucherify.android.sample.store.ui.customer.settings.SettingsCustomerViewModel

@Module
class SettingsCustomerModule {

    private class SettingsCustomerViewModelFactory(
        private val customerPerspectiveService: CustomerPerspectiveService
    ) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SettingsCustomerViewModel(
                customerPerspectiveService = customerPerspectiveService
            ) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideSettingsAdminViewModel(
        fragment: SettingsCustomerFragment,
        customerPerspectiveService: CustomerPerspectiveService
    ): SettingsCustomerViewModel =
        ViewModelProviders.of(
            fragment,
            SettingsCustomerViewModelFactory(
                customerPerspectiveService = customerPerspectiveService
            )
        ).get(SettingsCustomerViewModel::class.java)

}