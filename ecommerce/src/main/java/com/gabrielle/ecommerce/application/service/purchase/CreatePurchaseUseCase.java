package com.gabrielle.ecommerce.application.service.purchase;

import com.gabrielle.ecommerce.application.dto.purchase.PurchaseResponse;
import com.gabrielle.ecommerce.application.mapper.purchase.PurchaseResponseMapper;
import com.gabrielle.ecommerce.ports.ClientLookupPort;
import com.gabrielle.ecommerce.application.dto.purchase.PurchaseRequest;
import com.gabrielle.ecommerce.domain.Purchase;
import com.gabrielle.ecommerce.domain.PurchaseItem;
import com.gabrielle.ecommerce.ports.repository.purchase.PurchaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class CreatePurchaseUseCase {

    private final PurchaseRepository repository;
    private final ClientLookupPort clientLookupPort;
    private final PurchaseResponseMapper responseMapper;

    public CreatePurchaseUseCase(PurchaseRepository repository, ClientLookupPort clientLookupPort, PurchaseResponseMapper responseMapper) {
        this.repository = repository;
        this.clientLookupPort = clientLookupPort;
        this.responseMapper = responseMapper;
    }

    public PurchaseResponse execute(PurchaseRequest request) {
        UUID clientId = clientLookupPort.getCurrentClientId();

        Purchase purchase = Purchase.createWithClient(clientId, request.paymentMethod());

        request.items().forEach(item ->
                purchase.addItem(new PurchaseItem(item.productId(), item.quantity(), item.unitPrice()))
        );

        return responseMapper.toDTO(repository.save(purchase));
    }
}
