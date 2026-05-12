package com.gabrielle.ecommerce.adapter.payment;

import com.gabrielle.ecommerce.application.dto.payment.PaymentGatewayResponse;
import com.gabrielle.ecommerce.domain.Payment;
import com.gabrielle.ecommerce.ports.repository.payment.PaymentGatewayRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;

import java.util.List;

@Component
public class MercadoPagoGateway implements PaymentGatewayRepository {

    @Value("${acess.token.mercado.pago}")
    private String accessToken;

    @Override
    public PaymentGatewayResponse createPayment(Payment payment) {

        MercadoPagoConfig.setAccessToken(accessToken);

        PreferenceItemRequest item = PreferenceItemRequest.builder()
                .title("Compra #" + payment.getPurchaseId())
                .quantity(1)
                .unitPrice(payment.getAmount())
                .currencyId("BRL")
                .build();

        PreferencePayerRequest payer = PreferencePayerRequest.builder()
                .email(payment.getPayerEmail())
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(List.of(item))
                .payer(payer)
                .externalReference(payment.getId().toString())
                .build();

        PreferenceClient client = new PreferenceClient();
        Preference preference;

        try {
            preference = client.create(preferenceRequest);
        } catch (MPException | MPApiException e) {
            throw new RuntimeException("Error creating payment in Mercado Pago", e);
        }

        return new PaymentGatewayResponse(
                preference.getInitPoint(),
                preference.getId()
        );
    }
}
