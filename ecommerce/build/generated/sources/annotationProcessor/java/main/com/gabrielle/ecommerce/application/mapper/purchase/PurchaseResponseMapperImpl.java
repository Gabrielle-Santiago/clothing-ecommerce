package com.gabrielle.ecommerce.application.mapper.purchase;

import com.gabrielle.ecommerce.application.dto.purchase.PurchaseItemResponse;
import com.gabrielle.ecommerce.application.dto.purchase.PurchaseResponse;
import com.gabrielle.ecommerce.domain.Purchase;
import com.gabrielle.ecommerce.domain.PurchaseItem;
import com.gabrielle.ecommerce.domain.enums.PurchaseStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-30T18:07:24-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class PurchaseResponseMapperImpl implements PurchaseResponseMapper {

    @Autowired
    private PurchaseItemResponseMapper purchaseItemResponseMapper;

    @Override
    public PurchaseResponse toDTO(Purchase domain) {
        if ( domain == null ) {
            return null;
        }

        UUID purchaseId = null;
        UUID clientId = null;
        PurchaseStatus status = null;
        BigDecimal total = null;
        Instant createdAt = null;
        String paymentMethod = null;
        List<PurchaseItemResponse> items = null;

        purchaseId = domain.getId();
        clientId = domain.getClientId();
        status = domain.getStatus();
        total = domain.getTotal();
        createdAt = domain.getCreatedAt();
        paymentMethod = domain.getPaymentMethod();
        items = purchaseItemListToPurchaseItemResponseList( domain.getItems() );

        PurchaseResponse purchaseResponse = new PurchaseResponse( purchaseId, clientId, status, total, createdAt, paymentMethod, items );

        return purchaseResponse;
    }

    protected List<PurchaseItemResponse> purchaseItemListToPurchaseItemResponseList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItemResponse> list1 = new ArrayList<PurchaseItemResponse>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( purchaseItemResponseMapper.toDTO( purchaseItem ) );
        }

        return list1;
    }
}
