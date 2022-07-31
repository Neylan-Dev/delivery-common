package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.DataForBusinessException;
import com.neylandev.delivery.domain.enums.DeliveryStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "deliveries")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences = new ArrayList<>();
    @Embedded
    private Recipient recipient;
    private BigDecimal tax;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private OffsetDateTime orderedDate;
    private OffsetDateTime endDate;

    public Occurrence addAndGetOccurrence(String description) {
        var occurrence = Occurrence.builder()
                .delivery(this)
                .description(description)
                .registerDate(OffsetDateTime.now())
                .build();
        getOccurrences().add(occurrence);
        return occurrence;
    }

    public void complete(){
        if (!canBeCompletedOrCanceled()){
            throw DataForBusinessException.DELIVERY_CANNOT_BE_COMPLETED.asBusinessExceptionWithDescriptionFormatted(Long.toString(getId()));
        }

        setDeliveryStatus(DeliveryStatus.FINALIZED);
        setEndDate(OffsetDateTime.now());
    }

    public void cancel(){
        if (!canBeCompletedOrCanceled()){
            throw DataForBusinessException.DELIVERY_CANNOT_BE_CANCELED.asBusinessExceptionWithDescriptionFormatted(Long.toString(getId()));
        }

        setDeliveryStatus(DeliveryStatus.CANCELLED);
        setEndDate(OffsetDateTime.now());
    }



    private boolean canBeCompletedOrCanceled(){
        return getDeliveryStatus().equals(DeliveryStatus.PENDING);
    }
}
