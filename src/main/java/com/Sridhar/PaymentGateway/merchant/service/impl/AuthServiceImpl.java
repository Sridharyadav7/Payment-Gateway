package com.Sridhar.PaymentGateway.merchant.service.impl;

import com.Sridhar.PaymentGateway.common.enums.MerchantStatus;
import com.Sridhar.PaymentGateway.common.enums.UserRole;
import com.Sridhar.PaymentGateway.common.exception.DuplicateResourceException;
import com.Sridhar.PaymentGateway.merchant.dto.request.MerchantSignupRequest;
import com.Sridhar.PaymentGateway.merchant.dto.response.MerchantResponse;
import com.Sridhar.PaymentGateway.merchant.entity.AppUser;
import com.Sridhar.PaymentGateway.merchant.entity.Merchant;
import com.Sridhar.PaymentGateway.merchant.repository.AppUserRepository;
import com.Sridhar.PaymentGateway.merchant.repository.MerchantRepository;
import com.Sridhar.PaymentGateway.merchant.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;

    @Override
    @Transactional
    public MerchantResponse signup(MerchantSignupRequest request) {
        if (merchantRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL",
                    "Merchant with email already exists: " + request.email());
        }

        Merchant merchant = Merchant.builder()
                .businessName(request.businessName())
                .businessType(request.businessType())
                .name(request.name())
                .email(request.email())
                .status(MerchantStatus.PENDING_KYC)
                .build();
        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .passwordHash(request.password()) // TODO: encrypt using Bcrypt
                .role(UserRole.OWNER)
                .build();
        appUserRepository.save(appUser);

        return new MerchantResponse(merchant.getId(), merchant.getName(),
                merchant.getEmail(), merchant.getBusinessName(),
                merchant.getBusinessType(), merchant.getStatus());
    }
}
