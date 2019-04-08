package io.voucherify.android.sample.store.injection.module

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.BuildConfig
import io.voucherify.android.sample.store.data.local.AccountLocalPreferencesStorable
import io.voucherify.android.sample.store.data.remote.api.interceptors.AuthorizationErrorInterceptor
import io.voucherify.android.sample.store.data.remote.api.interceptors.AuthorizationHeaderInterceptor
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.ui.flow.Navigator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.*
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
    fun provideMoshiConverter(): Converter.Factory {

        val moshi = Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .build()

        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Reusable
    fun provideClient(
        logger: HttpLoggingInterceptor,
        context: Context,
        userService: UserService,
        navigator: Navigator,
        accountLocalPreferences: AccountLocalPreferencesStorable
    ): OkHttpClient {

        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.readTimeout(NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        okHttpClientBuilder.connectTimeout(NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            logger.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logger.level = HttpLoggingInterceptor.Level.BASIC
        }

        return okHttpClientBuilder
            .addInterceptor(AuthorizationHeaderInterceptor(accountLocalPreferences))
            .addInterceptor(AuthorizationErrorInterceptor(
                context = context,
                userService = userService,
                navigator = navigator))
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