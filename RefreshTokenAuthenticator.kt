package su.monopoly.cargoes.hansolofranchise.data.api

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import su.monopoly.cargoes.hansolofranchise.auth.data.IAuthRepository
import su.monopoly.cargoes.hansolofranchise.data.api.auth.AuthRefreshRequestDto
import su.monopoly.cargoes.hansolofranchise.di.IRetrofitFactory
import su.monopoly.cargoes.hansolofranchise.router.IAppRouter
import su.monopoly.cargoes.hansolofranchise.utils.keyvaluestore.KeyValueStore
import su.monopoly.cargoes.hansolofranchise.utils.provideDependency

class RefreshTokenAuthenticator : Authenticator {

    private val retrofitFactory: IRetrofitFactory by provideDependency()
    private val appRouter: IAppRouter by provideDependency()

    override fun authenticate(route: Route?, response: Response): Request? {
        if (response.priorResponse != null) return null

        runBlocking(Dispatchers.IO) {
            val request = AuthRefreshRequestDto(
                refreshToken = KeyValueStore.refreshToken.orEmpty()
            )
            try {
                val apiResponse = retrofitFactory.apiGateway.authRefresh(request)
                KeyValueStore.login(apiResponse.accessToken.token, apiResponse.refreshToken.token, null)

            } catch (t: Throwable) {
                Log.e("refresh-token", "Ошибка рефреш токена", t)
                provideDependency<IAuthRepository>().value.logout()
                appRouter.toAuthActivity()
                return@runBlocking null
            }
        }

        val accessToken = KeyValueStore.accessToken ?: return null
        return accessToken.let {
            response.request.newBuilder()
                .header("Authorization", "Bearer $it")
                .build()
        }
    }
}