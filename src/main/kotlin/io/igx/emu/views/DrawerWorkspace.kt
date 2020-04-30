package io.igx.emu.views

import javafx.scene.control.TreeItem
import tornadofx.*

/**
 * @author vinicius
 *
 */

class DrawerWorkspace : Workspace() {

    init {
        val emulatorTreeView = find<EmulatorTreeView>()
        add(RestProgressBar::class)
        menubar{
            menu ("File"){

            }
            menu ("Preferences"){
                item("Download databases","Shortcut+M").action {
                    find<DatabaseDownloadView>().openModal()
                }
            }
            menu ("About") {

            }
        }

        with(leftDrawer){

            item("Databases"){
                add(emulatorTreeView)
            }
            item("Collections"){
                treeview(TreeItem("Collections"))
            }
        }
    }
}