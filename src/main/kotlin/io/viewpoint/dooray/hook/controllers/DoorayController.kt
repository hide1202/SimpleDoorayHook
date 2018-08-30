package io.viewpoint.dooray.hook.controllers

import io.viewpoint.dooray.hook.requests.HookRequest
import io.viewpoint.dooray.hook.services.HookService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class DoorayController(val hookService: HookService) {

    @PostMapping("hook")
    fun hook(@RequestBody hookRequest: HookRequest): Mono<Boolean> {
        return hookService.sendHook(hookRequest)
    }
}