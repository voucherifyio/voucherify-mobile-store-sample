package io.voucherify.android.sample.store.data.service.onboarding

import io.voucherify.android.sample.store.data.repository.settings.LocalSettingsRepository

class VoucherifyOnboardingService(private val localSettingsRepository: LocalSettingsRepository) : OnboardingService {

    override fun updateActiveOnboarding(value: Boolean) {
        var settings = localSettingsRepository.fetch()
        settings.isOnboardingActive = value

        localSettingsRepository.update(settings)
    }

    override fun hasActiveOnboarding(): Boolean {
        return localSettingsRepository.fetch().isOnboardingActive
    }

}