package io.voucherify.android.sample.store.injection.module.vouchers.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.details.VoucherAdminDetailsFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.details.VoucherAdminDetailsViewModel

@Module
class VoucherAdminDetailsModule {

    private class VoucherDetailsAdminViewModelFactory :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return VoucherAdminDetailsViewModel() as T
        }
    }

    @Provides
    @FragmentScope
    fun provideVoucherDetailsAdminViewModel(
        fragment: VoucherAdminDetailsFragment
    ): VoucherAdminDetailsViewModel =
        ViewModelProviders.of(
            fragment,
            VoucherDetailsAdminViewModelFactory()
        ).get(VoucherAdminDetailsViewModel::class.java)
}