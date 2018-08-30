package io.viewpoint.dooray.hook.controllers

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.concurrent.Executors

@RestController
class ShutdownController {
    @Value("\${admin.password}")
    private lateinit var password: String

    @PostMapping("shutdown")
    fun shutdown(@RequestBody password: String): Mono<String> {
        if (this.password == password) {
            val executor = Executors.newSingleThreadExecutor()
            executor.execute {
                Thread.sleep(3000)
                System.exit(0)
            }
            return Mono.just("OK")
        }
        return Mono.just("NOPE")
    }
}