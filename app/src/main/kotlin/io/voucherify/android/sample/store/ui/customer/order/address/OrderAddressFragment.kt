package io.voucherify.android.sample.store.ui.customer.order.address

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.customer.order.OrderViewDelegate
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

    @Inject
    lateinit var viewModel: OrderAddressViewModel

    private var parentViewDelegate: OrderViewDelegate? = null

    private val customerDataObserver = Observer<LocalCustomer> { customer ->
        name_surname_order_details_et.setText(customer.name ?: "", TextView.BufferType.EDITABLE)
        city_order_details_et.setText(customer.address?.city ?: "", TextView.BufferType.EDITABLE)
        zip_code_order_details_et.setText(customer.address?.postalCode ?: "", TextView.BufferType.EDITABLE)
        street_and_number_order_details_et.setText(customer.address?.line_1 ?: "", TextView.BufferType.EDITABLE)
        phone_order_details_et.setText(customer.phone ?: "", TextView.BufferType.EDITABLE)
        email_order_details_et.setText(customer.email ?: "", TextView.BufferType.EDITABLE)
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_order_address

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        parentViewDelegate = activity as OrderViewDelegate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()
        setFormBindings()
    }

    private fun setBindings() {

        viewModel.outputCustomerData()
            .observe(this, customerDataObserver)
    }

    private fun setFormBindings() {
        name_surname_order_details_et.doAfterTextChanged { text ->
            viewModel.inputName(text.toString())
        }

        city_order_details_et.doAfterTextChanged { text ->
            viewModel.inputCity(text.toString())
        }

        zip_code_order_details_et.doAfterTextChanged { text ->
            viewModel.inputZipCode(text.toString())
        }

        street_and_number_order_details_et.doAfterTextChanged { text ->
            viewModel.inputStreet(text.toString())
        }

        phone_order_details_et.doAfterTextChanged { text ->
            viewModel.inputPhone(text.toString())
        }

        email_order_details_et.doAfterTextChanged { text ->
            viewModel.inputEmail(text.toString())
        }
    }

    override fun onResume() {
        super.onResume()

        parentViewDelegate?.onTitleChange(getString(R.string.title_order_address), hasBackArrow = true)
    }

    private fun setViews() {
        payment_details_order_address_button.setOnClickListener {
            parentViewDelegate?.onPaymentDetailsClick()
        }
    }
}