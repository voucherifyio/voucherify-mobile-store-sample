package io.voucherify.android.sample.store.ui.customer.order.address

import android.os.Bundle
import android.view.View
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import kotlinx.android.synthetic.main.fragment_order_address.*
import javax.inject.Inject

class OrderAddressFragment : BaseFragment() {

    companion object {
        const val TAG = "OrderAddressFragment"

        fun newInstance() = OrderAddressFragment()
    }

    @Inject
    lateinit var navigator: Navigator

    override fun fragmentLayoutId(): Int = R.layout.fragment_order_address

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
    }

    private fun setViews() {
        payment_details_order_address_button.setOnClickListener {

        }
    }
}