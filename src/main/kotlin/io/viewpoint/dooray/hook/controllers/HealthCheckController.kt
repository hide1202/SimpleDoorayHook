package io.viewpoint.dooray.hook.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class HealthCheckController {
    @GetMapping("health")
    fun healthCheck(): Mono<String> {
        return Mono.just("OK")
    }
}