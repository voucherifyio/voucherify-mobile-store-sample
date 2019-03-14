package io.voucherify.android.sample.store.data.repository.customers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.VoucherifyCustomersApi
import io.voucherify.android.sample.store.data.remote.api.response.CustomerPageListResponse

class VoucherifyCustomersRepository(private val customersApi: VoucherifyCustomersApi): CustomersRepository {

    override fun list(): Flowable<CustomerPageListResponse> {
        return customersApi.list()
    }
}