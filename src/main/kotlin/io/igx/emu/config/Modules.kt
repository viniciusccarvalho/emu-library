package io.igx.emu.config

import io.igx.emu.controllers.DatabaseController
import org.jdbi.v3.core.Jdbi
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

fun jdbi() : Jdbi {
    return Jdbi.create("jdbc:h2:file:~/.emulib/db")
}