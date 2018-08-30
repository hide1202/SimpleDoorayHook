package io.viewpoint.dooray.hook.services

import io.netty.handler.codec.http.HttpHeaderNames
import io.viewpoint.dooray.hook.requests.HookRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class HookService {
    fun sendHook(hookRequest: HookRequest): Mono<Boolean> {
        val client = WebClient.builder()
                .baseUrl(hookRequest.hookUrl)
                .defaultHeader(HttpHeaderNames.CONTENT_TYPE.toString(), MediaType.APPLICATION_JSON.toString())
                .build()

        val response = client.post().body(BodyInserters.fromObject(hookRequest.hook)).exchange()
        return response.map { r -> r.statusCode() == HttpStatus.OK }
    }
}