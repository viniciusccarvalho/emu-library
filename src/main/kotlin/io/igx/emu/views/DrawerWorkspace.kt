package io.igx.emu.views

import tornadofx.*

/**
 * @author vinicius
 *
 */

class DrawerWorkspace : Workspace() {

    init {
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

            }
            item("Collections"){

            }
        }
    }
}