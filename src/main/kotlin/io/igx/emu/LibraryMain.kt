package io.igx.emu

import io.igx.emu.views.DrawerWorkspace
import javafx.stage.Stage
import tornadofx.App
import tornadofx.Workspace

/**
 * @author vinicius
 *
 */
class LibraryMain : App(DrawerWorkspace::class){

    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 1024.0
        stage.height = 768.0
    }

}