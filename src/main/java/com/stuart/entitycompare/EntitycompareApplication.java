package com.stuart.entitycompare;

import com.stuart.entitycompare.claim.entity.ClaimEntity;
import com.stuart.entitycompare.claim.repository.ClaimRepository;
import com.stuart.entitycompare.service.EntityCompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntitycompareApplication implements CommandLineRunner {

    @Autowired
    EntityCompareService service;

    @Autowired
    ClaimRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EntitycompareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	    service.genericCompareById("1","2", repository, ClaimEntity.class);

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
