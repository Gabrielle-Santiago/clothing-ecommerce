package com.gabrielle.ecommerce.adapter.http.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "Webhook", description = "Purchase status update endpoints")
public interface WebhookControllerDoc {

    @Operation(
            summary = "Approve purchase",
            description = "Updates purchase status to APPROVED"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Purchase approved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Purchase not found"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid purchase state"
            )
    })
    ResponseEntity<Void> approve(@PathVariable UUID id);

    @Operation(
            summary = "Reject purchase",
            description = "Updates purchase status to REJECTED"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Purchase rejected successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Purchase not found"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid purchase state"
            )
    })
    ResponseEntity<Void> reject(@PathVariable UUID id);
}
