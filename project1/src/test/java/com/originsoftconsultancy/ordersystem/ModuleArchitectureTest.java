package com.originsoftconsultancy.ordersystem;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.originsoftconsultancy.ordersystem")
public class ModuleArchitectureTest {

    @ArchTest
    static final ArchRule domains_are_isolated =
        ArchRuleDefinition.noClasses()
            .that().resideInAPackage("..domain..")
            .should().accessClassesThat()
            .resideInAnyPackage("..application..", "..api..");
}
