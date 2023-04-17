package kg.bishkoteka.data.models.get.auth

data class SignInResultResponse(
    val id: Int,
//    val email: String,
//    val tokens: String,
    val access: String,
    val refresh: String,
//    val username: String
)