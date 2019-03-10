package io.voucherify.android.sample.store.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.voucherify.android.sample.store.data.remote.api.VoucherifyAuthApi
import retrofit2.Retrofit

@Module(
    includes = [
        NetworkModule::class
    ]
)
object ApiModule {

    @Provides
    @Reusable
    fun provideVoucherifyAuthApi(retrofit: Retrofit): VoucherifyAuthApi = retrofit.create(VoucherifyAuthApi::class.java)
}