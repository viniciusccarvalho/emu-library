package io.igx.emu.model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

/**
 * @author vinicius
 *
 */
class EmulatorDownload(name: String, version: String,  local: Boolean,  url: String){
    val nameProperty = SimpleStringProperty(this, "name", name)
    var name by nameProperty
    val versionProperty = SimpleStringProperty(this, "version", version)
    var version by versionProperty
    var localProperty = SimpleBooleanProperty(this, "local", local)
    var local by localProperty
}

class NodePrinter<T>(val node: T, val callback: (T) -> String = { it.toString()}){

    override fun toString(): String {
        return callback(node)
    }
}
