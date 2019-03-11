package io.voucherify.android.sample.store.data.service.logout

import io.reactivex.Completable

interface LogoutService {

    fun logout(): Completable
}