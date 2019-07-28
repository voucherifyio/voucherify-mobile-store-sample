package io.voucherify.android.sample.store.ui.customer.order.address

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class OrderAddressViewModel(private val customerPerspectiveService: CustomerPerspectiveService) : BaseViewModel() {

    private var localCustomerLiveData = MutableLiveData<LocalCustomer>()

    fun inputName(name: String) {
        update(customerPerspectiveService.activeCustomer()?.copy(name = name))
    }

    fun inputCity(city: String) {
        val customer = customerPerspectiveService.activeCustomer()
        update(customerPerspectiveService.activeCustomer()?.copy(address = customer?.address?.copy(city = city)))
    }

    fun inputZipCode(zipCode: String) {
        val customer = customerPerspectiveService.activeCustomer()
        update(customerPerspectiveService.activeCustomer()?.copy(address = customer?.address?.copy(postalCode = zipCode)))
    }

    fun inputStreet(street: String) {
        val customer = customerPerspectiveService.activeCustomer()
        update(customerPerspectiveService.activeCustomer()?.copy(address = customer?.address?.copy(line_1 = street)))
    }

    fun inputEmail(email: String) {
        update(customerPerspectiveService.activeCustomer()?.copy(email = email))
    }

    fun inputPhone(phone: String) {
        update(customerPerspectiveService.activeCustomer()?.copy(phone = phone))
    }

    fun outputCustomerData(): LiveData<LocalCustomer> {

        customerPerspectiveService.activeCustomer()?.let {
            localCustomerLiveData.value = it
        }

        return localCustomerLiveData
    }

    private fun update(localCustomer: LocalCustomer?) {

        localCustomer?.let {
            customerPerspectiveService.update(customer = it)
        }
    }

}