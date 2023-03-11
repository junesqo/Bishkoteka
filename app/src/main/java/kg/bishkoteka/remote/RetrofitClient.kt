package kg.bishkoteka.remote


import kg.bishkoteka.remote.NetworkFastBuilder.Companion.provideOkHttpClientBuilder
import kg.bishkoteka.remote.NetworkFastBuilder.Companion.provideRetrofit
import kg.bishkoteka.remote.apiservice.AuthenticationApiService
import kg.bishkoteka.remote.apiservice.RefreshAccessTokenApiService
import kg.bishkoteka.remote.interceptors.AuthenticationInterceptor
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkClient @Inject constructor(
    private val authenticationInterceptor: AuthenticationInterceptor,
    private val authenticator: Authenticator
) {

    private val retrofit =
        provideRetrofit(
            provideOkHttpClientBuilder().apply {
                addInterceptor(authenticationInterceptor)
                authenticator(authenticator)
            }.build()
        )

    class AuthenticationNetworkClient @Inject constructor() {
        private val retrofitNoAuth =
            provideRetrofit(provideOkHttpClientBuilder().build())

        fun generateAuthenticationApiService() =
            retrofitNoAuth.createAnApi<AuthenticationApiService>()

        fun generateRefreshAccessTokenApiService() =
            retrofitNoAuth.createAnApi<RefreshAccessTokenApiService>()
    }
}

inline fun <reified T : Any> Retrofit.createAnApi(): T = create(T::class.java)