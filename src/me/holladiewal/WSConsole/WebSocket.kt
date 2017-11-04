package me.holladiewal.WSConsole

import org.java_websocket.handshake.ServerHandshake
import java.io.BufferedWriter
import java.lang.Exception
import java.net.URI


/**
 * Created by beepbeat/holladiewal on 19.10.2017.
 */

class WebSocket{

    lateinit var client: WebSocketClient
    lateinit var writer : BufferedWriter
    companion object {
        var inst : WebSocket? = null
        fun instance(): WebSocket {
            if (inst  == null){
                inst = WebSocket()
            }
            return inst!!
        }
    }


    suspend fun init(){
        client = WebSocketClient(URI("wss://dev.api.fuelrats.com"))
        println("Connecting blocking")
        client.connectBlocking()
        println("Connected")

       // delay(2000)
        //while (!client.isOpen){}
        writer = client.socket.getOutputStream().bufferedWriter()
    }

    fun send(msg: String){
        writer.write(msg)
        writer.flush()
    }


}

class WebSocketClient(uri: URI) : org.java_websocket.client.WebSocketClient(uri){
    override fun onOpen(handshakedata: ServerHandshake?) {
        println("Opening Connection")
    }

    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        println("Closing Connection, reason: $reason , $code")
    }

    override fun onMessage(message: String?) {
        if (message == null){
            println("message was null")
            return
        }
        @Suppress("NAME_SHADOWING")
        var message : String = message
        println("message: " + message)
    }

    override fun onError(ex: Exception?) {
        ex!!.printStackTrace()
    }

}
