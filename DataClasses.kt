data class AuthRefreshRequestDto(
    val refreshToken: String
)

data class AuthLoginResponseTokenDto(
    val token: String,
    val validTo: DateTime
)

data class AuthRefreshResponseDto(
        val accessToken: AuthLoginResponseTokenDto,
        val refreshToken: AuthLoginResponseTokenDto
)