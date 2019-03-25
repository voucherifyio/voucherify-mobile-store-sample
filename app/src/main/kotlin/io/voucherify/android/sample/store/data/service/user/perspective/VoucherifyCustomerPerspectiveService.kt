package io.voucherify.android.sample.store.data.service.user.perspective

import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.data.local.persistence.LocalPersistence

class VoucherifyCustomerPerspectiveService(private val customersLocalPersistence: LocalPersistence<LocalCustomer>) :
    CustomerPerspectiveService {

    override fun switchTo(customer: LocalCustomer?) {
        val allExistingLocalCustomers = customersLocalPersistence
            .loadAll()
            .toMutableList()

        allExistingLocalCustomers.forEach {
            it.isActive = it.id == customer?.id
        }

        if (allExistingLocalCustomers.firstOrNull { it.id == customer?.id } == null) {
            customer?.let {
                allExistingLocalCustomers.add(it)
            }
        }

        customersLocalPersistence.save(allExistingLocalCustomers)
    }

    override fun activeCustomer(): LocalCustomer? {
        return customersLocalPersistence
            .loadAll()
            .firstOrNull {
                it.isActive
            }
    }
}
