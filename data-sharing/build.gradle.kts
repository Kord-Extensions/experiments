import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		maven {
			name = "Sonatype Snapshots"
			url = uri("https://oss.sonatype.org/content/repositories/snapshots")
		}
	}
}

plugins {
	`kordex-module`
	`tested-module`
}

metadata {
	name = "Data Sharing Experiment"
	description = "Experimental library for type-safe data sharing between unrelated components."
}

dependencies {
	api(libs.bundles.logging) // Basic logging setup
	api(libs.kx.ser)

	detektPlugins(libs.detekt)
	detektPlugins(libs.detekt.libraries)

	implementation(libs.kotlin.stdlib)

	testImplementation(libs.groovy)  // For logback config
	testImplementation(libs.jansi)
	testImplementation(libs.junit)
	testImplementation(libs.logback)
	testImplementation(libs.logback.groovy)
}

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
	languageVersion = "1.9"
}

dokkaModule {
	moduleName = "Data Sharing Experiment"
}
