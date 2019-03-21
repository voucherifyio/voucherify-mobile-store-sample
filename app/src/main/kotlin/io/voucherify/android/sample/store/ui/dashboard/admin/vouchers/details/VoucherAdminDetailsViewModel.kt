package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class VoucherAdminDetailsViewModel : BaseViewModel() {

    private val voucherDetailsLiveData: MutableLiveData<VoucherResponse> = MutableLiveData()

    fun setData(voucher: VoucherResponse) {
        voucherDetailsLiveData.value = voucher
    }

    fun outputCustomerDetailsData(): LiveData<VoucherResponse> {
        return voucherDetailsLiveData
    }

}
