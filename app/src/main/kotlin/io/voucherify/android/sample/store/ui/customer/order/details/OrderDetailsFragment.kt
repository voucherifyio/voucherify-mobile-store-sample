package io.voucherify.android.sample.store.ui.customer.order.details

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.customer.order.OrderViewDelegate
import io.voucherify.android.sample.store.ui.flow.Navigator
import kotlinx.android.synthetic.main.fragment_order_details.*
import javax.inject.Inject

class OrderDetailsFragment : BaseFragment() {

    companion object {
        const val TAG = "OrderDetailsFragment"

        fun newInstance() = OrderDetailsFragment()
    }

    @Inject
    lateinit var viewModel: OrderDetailsViewModel

    @Inject
    lateinit var navigator: Navigator

    private var parentViewDelegate: OrderViewDelegate? = null

    override fun fragmentLayoutId(): Int = R.layout.fragment_order_details

    private val customerDataObserver = Observer<LocalCustomer> { customer ->
        order_details_address_details.text = "${customer.name}\n${customer.address}"
    }

    private val orderCostObserver = Observer<Double> { cost ->
        order_details_cost_value.text = "$cost"
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        parentViewDelegate = activity as OrderViewDelegate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBindings()
        setViews()
    }

    override fun onResume() {
        super.onResume()

        parentViewDelegate?.onTitleChange(getString(R.string.title_order_details), hasBackArrow = true)
    }

    private fun setBindings() {

        viewModel.outputCustomerData()
            .observe(this, customerDataObserver)

        viewModel.outputOderCost()
            .observe(this, orderCostObserver)
    }

    private fun setViews() {
        order_details_buy_button.setOnClickListener {

            viewModel.buy()

            parentViewDelegate?.onBuyClick()
        }
    }

}