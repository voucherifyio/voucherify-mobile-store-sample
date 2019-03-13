package io.voucherify.android.sample.store.injection.module.settings.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.SettingsAdminFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.SettingsAdminViewModel

@Module
class SettingsAdminModule {

    private class SettingsAdminViewModelFactory(private val userService: UserService) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SettingsAdminViewModel(userService = userService) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideSettingsAdminViewModel(fragment: SettingsAdminFragment, userService: UserService): SettingsAdminViewModel =
        ViewModelProviders.of(
            fragment,
            SettingsAdminViewModelFactory(userService = userService)
        ).get(SettingsAdminViewModel::class.java)

}