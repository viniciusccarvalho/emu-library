package io.igx.emu.services

import kotlinx.coroutines.delay
import org.jdbi.v3.core.Jdbi
import org.slf4j.LoggerFactory

/**
 * @author vinicius
 *
 */
class DatabaseService(val jdbi: Jdbi) {

    val logger = LoggerFactory.getLogger(DatabaseService::class.java)

    suspend fun prepareDatabase(){
        logger.info("Preparing database")
        delay(5000L)
        logger.info("done preparing database")
    }
}