package io.igx.emu.views

import io.igx.emu.controllers.DatabaseController
import io.igx.emu.model.EmulatorDownload
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.geometry.HPos
import javafx.scene.control.TableView
import javafx.scene.layout.Priority
import tornadofx.*

/**
 * @author vinicius
 *
 */

class DatabaseDownloadView : View("My View") {

    val controller: DatabaseController by inject()


    init {
        modalStage?.height = 480.0
        modalStage?.width = 640.0
        title = "Rom database download"
    }

    override val root =
        vbox(10) {
            vgrow = Priority.ALWAYS
            hgrow = Priority.ALWAYS
            scrollpane {
                tableview<EmulatorDownload>() {
                    isEditable = true
                    asyncItems {
                        controller.listDownloads()
                    }
                    column("Emulator", EmulatorDownload::name)
                    column("Version", EmulatorDownload::version)

                    column("Status", EmulatorDownload::local).cellFormat {
                        if(!it){
                            graphic = button("download") {  }
                        }
                        else{
                            graphic = text("DOWNLOADED") {  }
                        }
                    }
                }
            }

        }

}
