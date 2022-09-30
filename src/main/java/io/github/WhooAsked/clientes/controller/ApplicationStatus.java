package io.github.WhooAsked.clientes.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
@RequestMapping("/api/app")
public class ApplicationStatus {

    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    @Operation(description = "HealthCheck" , responses = {
            @ApiResponse(description = "API is online", responseCode = "200", content = @Content(mediaType = "application/text"))
    })
    public ResponseEntity<String> HealthCheck() {
        return new ResponseEntity<>("I'm alive!", HttpStatus.OK);
    }

}
