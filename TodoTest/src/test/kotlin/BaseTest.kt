import api.TodoApiClient
import org.junit.jupiter.api.BeforeAll

abstract class BaseTest {
    protected lateinit var todoApiClient: TodoApiClient

    @BeforeAll
    fun setup() {
        todoApiClient = TodoApiClient("http://localhost:8080")
    }
}
