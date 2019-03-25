package io.voucherify.android.sample.store.injection.module.settings.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.customers.CustomersService
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.SettingsAdminFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.SettingsAdminViewModel

@Module
class SettingsAdminModule {

    private class SettingsAdminViewModelFactory(
        private val userService: UserService,
        private val customersService: CustomersService
    ) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SettingsAdminViewModel(
                userService = userService,
                customersService = customersService
            ) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideSettingsAdminViewModel(
        fragment: SettingsAdminFragment,
        userService: UserService,
        customersService: CustomersService
    ): SettingsAdminViewModel =
        ViewModelProviders.of(
            fragment,
            SettingsAdminViewModelFactory(
                userService = userService,
                customersService = customersService
            )
        ).get(SettingsAdminViewModel::class.java)

}