package su.monopoly.cargoes.hansolofranchise.utils.keyvaluestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import su.monopoly.cargoes.hansolofranchise.utils.ApplicationSingleton
import su.monopoly.cargoes.hansolofranchise.utils.MoshiProvider
import su.monopoly.cargoes.hansolofranchise.utils.lazyObservable
import su.monopoly.cargoes.hansolofranchise.utils.provideDependency
import kotlin.properties.ReadWriteProperty

const val NON_AUTHORISED_STUB = "non_authorised"

object KeyValueStore {
    private val provider: KeyValueDaoProvider by provideDependency()
    private val dao get() = provider.keyValueDao
    private val moshiProvider by provideDependency<MoshiProvider>()

    fun set(key: String, value: String?) =
        if (value.isNullOrBlank())
            dao.deleteValue(KeyValueEntity(key, ""))
        else
            dao.setValue(KeyValueEntity(key, value))

    fun get(key: String): String? = dao.getValue(key)?.value

    fun set(key: String, value: Boolean?) =
        if (value == null)
            dao.deleteValue(KeyValueEntity(key, ""))
        else
            dao.setValue(KeyValueEntity(key, value.toString()))

    fun getBoolean(key: String): Boolean? = dao.getValue(key)?.value?.toBoolean()

    fun set(key: String, value: Int?) =
        if (value == null)
            dao.deleteValue(KeyValueEntity(key, ""))
        else
            dao.setValue(KeyValueEntity(key, value.toString()))

    fun getInt(key: String): Int? = dao.getValue(key)?.value?.toIntOrNull()

    fun set(key: String, value: Long?) =
        if (value == null)
            dao.deleteValue(KeyValueEntity(key, ""))
        else
            dao.setValue(KeyValueEntity(key, value.toString()))

    fun getLong(key: String): Long? = dao.getValue(key)?.value?.toLongOrNull()

    fun set(key: String, value: Double?) =
        if (value == null)
            dao.deleteValue(KeyValueEntity(key, ""))
        else
            dao.setValue(KeyValueEntity(key, value.toString()))

    fun getDouble(key: String): Double? = dao.getValue(key)?.value?.toDoubleOrNull()


    fun getLiveData(key: String): LiveData<String?> = dao.getValueLiveData(key)
    fun getFlow(key: String): Flow<String?> = dao.getValueFlow(key)
    fun getAll() = dao.getAll()

    var accessToken: String? by property("accessToken")
    var refreshToken: String? by property("refreshToken")
    var userId: String? by property("userId")

    var mocks: Boolean by lazyObservable({ getBoolean("USE_MOCKS") ?: false }) { set("USE_MOCKS", it) }

    private val adapter = moshiProvider.moshi.adapter(UserProfile::class.java)
    var userProfile: UserProfile?
            by lazyObservable({ get("userProfile")?.let { adapter.fromJson(it) } })
            { profile -> set("userProfile", profile?.let { adapter.toJson(it) }) }

    val userProfileLiveData
        get() = dao.getValueLiveData("userProfile").map { it?.let(adapter::fromJson) }

    val canGoIn get() = !accessToken.isNullOrBlank() && !refreshToken.isNullOrBlank()
    val isAuthenticated get() = canGoIn && accessToken != NON_AUTHORISED_STUB

    fun login(accessToken: String, refreshToken: String, userId: String?) {
        this.accessToken = accessToken
        this.refreshToken = refreshToken
        userId?.let { this.userId = userId }
    }

    fun logout() {
        accessToken = null
        refreshToken = null
        userId = null
        userProfile = null
    }

    fun property(key: String):
            ReadWriteProperty<Any?, String?> = lazyObservable({ get(key) }) { set(key, it) }
}

data class UserProfile(
    val firstName: String,
    val lastName: String,
    val middleName: String?,
    val phoneNumber: String
) {
    val nameString
        get() = if (middleName == null)
            "$firstName $lastName"
        else
            "$firstName $middleName $lastName"

}

@Entity
data class KeyValueEntity(
    @PrimaryKey
    val key: String,
    val value: String
)

@Dao
interface KeyValueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setValue(element: KeyValueEntity)

    @Delete
    fun deleteValue(element: KeyValueEntity)

    @Query("SELECT * FROM KeyValueEntity WHERE `key` = :key")
    fun getValue(key: String): KeyValueEntity?

    @Query("SELECT * FROM KeyValueEntity WHERE `key` = :key")
    fun observeValue(key: String): Flow<KeyValueEntity?>

    @Query("SELECT value FROM KeyValueEntity WHERE `key` = :key")
    fun getValueLiveData(key: String): LiveData<String?>

    @Query("SELECT value FROM KeyValueEntity WHERE `key` = :key")
    fun getValueFlow(key: String): Flow<String?>

    @Query("SELECT * FROM KeyValueEntity")
    fun getAll(): List<KeyValueEntity>

    @Query("DELETE FROM KeyValueEntity")
    suspend fun clearKeyValue()
}

interface KeyValueDaoProvider : ApplicationSingleton.IDependency {
    val keyValueDao: KeyValueDao
}