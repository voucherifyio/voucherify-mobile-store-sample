package io.voucherify.android.sample.store

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.voucherify.android.sample.store.injection.component.DaggerApplicationComponent
import io.voucherify.android.sample.store.injection.module.ApiModule
import io.voucherify.android.sample.store.injection.module.DataModule
import io.voucherify.android.sample.store.injection.module.NetworkModule
import io.voucherify.android.sample.store.injection.module.ServiceModule
import timber.log.Timber
import javax.inject.Inject

class VoucherifyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        DaggerApplicationComponent
            .builder()
            .networkModule(NetworkModule)
            .apiModule(ApiModule)
            .serviceModule(ServiceModule)
            .dataModule(DataModule)
            .create(this)
            .inject(this)
    }
}