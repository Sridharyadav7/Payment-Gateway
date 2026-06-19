package com.Sridhar.PaymentGateway.payment.entity;

import com.Sridhar.PaymentGateway.common.entity.Money;
import com.Sridhar.PaymentGateway.common.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "order_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    // no foreign key -- cross - service boundary
    @Column(name = "merchant_id", nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Column(length = 100)
    private String receipt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private Integer attempts;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode((SqlTypes.JSON))
    private Map<String, Object> notes;

    @Column(name = "expiresAt", nullable = false)
    private LocalDateTime expiresAt;
}
