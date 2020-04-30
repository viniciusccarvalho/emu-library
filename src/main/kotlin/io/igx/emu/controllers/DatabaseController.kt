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
            EmulatorDownload("MAME" ,"0.202", "NOT_PRESENT", ""),
            EmulatorDownload("MAME" ,"0.193", "NOT_PRESENT", ""),
            EmulatorDownload("FBAlpha" ,"0.194", "PRESENT", ""),
            EmulatorDownload("FBAlpha" ,"0.193", "NOT_PRESENT", "")
        )
    }
}