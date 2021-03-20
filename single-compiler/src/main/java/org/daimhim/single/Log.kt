package org.daimhim.single

import javax.annotation.processing.Messager
import javax.tools.Diagnostic

object Log {
    private lateinit var messager: Messager

    fun initLog(msg: Messager){
        messager = msg
    }

    fun e(text: String) {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(text))
    }

    fun w(text: String) {
        messager.printMessage(Diagnostic.Kind.WARNING, String.format(text))
    }

    fun m(text: String) {
        messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, String.format(text))
    }

    fun n(text: String) {
        messager.printMessage(Diagnostic.Kind.NOTE, String.format(text))
    }

    fun o(text: String) {
        messager.printMessage(Diagnostic.Kind.OTHER, String.format(text))
    }
}