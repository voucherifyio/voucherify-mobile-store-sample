package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers

import android.os.Bundle
import android.view.View
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_vouchers_admin.*
import javax.inject.Inject

class VouchersAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "VouchersAdminFragment"

        fun newInstance() = VouchersAdminFragment()
    }

    @Inject
    lateinit var viewModel: VouchersAdminViewModel

    override fun fragmentLayoutId(): Int = R.layout.fragment_vouchers_admin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTabs()

        viewModel.fetchVouchers()
    }

    private fun initTabs() {

        activity?.let {
            val adapter = VouchersAdminTabsFragmentAdapter(it.supportFragmentManager, it)
            vouchers_admin_tabs_pager.adapter = adapter
            vouchers_admin_tabs_layout.setupWithViewPager(vouchers_admin_tabs_pager)
        }
    }
}