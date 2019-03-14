package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import android.os.Bundle
import android.view.View
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseFragment
import javax.inject.Inject

class CustomersAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "CustomersAdminFragment"

        fun newInstance() = CustomersAdminFragment()
    }

    @Inject
    lateinit var viewModel: CustomersAdminViewModel

    override fun fragmentLayoutId(): Int = R.layout.fragment_customers_admin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchCustomers()
    }

}