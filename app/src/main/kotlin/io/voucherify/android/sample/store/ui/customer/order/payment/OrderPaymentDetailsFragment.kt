package io.voucherify.android.sample.store.ui.customer.order.payment

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.customer.order.OrderViewDelegate
import io.voucherify.android.sample.store.ui.flow.Navigator
import kotlinx.android.synthetic.main.fragment_payment_details.*
import kotlinx.android.synthetic.main.view_credit_card_front.*
import javax.inject.Inject

class OrderPaymentDetailsFragment : BaseFragment() {

    companion object {
        const val TAG = "OrderPaymentDetailsFragment"

        fun newInstance() = OrderPaymentDetailsFragment()
    }

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var viewModel: OrderPaymentDetailsViewModel

    private var parentViewDelegate: OrderViewDelegate? = null

    private val localUserDataObserver = Observer<LocalUser> { user ->
        front_card_holder_name.text = "${user.firstName} ${user.lastName}"
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_payment_details

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        parentViewDelegate = activity as OrderViewDelegate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()
    }

    private fun setBindings() {
        viewModel.outputLocalUser()
                .observe(this, localUserDataObserver)
    }

    override fun onResume() {
        super.onResume()

        parentViewDelegate?.onTitleChange(getString(R.string.title_payment_details), hasBackArrow = true)
    }

    private fun setViews() {
        payment_details_order_summary_button.setOnClickListener {
            parentViewDelegate?.onDetailsClick()
        }
    }
}