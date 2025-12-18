# Order System – Modular Monolith with DDD & Hexagonal Architecture

This repository contains **Project 1** of the `microservices-docker-kubernetes-cloud` workspace.

The goal of this project is **not** to immediately build microservices, but to first design a **well-structured modular monolith** using:

- **Domain-Driven Design (DDD)**
- **Hexagonal Architecture (Ports & Adapters)**
- **Executable Architecture Rules (ArchUnit)**

This approach ensures that microservices can be extracted **safely and incrementally** in later projects.

---

## 🎯 Project Goals

- Design clear **bounded contexts**
- Enforce architectural boundaries at build time
- Apply Hexagonal Architecture in a real Spring Boot project
- Learn how architecture rules evolve in practice
- Prepare the codebase for future microservice extraction

---

## Tech Stack

- Java 21  
- Spring Boot 3.5.0  
- Maven 3.9.11  
- Spring Web, Spring Data JPA, Actuator  
- ArchUnit (architecture tests)  
- H2 (runtime database)  

---

## Getting Started

### Prerequisites

- Java 21 or above  
- Maven 3.9.11  
- Spring Boot 3.5.0  

---

## Installing Maven 3.9.11

```bash
cd /opt
sudo wget https://downloads.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.tar.gz
sudo tar -xzf apache-maven-3.9.11-bin.tar.gz
sudo ln -s apache-maven-3.9.11 maven
```

Set environment variables:

```bash
export MAVEN_HOME=/opt/maven
export PATH=$MAVEN_HOME/bin:$PATH
```

Reload:

```bash
source ~/.bashrc
```

---

## Creating the Project

```bash
curl https://start.spring.io/starter.tgz   -d type=maven-project   -d language=java   -d bootVersion=3.5.0   -d javaVersion=21   -d groupId=com.originsoftconsultancy   -d artifactId=order-system   -d name=order-system   -d packageName=com.originsoftconsultancy.ordersystem   -d dependencies=web,data-jpa,h2,actuator   -o order-system.tgz
```

---

## Running the Application

```bash
./mvnw spring-boot:run
```

Application starts at:

```
http://localhost:8080
```

---

## Health Check

```bash
curl http://localhost:8080/actuator/health
```

Expected response:

```json
{"status":"UP"}
```

---

## 🧠 Domain-Driven Design (DDD) – Theory

### What is DDD?

**Domain-Driven Design (DDD)** is an approach to software design that focuses on modeling the **core business domain** and aligning code structure with business concepts.

Key principles:

- Focus on the **domain**, not the technology
- Use a **ubiquitous language** shared with domain experts
- Explicitly model **business boundaries**
- Avoid large shared models

DDD is especially valuable for **complex business systems**.

---

### Bounded Contexts

A **Bounded Context** defines a logical boundary within which:

- A domain model is consistent
- Terms have a single meaning
- Business rules are owned by one team

The same concept may exist in multiple bounded contexts with **different meanings**.

---

### Bounded Contexts in This Project

This project defines the following bounded contexts:

```
order
customer
inventory
payment
```

Each bounded context owns:

- Its **domain model**
- Its **application services**
- Its **business rules**

There is **no shared domain model** between contexts.

---

## 🔌 Hexagonal Architecture – Theory

### What is Hexagonal Architecture?

Hexagonal Architecture (also called **Ports & Adapters**) enforces a strict separation between:

- **Core business logic** (inside the hexagon)
- **External concerns** (outside the hexagon)

The core must not depend on:

- Frameworks
- Databases
- Messaging systems
- Other services

---

### Ports & Adapters

- **Ports** are interfaces defined by the core
- **Adapters** implement those ports using concrete technologies

Key rule:

> **The core defines what it needs. External systems adapt to it.**

---

### Benefits of Hexagonal Architecture

- Strong dependency inversion
- High testability
- Replaceable infrastructure
- Safe refactoring
- Microservice-ready design

---

## 🧩 Applying Hexagonal Architecture in This Project

### Ports

The `order` bounded context defines ports for collaboration:

- `CustomerPort`
- `InventoryPort`
- `PaymentPort`

These ports represent **business-level needs**, not technical APIs.

---

### Adapters

Other bounded contexts implement these ports:

- `customer.application.CustomerService`
- `inventory.application.InventoryService`
- `payment.application.PaymentService`

This creates the following dependency direction:

```
customer  ──▶ order (port)
inventory ──▶ order (port)
payment   ──▶ order (port)
```

This dependency direction is **intentional and required** by Hexagonal Architecture.

---

## 📦 Package Structure

```
ordersystem
 ├── order
 │   ├── domain
 │   ├── application   ← ports live here
 │   └── api
 ├── customer
 │   ├── domain
 │   └── application   ← adapters
 ├── inventory
 │   ├── domain
 │   └── application   ← adapters
 ├── payment
 │   ├── domain
 │   └── application   ← adapters
 ├── config             ← composition root
 └── architecture       ← ArchUnit tests
```

---

## 🧪 Architecture Enforcement with ArchUnit

Architecture rules are enforced using **ArchUnit** and executed during the build.

### Rule 1 – Domain Isolation

> Domain models of different bounded contexts must not depend on each other.

This enforces **true DDD boundaries**.

---

### Rule 2 – Application Layer Protection

> The `order.application` layer must not access internals of other bounded contexts.

All cross-context communication must happen **only via ports**.

---

### Key Architectural Learnings

- Slice isolation alone is insufficient
- Domain isolation and application interaction must be enforced separately
- Adapter → port dependencies are intentional, not violations
- Composition roots (`config`) are not bounded contexts
- Architecture rules must express **intent**, not dogma

---

## ✅ Project Status

**Project 1 completed successfully**

- Modular Monolith
- DDD Bounded Contexts
- Hexagonal Architecture
- Executable Architecture Rules
- Ready for Microservice Extraction

---

## 🚀 Next Step – Project 2

**Extract `inventory` as a real microservice**

Planned topics:

- REST-based adapter replacement
- Docker & Kubernetes
- Observability (logging, metrics, tracing)
- Event-driven communication
- No changes to `order` core logic

---

> This repository intentionally documents architectural decisions and learning outcomes.  
> It is designed to be reviewed by senior engineers and hiring managers.
