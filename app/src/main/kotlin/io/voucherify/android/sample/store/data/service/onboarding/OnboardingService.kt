package io.voucherify.android.sample.store.data.service.onboarding

interface OnboardingService {

    fun hasActiveOnboarding(): Boolean

    fun updateActiveOnboarding(value: Boolean)
}