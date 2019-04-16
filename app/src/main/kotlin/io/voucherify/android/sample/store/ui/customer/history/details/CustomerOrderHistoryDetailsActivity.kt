package io.voucherify.android.sample.store.ui.customer.history.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalOrder
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.utils.views.ToolbarUtils

class CustomerOrderHistoryDetailsActivity: BaseActivity() {

    companion object Factory {

        const val ORDER_HISTORY_DETAILS_KEY = "order_history_details_key"

        @JvmStatic
        fun createIntent(context: Context, order: LocalOrder) =
            Intent(context, CustomerOrderHistoryDetailsActivity::class.java).apply {
                putExtra(ORDER_HISTORY_DETAILS_KEY, order)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_order_history_details_customer)

        val order = intent.getParcelableExtra<LocalOrder>(ORDER_HISTORY_DETAILS_KEY)

        ToolbarUtils.initActionBarWithTitle(activity = this, title = order.id, backArrow = true)

        if(savedInstanceState == null) {
            addFragment(
                R.id.order_history_details_customer_fragment_container,
                CustomerOrderHistoryDetailsFragment.newInstance(order = order),
                CustomerOrderHistoryDetailsFragment.TAG)
        }
    }
}