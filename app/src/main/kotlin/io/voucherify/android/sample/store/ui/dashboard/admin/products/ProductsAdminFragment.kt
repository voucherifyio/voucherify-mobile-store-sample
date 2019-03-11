package io.voucherify.android.sample.store.ui.dashboard.admin.products

import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseFragment

class ProductsAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "ProductsAdminFragment"

        fun newInstance() = ProductsAdminFragment()
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_products_admin

}