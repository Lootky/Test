import models.Todo
import org.junit.jupiter.api.Test

class PerformanceTest : BaseTest() {

    @Test
    fun `POST todos - performance test`() {
        val numberOfRequests = 1000
        val startTime = System.currentTimeMillis()

        repeat(numberOfRequests) {
            val newTodo = Todo(
                id = it.toLong(),
                text = "Performance test TODO $it",
                completed = false
            )
            val responseCode = todoApiClient.createTodoAndGetCode(newTodo)
            assertEquals(201, responseCode)
        }

        val endTime = System.currentTimeMillis()
        val totalTime = endTime - startTime
        println("Total time for $numberOfRequests requests: ${totalTime}ms")
    }
}
