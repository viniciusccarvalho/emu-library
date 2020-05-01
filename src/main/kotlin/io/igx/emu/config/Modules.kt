package io.igx.emu.config

import io.igx.emu.controllers.DatabaseController
import io.igx.emu.services.DatabaseService
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.h2.H2DatabasePlugin
import org.koin.dsl.module

/**
 * @author vinicius
 *
 */

val controllers = module {
    single { DatabaseController() }
}

val common = module {
    single(createdAtStart = true) { jdbi() }
}

val services = module {
    single { DatabaseService(get ())}
}

fun jdbi() : Jdbi {
    val jdbi = Jdbi.create("jdbc:h2:file:~/.emulib/db")
    jdbi.installPlugin(H2DatabasePlugin())
    return jdbi
}