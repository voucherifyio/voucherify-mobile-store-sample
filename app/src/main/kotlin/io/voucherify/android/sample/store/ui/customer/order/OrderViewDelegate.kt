package io.voucherify.android.sample.store.ui.customer.order

interface OrderViewDelegate {

    fun onTitleChange(title: String, hasBackArrow: Boolean)

    fun onPaymentDetailsClick()

    fun onDetailsClick()

    fun onBuyClick()

    fun onHistoryClick()

}