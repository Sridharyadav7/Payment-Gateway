package com.Sridhar.PaymentGateway.merchant.dto.request;

import com.Sridhar.PaymentGateway.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
