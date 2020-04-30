package io.igx.emu

import io.igx.emu.config.controllers
import io.igx.emu.views.DrawerWorkspace
import javafx.stage.Stage
import org.koin.core.KoinApplication
import org.koin.core.KoinComponent
import org.koin.core.context.KoinContextHandler
import org.koin.core.context.startKoin
import tornadofx.App
import tornadofx.DIContainer
import tornadofx.FX
import tornadofx.Workspace
import tornadofx.launch
import kotlin.reflect.KClass

/**
 * @author vinicius
 *
 */
class LibraryMain : App(DrawerWorkspace::class){

    lateinit var koinApplication: KoinApplication
    init {
        koinApplication = startKoin{
            modules(listOf(controllers))
        }
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T {
                return KoinContextHandler.get().get(type)
            }

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
