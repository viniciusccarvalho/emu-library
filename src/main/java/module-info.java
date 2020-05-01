/**
 * @author vinicius
 */module io.igx.emu {
    requires javafx.controls;
    requires javafx.graphics;
    requires tornadofx;
    requires kotlin.stdlib;
    requires koin.core;
    requires org.jdbi.v3.core;


    exports io.igx.emu.views;
    exports io.igx.emu.model;
    exports io.igx.emu.controllers;
    exports io.igx.emu.config;

    opens io.igx.emu;


}