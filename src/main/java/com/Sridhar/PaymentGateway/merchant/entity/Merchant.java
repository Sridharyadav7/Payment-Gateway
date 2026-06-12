package com.Sridhar.PaymentGateway.merchant.entity;
import com.Sridhar.PaymentGateway.common.enums.BusinessType;
import com.Sridhar.PaymentGateway.common.enums.MerchantStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "merchant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(length = 20)
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Column(length = 20)
    private String businessName;

    @Column(length = 200)
    private String websiteUrl;

    @Column(nullable = false, length = 200)
    @Enumerated(EnumType.STRING)
    private MerchantStatus status =  MerchantStatus.PENDING_KYC;

    @Column(length = 20)
    private String gstId;

    @Column(length = 20)
    private String panId;

    @Column(length = 200)
    private String settlementBankAccount;

    @Column(length = 200)
    private String settlementBankIsfc;

    @Column(length = 200)
    private String settlementBankAccountHolderName;
}
