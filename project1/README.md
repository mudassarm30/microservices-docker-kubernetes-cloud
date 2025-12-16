# Order System Microservice

This project is a Spring Boot-based microservice for managing orders. It is part of the `microservices-docker-kubernetes-cloud` workspace.

## Project Initialization

- Project scaffolded using Spring Boot.
- Initial setup completed.
- Basic health check endpoint tested.

## Getting Started

### Prerequisites

- Java 21 or above
- Maven 3.9.11
- Spring Boot 3.5.0

## Installing Maven 3.9.11

### Download Maven 3.9.11

```bash
cd /opt
sudo wget https://downloads.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.tar.gz
```

If wget is not available:

```bash
sudo curl -O https://downloads.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.tar.gz
```

### Extract

```bash
sudo tar -xzf apache-maven-3.9.11-bin.tar.gz
sudo ln -s apache-maven-3.9.11 maven
```

Directory layout:

```bash
/opt/maven
```

🔹 Set Maven environment variables

Edit your shell profile:

```bash
nano ~/.bashrc
```

Add at the bottom:

```bash
export MAVEN_HOME=/opt/maven
export PATH=$MAVEN_HOME/bin:$PATH
```

Reload:

```bash
source ~/.bashrc
```

### Creating the scaffolded Project


```bash
curl https://start.spring.io/starter.tgz \
  -d type=maven-project \
  -d language=java \
  -d bootVersion=3.5.0 \
  -d javaVersion=21 \
  -d groupId=com.originsoftconsultancy \
  -d artifactId=order-system \
  -d name=order-system \
  -d packageName=com.originsoftconsultancy.ordersystem \
  -d dependencies=web,data-jpa,h2,actuator \
  -o order-system.tgz
```

### Running the Application


From the project root directory, run:

```bash
./mvnw spring-boot:run
```

The application will start on [http://localhost:8080](http://localhost:8080).

## Health Check



## Health Check

Spring Boot Actuator is enabled. To check the health of the service, run:

```bash
curl http://localhost:8080/actuator/health
```

Expected response:

```
{"status":"UP"}
```

## Next Steps

- Add business logic for order management
- Implement additional endpoints
- Add tests and documentation

---