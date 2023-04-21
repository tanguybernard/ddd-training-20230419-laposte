package com.zenika.laposte.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.zenika.laposte.bc_preparation")
public class MyArchTest {

    @ArchTest
    public static final ArchRule class_domain_independant_application =noClasses().that().resideInAPackage("..domain..")
    .should().dependOnClassesThat().resideInAPackage("..application..");

    @ArchTest
    public static final ArchRule class_domain_independant_infra =noClasses().that().resideInAPackage("..domain..")
            .should().dependOnClassesThat().resideInAPackage("..infrastructure..");

    @ArchTest
    public static final ArchRule class_domain_independant_presentation =noClasses().that().resideInAPackage("..domain..")
            .should().dependOnClassesThat().resideInAPackage("..presentation..");

}
