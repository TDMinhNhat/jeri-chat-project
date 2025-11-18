package io.github.tdminhnhat;

import io.micronaut.http.annotation.*;

@Controller("/emotion-service")
public class EmotionServiceController {

    @Get(uri = "/", produces = "text/plain")
    public String index() {
        return "Example Response";
    }
}