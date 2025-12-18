package com.originsoftconsultancy.ordersystem.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "com.originsoftconsultancy.ordersystem")
public class ModuleArchitectureTest {

    /**
     * Rule 1:
     * Domain models of bounded contexts must be isolated.
     */
    @ArchTest
    static final ArchRule domain_models_are_isolated =
        slices()
            .matching("..ordersystem.(order|customer|inventory|payment).domain..")
            .should().notDependOnEachOther();

    /**
     * Rule 2:
     * Order application must not access internals of other contexts.
     * Interaction must happen via ports only.
     */
    @ArchTest
    static final ArchRule order_application_must_not_access_other_contexts =
        noClasses()
            .that().resideInAPackage("..order.application..")
            .should().accessClassesThat()
            .resideInAnyPackage(
                "..customer.application..",
                "..customer.domain..",
                "..inventory.application..",
                "..inventory.domain..",
                "..payment.application..",
                "..payment.domain.."
            );
}
