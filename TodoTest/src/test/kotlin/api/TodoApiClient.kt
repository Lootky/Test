package api

import okhttp3.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class TodoApiClient(private val baseUrl: String) {
    private val client = OkHttpClient.Builder().build()
    private val mapper = jacksonObjectMapper()

    // Получение списка TODO
    fun getTodos(offset: Int = 0, limit: Int = 10): List<Todo> {
        val url = "$baseUrl/todos?offset=$offset&limit=$limit"
        val request = Request.Builder().url(url).build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw RuntimeException("Request failed with code: ${response.code}")
            return mapper.readValue(response.body?.string() ?: "")
        }
    }

    // Создание TODO - возвращает только код ответа
    fun createTodoAndGetCode(todo: Todo): Int {
        val requestBody = RequestBody.create(
            MediaType.parse("application/json; charset=utf-8"),
            mapper.writeValueAsString(todo)
        )
        val request = Request.Builder().url("$baseUrl/todos").post(requestBody).build()

        client.newCall(request).execute().use { response ->
            return response.code
        }
    }

    // Обновление TODO - возвращает только код ответа
    fun updateTodoAndGetCode(id: Long, todo: Todo): Int {
        val requestBody = RequestBody.create(
            MediaType.parse("application/json; charset=utf-8"),
            mapper.writeValueAsString(todo)
        )
        val request = Request.Builder().url("$baseUrl/todos/$id").put(requestBody).build()

        client.newCall(request).execute().use { response ->
            return response.code
        }
    }

    // Удаление TODO - возвращает только код ответа
    fun deleteTodoAndGetCode(id: Long): Int {
        val request = Request.Builder()
            .url("$baseUrl/todos/$id")
            .header("Authorization", Credentials.basic("admin", "admin"))
            .delete()
            .build()

        client.newCall(request).execute().use { response ->
            return response.code
        }
    }
}
