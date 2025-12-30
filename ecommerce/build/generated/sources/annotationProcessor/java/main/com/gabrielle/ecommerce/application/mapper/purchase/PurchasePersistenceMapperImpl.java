package com.gabrielle.ecommerce.application.mapper.purchase;

import com.gabrielle.ecommerce.domain.Purchase;
import com.gabrielle.ecommerce.domain.PurchaseItem;
import com.gabrielle.ecommerce.domain.entity.Purchase.PurchaseEntity;
import com.gabrielle.ecommerce.domain.entity.Purchase.PurchaseItemEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-30T18:07:24-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class PurchasePersistenceMapperImpl implements PurchasePersistenceMapper {

    @Override
    public Purchase toDomain(PurchaseEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String paymentMethod = null;
        List<PurchaseItem> items = null;
        UUID id = null;
        UUID clientId = null;

        paymentMethod = entity.getPaymentMethod();
        items = purchaseItemEntityListToPurchaseItemList( entity.getItems() );
        id = entity.getId();
        clientId = entity.getClientId();

        Purchase purchase = new Purchase( id, clientId, paymentMethod, items );

        return purchase;
    }

    @Override
    public PurchaseEntity toEntity(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        PurchaseEntity purchaseEntity = new PurchaseEntity();

        purchaseEntity.setPaymentMethod( purchase.getPaymentMethod() );
        purchaseEntity.setId( purchase.getId() );
        purchaseEntity.setClientId( purchase.getClientId() );
        purchaseEntity.setTotal( purchase.getTotal() );
        purchaseEntity.setItems( purchaseItemListToPurchaseItemEntityList( purchase.getItems() ) );

        return purchaseEntity;
    }

    @Override
    public PurchaseItemEntity toItemEntity(PurchaseItem domainItem) {
        if ( domainItem == null ) {
            return null;
        }

        PurchaseItemEntity purchaseItemEntity = new PurchaseItemEntity();

        purchaseItemEntity.setProductId( domainItem.getProductId() );
        purchaseItemEntity.setQuantity( domainItem.getQuantity() );
        purchaseItemEntity.setUnitPrice( domainItem.getUnitPrice() );
        purchaseItemEntity.setSubtotal( domainItem.getSubtotal() );

        return purchaseItemEntity;
    }

    @Override
    public PurchaseItem toItemDomain(PurchaseItemEntity entityItem) {
        if ( entityItem == null ) {
            return null;
        }

        UUID productId = null;
        int quantity = 0;
        BigDecimal unitPrice = null;

        productId = entityItem.getProductId();
        quantity = entityItem.getQuantity();
        unitPrice = entityItem.getUnitPrice();

        PurchaseItem purchaseItem = new PurchaseItem( productId, quantity, unitPrice );

        return purchaseItem;
    }

    protected List<PurchaseItem> purchaseItemEntityListToPurchaseItemList(List<PurchaseItemEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItem> list1 = new ArrayList<PurchaseItem>( list.size() );
        for ( PurchaseItemEntity purchaseItemEntity : list ) {
            list1.add( toItemDomain( purchaseItemEntity ) );
        }

        return list1;
    }

    protected List<PurchaseItemEntity> purchaseItemListToPurchaseItemEntityList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItemEntity> list1 = new ArrayList<PurchaseItemEntity>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( toItemEntity( purchaseItem ) );
        }

        return list1;
    }
}
