package io.github.tdminhnhat.controller;

import io.github.tdminhnhat.model.RestingPasswordDTO;
import io.github.tdminhnhat.model.UserLoginDTO;
import io.github.tdminhnhat.service.AuthenticateService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Mono;

@Controller(value = "${api-path.authenticate}")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticateController {

    AuthenticateService authenticateService;

    @Post("/login")
    public Mono<Object> checkLogin(@Valid @Body UserLoginDTO request) {
        return Mono.empty();
    }

    @Post("/reset-password")
    public Mono<Object> resetPassword(@Valid @Body RestingPasswordDTO request) {
        return Mono.empty();
    }
}
