package io.voucherify.android.sample.store.data.service.customers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.CustomerPageListResponse
import io.voucherify.android.sample.store.data.repository.customers.CustomersRepository

class VoucherifyCustomersService(private val customersRepository: CustomersRepository): CustomersService {

    override fun list(): Flowable<CustomerPageListResponse> {
        return customersRepository.list()
    }

}