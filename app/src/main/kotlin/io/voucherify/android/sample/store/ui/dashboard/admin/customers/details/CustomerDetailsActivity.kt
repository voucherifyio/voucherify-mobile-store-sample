package io.voucherify.android.sample.store.ui.dashboard.admin.customers.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.utils.views.ToolbarUtils

class CustomerDetailsActivity: BaseActivity() {

    companion object Factory {

        val CUSTOMER_DETAILS_KEY = "customer_details_key"

        @JvmStatic
        fun createIntent(context: Context, customer: CustomerResponse) =
            Intent(context, CustomerDetailsActivity::class.java).apply {
                putExtra(CUSTOMER_DETAILS_KEY, customer)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_customer_details)

        val customer = intent.getParcelableExtra<CustomerResponse>(CUSTOMER_DETAILS_KEY)

        ToolbarUtils.initActionBarWithTitle(activity = this, title = customer.name ?: "")

        if(savedInstanceState == null) {
            addFragment(
                R.id.customer_details_fragment_container,
                CustomerDetailsFragment.newInstance(customer = customer))
        }
    }
}