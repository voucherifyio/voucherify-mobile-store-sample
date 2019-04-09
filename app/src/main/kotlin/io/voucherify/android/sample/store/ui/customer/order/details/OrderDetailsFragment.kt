package io.voucherify.android.sample.store.ui.customer.order.details

import android.app.Activity
import android.os.Bundle
import android.view.View
import io.voucherify.android.sample.store.R
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
    lateinit var navigator: Navigator

    private var parentViewDelegate: OrderViewDelegate? = null

    override fun fragmentLayoutId(): Int = R.layout.fragment_order_details

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        parentViewDelegate = activity as OrderViewDelegate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
    }

    override fun onResume() {
        super.onResume()

        parentViewDelegate?.onTitleChange(getString(R.string.title_order_details), hasBackArrow = true)
    }

    private fun setViews() {
        order_details_buy_button.setOnClickListener {
            parentViewDelegate?.onBuyClick()
        }
    }

}