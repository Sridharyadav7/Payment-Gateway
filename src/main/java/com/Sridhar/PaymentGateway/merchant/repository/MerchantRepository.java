package com.Sridhar.PaymentGateway.merchant.repository;

import com.Sridhar.PaymentGateway.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
    boolean existsByEmail(String email);
}
