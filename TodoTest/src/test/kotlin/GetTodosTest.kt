import models.Todo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class GetTodosTest : BaseTest() {

    @Test
    fun `GET todos - retrieve list of todos`() {
        val todos = todoApiClient.getTodos()
        assertNotNull(todos)
        assertTrue(todos.isNotEmpty(), "The list of todos should not be empty")
    }
}
