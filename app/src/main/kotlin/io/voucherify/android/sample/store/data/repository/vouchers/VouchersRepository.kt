package io.voucherify.android.sample.store.data.repository.vouchers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.VoucherPageListResponse

interface VouchersRepository {
    fun list(): Flowable<VoucherPageListResponse>
}