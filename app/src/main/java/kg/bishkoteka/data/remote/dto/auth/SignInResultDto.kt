package kg.bishkoteka.data.remote.dto.auth

data class SignInResultDto(
    val email: String,
//    val tokens: String,
    val access: String,
    val refresh: String,
    val username: String
)