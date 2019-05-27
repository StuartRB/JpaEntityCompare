package com.stuart.entitycompare.policy.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "POLICY")
@Data
public class PolicyEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "POLICYNUMBER")
    private String policyNumber;

    @Column(name = "POLICYSTATUS")
    private String status;

    @Column(name = "HOLDERNAME")
    private String holderName;

    @Column(name = "HOLDERAGE")
    private Integer holderAge;
}
