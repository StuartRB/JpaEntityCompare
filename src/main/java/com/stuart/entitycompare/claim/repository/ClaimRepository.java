package com.stuart.entitycompare.claim.repository;

import com.stuart.entitycompare.claim.entity.ClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClaimRepository extends JpaRepository<ClaimEntity, String> {
    List<ClaimEntity> findByClaimNumber(String claimNumber);
}
