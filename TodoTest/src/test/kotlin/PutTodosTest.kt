import models.Todo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PutTodosTest : BaseTest() {

    @Test
    fun `PUT todos - update an existing todo`() {
        val updatedTodo = Todo(
            id = 1,
            text = "Updated TODO",
            completed = true
        )

        // Отправляем PUT-запрос и проверяем код ответа
        val responseCode = todoApiClient.updateTodoAndGetCode(1, updatedTodo)
        assertEquals(200, responseCode)

        // Проверяем, что TODO действительно был обновлён через GET-запрос
        val todos = todoApiClient.getTodos()
        val updatedTodoFromApi = todos.find { it.id == updatedTodo.id }
        assertNotNull(updatedTodoFromApi)
        assertEquals(updatedTodo.text, updatedTodoFromApi?.text)
        assertTrue(updatedTodoFromApi!!.completed)
    }
}
