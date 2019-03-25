package io.voucherify.android.sample.store.data.service.user.perspective

import io.voucherify.android.sample.store.data.local.model.LocalCustomer

interface CustomerPerspectiveService {

    fun switchTo(customer: LocalCustomer?)

    fun activeCustomer(): LocalCustomer?

}