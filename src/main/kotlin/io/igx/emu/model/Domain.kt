package io.igx.emu.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

/**
 * @author vinicius
 *
 */
class EmulatorDownload(name: String, version: String,  status: String,  url: String){
    val nameProperty = SimpleStringProperty(this, "name", name)
    var name by nameProperty
    val versionProperty = SimpleStringProperty(this, "version", version)
    var version by versionProperty
    var statusProperty = SimpleStringProperty(this, "status", status)
    var status by statusProperty
}