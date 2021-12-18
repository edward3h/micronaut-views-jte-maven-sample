package com.example

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import jakarta.inject.Inject


@MicronautTest
class JteSampleSpec extends Specification {

    @Inject
    EmbeddedServer server

    @Inject
    @Client("/")
    HttpClient client

    void 'message with no parameters'() {
        when:
        String response = client.toBlocking().retrieve("/")

        then:
        response.contains("Hello, world")
    }

    void 'message with parameter'() {
        when:
        String response = client.toBlocking().retrieve("/?message=universe")

        then:
        response.contains("Hello, universe")
    }

}
