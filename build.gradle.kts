// Top-level build file where you can add configuration options common to all sub-projects/modules.
// build.gradle (a nivel de proyecto root)
plugins {
    alias(libs.plugins.android.application) apply true
}

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PracticaNovelasEventos"
include(":app")
