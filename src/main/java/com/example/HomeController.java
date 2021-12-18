package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.views.View;

import java.util.Map;

@Controller
public class HomeController {
    @View("home")
    @Get
    public HttpResponse hello(@Nullable @QueryValue("message") String message)
    {
        if (message == null || message.isBlank())
        {
            message = "world";
        }
        return HttpResponse.ok(Map.of("message", message));
    }
}
