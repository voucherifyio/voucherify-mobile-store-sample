package io.voucherify.android.sample.store.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.voucherify.android.sample.store.data.remote.api.VoucherifyAuthApi
import io.voucherify.android.sample.store.data.remote.api.VoucherifyCustomersApi
import io.voucherify.android.sample.store.data.remote.api.VoucherifyProductsApi
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

    @Provides
    @Reusable
    fun provideVoucherifyCustomersApi(retrofit: Retrofit): VoucherifyCustomersApi =
        retrofit.create(VoucherifyCustomersApi::class.java)

    @Provides
    @Reusable
    fun provideVoucherifyProductsApi(retrofit: Retrofit): VoucherifyProductsApi =
        retrofit.create(VoucherifyProductsApi::class.java)
}