/**
 * @author vinicius
 */module io.igx.emu {
    requires javafx.controls;
    requires javafx.graphics;
    requires tornadofx;
    requires kotlin.stdlib;

    exports io.igx.emu.views;
    exports io.igx.emu.model;
    exports io.igx.emu.controllers;

    opens io.igx.emu;


}