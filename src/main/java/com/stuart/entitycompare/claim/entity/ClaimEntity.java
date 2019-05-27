package com.stuart.entitycompare.claim.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CLAIM")
@Data
public class ClaimEntity {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "ClaimNumber")
    private String claimNumber;

    @Column(name = "LossId")
    private String lossId;

    @Column(name = "PolicyId")
    private String policyId;

    @Column(name = "LossType")
    private String lossType;
}
