package io.voucherify.android.sample.store.data.repository.customers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.CustomerPageListResponse

interface CustomersRepository {

    fun list(): Flowable<CustomerPageListResponse>
}