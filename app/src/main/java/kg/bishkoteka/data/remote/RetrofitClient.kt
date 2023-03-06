package kg.bishkoteka.data.remote


import kg.bishkoteka.BuildConfig
import kg.bishkoteka.data.remote.apiservice.AuthenticationApiService
import kg.bishkoteka.data.remote.interceptors.AuthenticationInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NetworkClient @Inject constructor(
    private val authenticationInterceptor: AuthenticationInterceptor
) {

    private val retrofit =
        provideRetrofit(
            provideOkHttpClientBuilder().build()
        )

    private val retrofitNoAUth = provideRetrofit(provideOkHttpClientBuilderNoAuth().build())

    fun generateAuthenticationApiService() = retrofitNoAUth.createAnApi<AuthenticationApiService>()

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(authenticationInterceptor)
        .callTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)

    private fun provideOkHttpClientBuilderNoAuth(): OkHttpClient.Builder = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
        when {
            BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        }
    )

    private inline fun <reified T : Any> Retrofit.createAnApi(): T = create(T::class.java)
}