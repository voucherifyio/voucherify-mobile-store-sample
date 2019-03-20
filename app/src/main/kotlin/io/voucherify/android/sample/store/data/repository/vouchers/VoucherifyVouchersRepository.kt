package io.voucherify.android.sample.store.data.repository.vouchers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.VoucherifyVouchersApi
import io.voucherify.android.sample.store.data.remote.api.response.VoucherPageListResponse

class VoucherifyVouchersRepository(private val vouchersApi: VoucherifyVouchersApi) : VouchersRepository {

    override fun list(): Flowable<VoucherPageListResponse> {
        return vouchersApi.list()
    }
}