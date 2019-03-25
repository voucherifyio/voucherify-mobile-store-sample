package io.voucherify.android.sample.store.injection.module.settings.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.pickers.UserSwitchBottomSheetDialogFragment

@Module
abstract class UserSwitchFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            UserSwitchModule::class]
    )
    abstract fun userSwitchBottomSheetDialogFragment(): UserSwitchBottomSheetDialogFragment
}