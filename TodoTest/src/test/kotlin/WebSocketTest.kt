import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocketListener
import org.junit.jupiter.api.Test

class WebSocketTest : BaseTest() {

    @Test
    fun `WebSocket - check connection`() {
        val client = OkHttpClient()
        val request = Request.Builder().url("ws://localhost:4242/ws").build()

        val listener = object : WebSocketListener() {
            override fun onOpen(webSocket: okhttp3.WebSocket, response: okhttp3.Response) {
                println("WebSocket connection opened")
            }

            override fun onMessage(webSocket: okhttp3.WebSocket, text: String) {
                println("Received message: $text")
            }
        }

        val webSocket = client.newWebSocket(request, listener)
        client.dispatcher.executorService.shutdown()
    }
}
