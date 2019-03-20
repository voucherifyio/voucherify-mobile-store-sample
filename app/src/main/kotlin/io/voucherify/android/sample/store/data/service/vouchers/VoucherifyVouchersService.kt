package io.voucherify.android.sample.store.data.service.vouchers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.VoucherPageListResponse
import io.voucherify.android.sample.store.data.repository.vouchers.VouchersRepository

class VoucherifyVouchersService(private val vouchersRepository: VouchersRepository) : VouchersService {

    override fun list(): Flowable<VoucherPageListResponse> {
        return vouchersRepository.list()
    }
}