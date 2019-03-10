package io.voucherify.android.sample.store.injection.component

import dagger.Component
import io.voucherify.android.sample.store.injection.scope.ActivityScope

@ActivityScope
@Component(
    dependencies = [
        ApplicationComponent::class
    ],
    modules = [
    ]
)
interface LoginComponent