package com.stuart.entitycompare;

import com.stuart.entitycompare.claim.entity.ClaimEntity;
import com.stuart.entitycompare.claim.repository.ClaimRepository;
import com.stuart.entitycompare.policy.entity.PolicyEntity;
import com.stuart.entitycompare.policy.repository.PolicyRepository;
import com.stuart.entitycompare.service.EntityCompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EntitycompareApplication implements CommandLineRunner {

    @Autowired
    EntityCompareService service;

    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    PolicyRepository policyRepository;

	public static void main(String[] args) {
		SpringApplication.run(EntitycompareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	    ClaimEntity baseClaim = claimRepository.findByClaimNumber("012345").get(0);
	    ClaimEntity studyClaim = claimRepository.findByClaimNumber("012346").get(0);

	    service.genericCompareEntities(baseClaim, studyClaim);

	    List<?> policyEntities = service.genericCompareById(baseClaim.getPolicyId(), studyClaim.getPolicyId(), policyRepository, PolicyEntity.class);

        System.out.println("Done, son.");

	    //service.genericCompareById("1","2", repository, ClaimEntity.class);

//        if (args.length > 1) {
//            String base = args[0];
//            String study = args[1];
//
//            service.compare(base.replace(",",""), study.replace(",",""));
//        } else {
//            service.compare("baseClaim", "studyClaim");
//        }
	}
}
