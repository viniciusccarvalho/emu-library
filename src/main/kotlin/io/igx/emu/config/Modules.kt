package io.igx.emu.config

import io.igx.emu.controllers.DatabaseController
import org.koin.dsl.module

/**
 * @author vinicius
 *
 */

val controllers = module {
    single { DatabaseController() }
}