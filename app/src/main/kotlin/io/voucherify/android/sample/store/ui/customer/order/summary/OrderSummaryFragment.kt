package io.voucherify.android.sample.store.ui.customer.order.summary

import android.app.Activity
import android.os.Bundle
import android.view.View
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.customer.order.OrderViewDelegate
import io.voucherify.android.sample.store.ui.flow.Navigator
import kotlinx.android.synthetic.main.fragment_order_summary.*
import javax.inject.Inject

class OrderSummaryFragment : BaseFragment() {

    companion object {
        const val TAG = "OrderSummaryFragment"

        fun newInstance() = OrderSummaryFragment()
    }

    @Inject
    lateinit var navigator: Navigator

    private var parentViewDelegate: OrderViewDelegate? = null

    override fun fragmentLayoutId(): Int = R.layout.fragment_order_summary

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

        parentViewDelegate?.onTitleChange(getString(R.string.title_order_summary), hasBackArrow = false)
    }

    private fun setViews() {
        order_summary_history_button.setOnClickListener {
            parentViewDelegate?.onHistoryClick()
        }
    }

}