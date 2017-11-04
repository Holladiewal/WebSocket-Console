package me.holladiewal.WSConsole

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import java.util.*


/**
 * Created by beepbeat/holladiewal on 19.10.2017.
 */
class Threads {
    lateinit var inputJob: Job

    fun startInput(){
        val inn = Scanner(System.`in`)
        inputJob = launch{
            while(!inn.hasNextLine()){}
            var msg = inn.nextLine()
            WebSocket.instance().send(msg)
        }
    }
}