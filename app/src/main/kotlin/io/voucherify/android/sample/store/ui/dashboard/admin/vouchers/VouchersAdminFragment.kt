package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers

import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseFragment

class VouchersAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "VouchersAdminFragment"

        fun newInstance() = VouchersAdminFragment()
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_vouchers_admin

}