package io.voucherify.android.sample.store.ui.dashboard.admin.customers.details

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.ui.base.BaseFragment
import kotlinx.android.synthetic.main.customer_profile_header.*
import kotlinx.android.synthetic.main.customer_profile_stats_bar.*
import kotlinx.android.synthetic.main.fragment_customer_details.*
import javax.inject.Inject

class CustomerDetailsFragment : BaseFragment() {

    companion object {
        const val TAG = "CustomerDetailsFragment"

        fun newInstance(customer: CustomerResponse) = CustomerDetailsFragment().apply {
            val bundle = Bundle()
            bundle.putParcelable(CustomerDetailsActivity.CUSTOMER_DETAILS_KEY, customer)
            arguments = bundle
        }
    }

    @Inject
    lateinit var viewModel: CustomerDetailsViewModel

    private val dataObserver = Observer<CustomerResponse> { result ->
        customer_profile_header_name.text = result.name ?: "-"
        customer_profile_header_email.text = result.email ?: "-"

        customer_profile_bar_orders_amount.text = "${result.summary.orders.totalAmount}"
        customer_profile_bar_orders_count.text = "${result.summary.orders.totalCount}"
        customer_profile_bar_total_redeemed.text = "${result.summary.redemptions.totalRedeemed}"

        customer_profile_description.text = result.description ?: "-"
        customer_profile_city.text = result.address.city ?: "-"
        customer_profile_email.text = result.email ?: "-"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getParcelable<CustomerResponse>(CustomerDetailsActivity.CUSTOMER_DETAILS_KEY)?.let {
            viewModel.setData(
                customerDetails = it
            )
        }
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_customer_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBindings()
    }

    private fun setBindings() {

        viewModel
            .outputCustomerDetailsData()
            .observe(this, dataObserver)
    }
}