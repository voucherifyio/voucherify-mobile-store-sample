package io.voucherify.android.sample.store.ui.customer.order

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.ui.customer.order.address.OrderAddressFragment
import io.voucherify.android.sample.store.ui.customer.order.payment.OrderPaymentDetailsFragment
import io.voucherify.android.sample.store.utils.views.ToolbarUtils

class OrderActivity : BaseActivity(), OrderViewDelegate {

    companion object Factory {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, OrderActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_order)

        if (savedInstanceState == null) {
            replaceFragment(
                containerId = R.id.order_fragment_container,
                fragment = OrderAddressFragment.newInstance(),
                tag = OrderAddressFragment.TAG
            )
        }
    }

    override fun onPaymentDetailsClick() {
        replaceFragmentWithBackStack(
            containerId = R.id.order_fragment_container,
            fragment = OrderPaymentDetailsFragment.newInstance(),
            tag = OrderPaymentDetailsFragment.TAG
        )
    }

    override fun onSummaryClick() {

    }

    override fun onTitleChange(title: String) {

        ToolbarUtils.initActionBarWithTitle(
            activity = this,
            title = title,
            backArrow = true
        )
    }
}