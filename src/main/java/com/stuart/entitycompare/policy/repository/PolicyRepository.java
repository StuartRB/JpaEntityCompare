package com.stuart.entitycompare.policy.repository;

import com.stuart.entitycompare.policy.entity.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PolicyRepository extends JpaRepository<PolicyEntity, String> {
}
