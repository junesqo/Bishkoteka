package kg.bishkoteka.data.remote


import kg.bishkoteka.data.remote.NetworkFastBuilder.Companion.provideOkHttpClientBuilder
import kg.bishkoteka.data.remote.NetworkFastBuilder.Companion.provideRetrofit
import kg.bishkoteka.data.remote.apiservice.auth.AuthenticationApiService
import kg.bishkoteka.data.remote.apiservice.auth.RefreshAccessTokenApiService
import kg.bishkoteka.data.remote.apiservice.events.EventsApiService
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.remote.apiservice.profile.UserApiService
import kg.bishkoteka.data.remote.interceptors.AuthenticationInterceptor
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

    fun generatePagingApiService() = retrofit.createAnApi<PagingApiService>()

    fun generateUserApiService() = retrofit.createAnApi<UserApiService>()

    fun generateEventsApiService() = retrofit.createAnApi<EventsApiService>()

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