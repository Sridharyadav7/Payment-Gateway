package com.Sridhar.PaymentGateway.merchant.dto.response;

import com.Sridhar.PaymentGateway.common.enums.BusinessType;
import com.Sridhar.PaymentGateway.common.enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus
) {
}
