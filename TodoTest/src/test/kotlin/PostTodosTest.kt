import models.Todo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PostTodosTest : BaseTest() {

    @Test
    fun `POST todos - create a new todo`() {
        val newTodo = Todo(
            id = 1,
            text = "Test new TODO",
            completed = false
        )

        // Отправляем POST-запрос и проверяем код ответа
        val responseCode = todoApiClient.createTodoAndGetCode(newTodo)
        assertEquals(201, responseCode)

        // Дополнительно проверяем, что TODO действительно был создан через GET-запрос
        val todos = todoApiClient.getTodos()
        val createdTodo = todos.find { it.id == newTodo.id }
        assertNotNull(createdTodo)
        assertEquals(newTodo.text, createdTodo?.text)
        assertFalse(createdTodo!!.completed)
    }
}
