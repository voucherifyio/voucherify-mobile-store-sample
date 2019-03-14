package io.voucherify.android.sample.store.data.service.customers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.CustomerPageListResponse

interface CustomersService {

    fun list(): Flowable<CustomerPageListResponse>
}