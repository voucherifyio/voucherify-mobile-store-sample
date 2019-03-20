package io.voucherify.android.sample.store.data.service.vouchers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.VoucherPageListResponse

interface VouchersService {

    fun list(): Flowable<VoucherPageListResponse>
}