package su.monopoly.cargoes.hansolofranchise.data.api
import okhttp3.Interceptor
import okhttp3.Response
import su.monopoly.cargoes.hansolofranchise.utils.keyvaluestore.KeyValueStore
import javax.inject.Inject
import javax.inject.Singleton

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val accessToken = KeyValueStore.accessToken
        if (accessToken != null) {
            request = request.newBuilder()
                .header("Authorization", "Bearer $accessToken")
                .build()
        }
        return chain.proceed(request)
    }
}