package com.Sridhar.PaymentGateway.merchant.dto.response;

import com.Sridhar.PaymentGateway.common.enums.Environment;

import java.util.UUID;

public record ApiKeyCreateResponse(
        UUID id,
        String keyId,
        String keySecret,
        Environment environment
) {
}
