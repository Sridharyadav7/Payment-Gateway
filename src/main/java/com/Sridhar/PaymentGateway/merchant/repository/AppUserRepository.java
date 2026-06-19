package com.Sridhar.PaymentGateway.merchant.repository;

import com.Sridhar.PaymentGateway.merchant.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}

