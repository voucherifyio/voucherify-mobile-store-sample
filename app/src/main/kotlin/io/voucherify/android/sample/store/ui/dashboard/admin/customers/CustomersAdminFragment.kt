package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseFragment

class CustomersAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "CustomersAdminFragment"

        fun newInstance() = CustomersAdminFragment()
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_customers_admin

}