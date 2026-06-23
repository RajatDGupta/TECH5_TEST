package com.tech5.test.settings.domain.usecase

import com.tech5.test.settings.domain.repository.SettingsRepository
import javax.inject.Inject

class SetDarkThemeUseCase @Inject constructor(
    private val repository: SettingsRepository
) {
    suspend operator fun invoke(isDark: Boolean) {
        repository.setDarkTheme(isDark)
    }
}
