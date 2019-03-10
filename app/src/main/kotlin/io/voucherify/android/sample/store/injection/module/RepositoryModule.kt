package io.voucherify.android.sample.store.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.voucherify.android.sample.store.data.remote.api.VoucherifyAuthApi
import io.voucherify.android.sample.store.data.repository.LoginRepository
import io.voucherify.android.sample.store.data.repository.VoucherifyLoginRepository

@Module
class RepositoryModule {

    @Provides
    @Reusable
    fun provideLoginRepository(loginApi: VoucherifyAuthApi): LoginRepository =
        VoucherifyLoginRepository(loginApi = loginApi)
}