package io.github.tdminhnhat;

import io.micronaut.http.annotation.*;

@Controller("/group-service")
public class GroupServiceController {

    @Get(uri = "/", produces = "text/plain")
    public String index() {
        return "Example Response";
    }
}