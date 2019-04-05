package io.voucherify.android.sample.store.ui.customer.order

interface OrderViewDelegate {

    fun onTitleChange(title: String)

    fun onPaymentDetailsClick()

    fun onSummaryClick()

}