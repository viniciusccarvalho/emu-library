package io.igx.emu.views

import io.igx.emu.controllers.DatabaseController
import io.igx.emu.model.EmulatorDownload
import io.igx.emu.model.NodePrinter
import javafx.scene.control.TreeItem
import javafx.scene.image.ImageView
import javafx.scene.layout.Priority
import tornadofx.*

/**
 * @author vinicius
 *
 */
class EmulatorTreeView : Fragment("Available databases") {

    val controller: DatabaseController by di()

    override val root = scrollpane {
        vgrow = Priority.ALWAYS
        val emulators = controller.listDownloads()
        val grouped = emulators.groupBy { it.name }
        val root : TreeItem<NodePrinter<*>> = TreeItem(NodePrinter("Emulators"))
        grouped.entries.forEach { entry ->
            val category : TreeItem<NodePrinter<*>> = TreeItem(NodePrinter(""), ImageView("/${entry.key.toLowerCase()}.png"))
            category.children.addAll(entry.value.filter { it.local }.map { e -> TreeItem<NodePrinter<*>>(NodePrinter<EmulatorDownload>(e, { it.version })) })
            root.children.add(category)
        }
        treeview(root){
        }
    }
}
