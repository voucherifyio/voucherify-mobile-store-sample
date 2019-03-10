package io.voucherify.android.sample.store.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {

    private const val NETWORK_TIMEOUT_SECONDS = 60L

    @Provides
    @Singleton
    fun provideBaseUrl(): String = "https://api.voucherify.io"

    @Provides
    @Reusable
    fun provideLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Timber.d(message)
        })
    }

    @Provides
    @Reusable
    fun provideRxCallAdapter(): RxJava2CallAdapterFactory =
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

    @Provides
    @Reusable
    fun provideMoshiConverter(): Converter.Factory =  MoshiConverterFactory.create()

    @Provides
    @Reusable
    fun provideClient(logger: HttpLoggingInterceptor): OkHttpClient {

        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.readTimeout(NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        okHttpClientBuilder.connectTimeout(NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            logger.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logger.level = HttpLoggingInterceptor.Level.BASIC
        }

        return okHttpClientBuilder
            .addInterceptor(logger)
            .build()

    }

    @Provides
    @Reusable
    @JvmStatic
    fun provideRetrofit(
        httpClient: OkHttpClient,
        baseUrl: String,
        rxCallAdapter: RxJava2CallAdapterFactory,
        converter: Converter.Factory
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converter)
            .addCallAdapterFactory(rxCallAdapter)
            .client(httpClient)
            .build()
    }

}