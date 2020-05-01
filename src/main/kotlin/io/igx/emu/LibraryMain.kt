package io.igx.emu

import io.igx.emu.config.common
import io.igx.emu.config.controllers
import io.igx.emu.config.services
import io.igx.emu.services.DatabaseService
import io.igx.emu.views.DrawerWorkspace
import javafx.stage.Stage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication
import org.koin.core.KoinComponent
import org.koin.core.context.KoinContextHandler
import org.koin.core.context.startKoin
import tornadofx.App
import tornadofx.DIContainer
import tornadofx.FX
import tornadofx.Workspace
import tornadofx.launch
import javax.xml.crypto.Data
import kotlin.reflect.KClass

/**
 * @author vinicius
 *
 */
class LibraryMain : App(DrawerWorkspace::class){

    lateinit var koinApplication: KoinApplication
    init {
        koinApplication = startKoin{
            modules(listOf(controllers, common, services))
        }
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T {
                return KoinContextHandler.get().get(type)
            }

        }
        GlobalScope.launch(Dispatchers.JavaFx) {
            val databaseService = KoinContextHandler.get().get<DatabaseService>()
            databaseService.prepareDatabase()
        }
    }

    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 1024.0
        stage.height = 768.0
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            launch<LibraryMain>(args)
        }
    }
}
