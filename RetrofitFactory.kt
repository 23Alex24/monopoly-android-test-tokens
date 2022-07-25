package su.monopoly.cargoes.hansolofranchise.di

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import su.monopoly.cargoes.hansolofranchise.BuildConfig
import su.monopoly.cargoes.hansolofranchise.data.api.*
import su.monopoly.cargoes.hansolofranchise.data.api.auth.AuthNetworkInterface
import su.monopoly.cargoes.hansolofranchise.depart_arrival.data.ArrivalApiInterface
import su.monopoly.cargoes.hansolofranchise.history.data.HistoryApiInterface
import su.monopoly.cargoes.hansolofranchise.utils.keyvaluestore.KeyValueStore
import su.monopoly.cargoes.hansolofranchise.utils.lazyObservable
import su.monopoly.cargoes.hansolofranchise.utils.provideApplicationContext
import java.util.concurrent.TimeUnit

val baseDebugUrlsList = listOf(
    "abc.monopoly.su",
)

const val BASE_DEBUG_URL_KEY = "BASE_DEBUG_URL_KEY"

class RetrofitFactory(private val moshi: Moshi) :
    IRetrofitFactory {
    private val context = provideApplicationContext()
    private var baseUrl: String by lazyObservable({
        if (BuildConfig.DEBUG) KeyValueStore.get(BASE_DEBUG_URL_KEY) : baseDebugUrlsList.first()
    })
    {
        KeyValueStore.set(BASE_DEBUG_URL_KEY, it)
        driverEntrepreneurRetrofit = createDriverEntrepreneurRetrofit()
        fortisCoreRetrofit = createFortisCoreRetrofit()
        apiClientInterface = createApiDriverEntrepreneurInterface()
        apiFortisCoreInterface = createApiFortisCoreInterface()
        apiGateway = ApiGateway(apiClientInterface, apiFortisCoreInterface)
    }

    private var driverEntrepreneurRetrofit by lazyObservable({ createDriverEntrepreneurRetrofit() })
    private var fortisCoreRetrofit by lazyObservable({ createFortisCoreRetrofit() })
    private var apiClientInterface by lazyObservable({ createApiDriverEntrepreneurInterface() })
    private var apiFortisCoreInterface by lazyObservable({ createApiFortisCoreInterface() })
    private val cookieJar = PersistentCookieJar(
        SetCookieCache(),
        SharedPrefsCookiePersistor(context)
    )
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .apply {
                cookieJar(cookieJar)
                connectTimeout(60, TimeUnit.SECONDS)
                readTimeout(60, TimeUnit.SECONDS)
                addInterceptor(AuthorizationInterceptor())
                addInterceptor(NoContentInterceptor())
                addInterceptor {
                    ConnectionChecher().check?.invoke()
                    it.proceed(it.request())
                }
                authenticator(RefreshTokenAuthenticator())
                if (KeyValueStore.mocks)
                    addInterceptor(MockInterceptor())

                if (BuildConfig.DEBUG) {
                    val loggingInterceptor = HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                    addInterceptor(loggingInterceptor)
                }
            }.build()

    }

    override var apiGateway by lazyObservable({
        ApiGateway(apiClientInterface, apiFortisCoreInterface)
    })

    override fun getAuthNetwork(): AuthNetworkInterface {
        return apiClientInterface
    }

    override fun getArrivalApi(): ArrivalApiInterface {
        return apiClientInterface
    }

    override fun getHistoryApi(): HistoryApiInterface {
        return apiClientInterface
    }

    override fun setNewBaseUrl(newBaseUrl: String, mocks: Boolean) {
        baseUrl = newBaseUrl
        KeyValueStore.mocks = mocks
    }

    override fun getCurrentBaseUrl(): String = baseUrl

    override fun getBaseUrlList(): List<String> {
        return baseDebugUrlsList
    }

    private fun createRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(url)
            .client(okHttpClient)
            .build()
    }
}

