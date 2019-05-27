package com.stuart.entitycompare.service;

import com.stuart.entitycompare.claim.entity.ClaimEntity;
import com.stuart.entitycompare.claim.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.core.annotation.AnnotationUtils.getAnnotation;

@Component
public class EntityCompareService {

    @Autowired
    ClaimRepository claimRepository;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public List<?> genericCompareById(String idBase, String idStudy, JpaRepository repository, Class clazz) {
        List<Object> entities = new ArrayList<>();

        try {
            Object base = repository.findById(idBase).orElseThrow(() -> new Exception("Base not found for " + clazz.getSimpleName()));

            Object study = repository.findById(idStudy).orElseThrow(() -> new Exception("Study not found for " + clazz.getSimpleName()));

            System.out.println();
            System.out.println(ANSI_CYAN + "Generic Compare Report: " + clazz.getSimpleName() + ANSI_RESET);

            ReflectionUtils.doWithFields(base.getClass(), field -> {
                field.setAccessible(true);
                if (field.get(base) != field.get(study)) {
                    System.out.println(ANSI_RED + "VARIANCE " + ANSI_RESET + field.getName() + ": " + field.get(base) + " -> " + field.get(study));
                } else {
                    System.out.println(ANSI_GREEN + "MATCHING " + ANSI_RESET + field.getName() + ": " + field.get(base) + " -> " + field.get(study));
                }
            });
            entities.add(base);
            entities.add(study);

        } catch (Throwable throwable) {
            System.out.println("VARIANCE Entity not found: " + throwable.getMessage());
            return null;
        }

        System.out.println();
        return entities;
    }

    public List<?> genericCompareEntities(Object base, Object study) {
        List<Object> entities = new ArrayList<>();

        try {
            System.out.println();
            System.out.println(ANSI_CYAN + "Generic Compare Report: " + base.getClass().getSimpleName() + ANSI_RESET);

            ReflectionUtils.doWithFields(base.getClass(), field -> {
                field.setAccessible(true);
                if (field.get(base) != field.get(study)) {
                    System.out.println(ANSI_RED + "VARIANCE " + ANSI_RESET + field.getName() + ": " + field.get(base) + " -> " + field.get(study));
                } else {
                    System.out.println(ANSI_GREEN + "MATCHING " + ANSI_RESET + field.getName() + ": " + field.get(base) + " -> " + field.get(study));
                }
            });
            entities.add(base);
            entities.add(study);

        } catch (Throwable throwable) {
            System.out.println("VARIANCE Entity not found: " + throwable.getMessage());
            return null;
        }
        System.out.println();
        return entities;
    }

    public void compare(String base, String study) {

        ClaimEntity claimEntityBase = claimRepository.findByClaimNumber(base).get(0);
        ClaimEntity claimEntityStudy = claimRepository.findByClaimNumber(study).get(0);

        ReflectionUtils.doWithFields(claimEntityBase.getClass(), field -> {
            field.setAccessible(true);
//                System.out.println(field.getName());
            // System.out.println(field);
            if (field.get(claimEntityBase) != field.get(claimEntityStudy)) {
                System.out.println("VARIANCE " + field.getName() + ": " + field.get(claimEntityBase) + " , " + field.get(claimEntityStudy));
            } else {
                System.out.println("IDENTICAL " + field.getName() + ": " + field.get(claimEntityBase) + " , " + field.get(claimEntityStudy));
            }
        });

        System.out.println(claimEntityBase.toString());
        System.out.println(claimEntityStudy.toString());
    }
}
