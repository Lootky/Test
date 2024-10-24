import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DeleteTodosTest : BaseTest() {

    @Test
    fun `DELETE todos - delete a todo`() {
        // Удаляем TODO и проверяем код ответа
        val responseCode = todoApiClient.deleteTodoAndGetCode(1)
        assertEquals(204, responseCode)

        // Проверяем, что TODO действительно был удалён через GET-запрос
        val todos = todoApiClient.getTodos()
        val deletedTodo = todos.find { it.id == 1 }
        assertNull(deletedTodo)
    }
}
