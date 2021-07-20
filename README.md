# Subsequences Challenge

Figured out challenge based on https://leetcode.com/problems/distinct-subsequences

---
# Technology Stack

- [![playversion](https://img.shields.io/badge/Springboot-2.5.2-brightgreen)](https://spring.io/projects/spring-boot) Reactive Web Framework  
- [![mavenversion](https://img.shields.io/badge/Java-12-red)](https://www.oracle.com/co/java/technologies/javase/jdk12-archive-downloads.html) Main programing language  
- [![mavenversion](https://img.shields.io/badge/Scala-2.12.8-blue)](https://www.scala-lang.org/) Programing language for test resources
- [![scalatestversion](https://img.shields.io/badge/ScalaTest-3.0.8-green)](https://www.scalatest.org) Library used to write unit and integration test using the BDD style   

---

# Project structure

The project structure was designed taking as angular piece the concepts explained by Uncle Bob
around [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) and it is
described below

```
application/            the application source code
|- configuration/       the layer with the highest abstraction that cointains the application starter
|- core/                the layer with the pure application logic
|  |- domain/           the bussiness models               
|  +- usecase/          the logic implementation for the application use cases
|- data-provider/       all the components in charge of retrieve and store information
+- entry-point/         acces to the application (REST controllers)
deployment/             the definition of the build and deployment pipelines
documentation/          documentation resources as diagrams

```