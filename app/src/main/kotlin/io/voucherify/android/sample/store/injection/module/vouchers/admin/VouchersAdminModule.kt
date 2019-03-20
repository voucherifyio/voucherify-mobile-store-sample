package io.voucherify.android.sample.store.injection.module.vouchers.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.vouchers.VouchersService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.VouchersAdminFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.VouchersAdminViewModel

@Module
class VouchersAdminModule {

    private class VouchersAdminViewModelFactory(private val vouchersService: VouchersService) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return VouchersAdminViewModel(vouchersService = vouchersService) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideVouchersAdminViewModel(
        fragment: VouchersAdminFragment,
        vouchersService: VouchersService
    ): VouchersAdminViewModel =
        ViewModelProviders.of(
            fragment,
            VouchersAdminViewModelFactory(vouchersService = vouchersService)
        ).get(VouchersAdminViewModel::class.java)

}