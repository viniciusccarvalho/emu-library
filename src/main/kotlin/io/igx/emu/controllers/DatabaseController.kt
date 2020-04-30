package io.igx.emu.controllers

import io.igx.emu.model.EmulatorDownload
import tornadofx.Controller

/**
 * @author vinicius
 *
 */
class DatabaseController : Controller() {

    fun listDownloads() : List<EmulatorDownload> {
        return  listOf(
            EmulatorDownload("MAME" ,"0.202", false, ""),
            EmulatorDownload("MAME" ,"0.193", true, ""),
            EmulatorDownload("FBAlpha" ,"0.2.97.43", true, ""),
            EmulatorDownload("FBAlpha" ,"0.2.97.42", false, "")
        )
    }
}