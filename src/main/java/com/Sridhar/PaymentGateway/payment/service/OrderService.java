package com.Sridhar.PaymentGateway.payment.service;

import com.Sridhar.PaymentGateway.payment.dto.request.CreateOrderRequest;
import com.Sridhar.PaymentGateway.payment.dto.response.OrderResponse;

import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);
}
