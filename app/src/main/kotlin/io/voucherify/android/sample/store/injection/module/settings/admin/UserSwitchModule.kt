package io.voucherify.android.sample.store.injection.module.settings.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.pickers.UserSwitchBottomSheetDialogFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.pickers.UserSwitchViewModel

@Module
class UserSwitchModule {

    private class UserSwitchViewModelFactory(
        private val customerPerspectiveService: CustomerPerspectiveService
    ) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return UserSwitchViewModel(
                customerPerspectiveService = customerPerspectiveService
            ) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideUserSwitchViewModel(
        fragment: UserSwitchBottomSheetDialogFragment,
        customerPerspectiveService: CustomerPerspectiveService
    ): UserSwitchViewModel =
        ViewModelProviders.of(
            fragment,
            UserSwitchViewModelFactory(
                customerPerspectiveService = customerPerspectiveService
            )
        ).get(UserSwitchViewModel::class.java)

}