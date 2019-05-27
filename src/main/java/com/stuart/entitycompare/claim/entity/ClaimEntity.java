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
    @Column(name = "ID")
    private String id;

    @Column(name = "CLAIMNUMBER")
    private String claimNumber;

    @Column(name = "LOSSID")
    private String lossId;

    @Column(name = "POLICYID")
    private String policyId;

    @Column(name = "LOSSTYPE")
    private String lossType;
}
