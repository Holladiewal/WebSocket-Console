package me.holladiewal.WSConsole

import kotlinx.coroutines.experimental.launch
import org.java_websocket.WebSocketImpl

object Main {

    public var run = true

    @JvmStatic
    fun main(args: Array<String>) {
        //WebSocketImpl.DEBUG = true
        launch{WebSocket.instance().init()}
        Threads().startInput()
        while(run){}
    }


}
