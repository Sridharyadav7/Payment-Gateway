package com.Sridhar.PaymentGateway.merchant.service;

import com.Sridhar.PaymentGateway.merchant.dto.request.MerchantSignupRequest;
import com.Sridhar.PaymentGateway.merchant.dto.response.MerchantResponse;

public interface AuthService {
    MerchantResponse signup(MerchantSignupRequest request);
}
