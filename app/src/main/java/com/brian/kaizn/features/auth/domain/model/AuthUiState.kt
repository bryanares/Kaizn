package com.brian.kaizn.features.auth.domain.model

class AuthUiState (
    var isLoading: Boolean = false,
    var isSuccessful: Boolean = false,
    var error: String? = null,
    var userId: String? = null
)