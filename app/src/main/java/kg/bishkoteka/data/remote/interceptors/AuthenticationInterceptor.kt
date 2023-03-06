package kg.bishkoteka.data.remote.interceptors

import kg.bishkoteka.data.local.preferences.UserPreferences
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor(
    private val userPreferences: UserPreferences
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "Bearer ${userPreferences.accessToken}")
            .build()
        return chain.proceed(request)
    }
} //Привязывает ацесс токен к каждому запросу