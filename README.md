# 🎸 Music Store - Spring Boot Application

E-commerce web application for musical instruments and equipment built with Spring Boot.

## 🚀 Technology Stack

- **Java 8**
- **Spring Boot 2.1.4**
- **Spring Data JPA** with Hibernate
- **H2 Database** (in-memory)
- **Thymeleaf** template engine
- **Maven** for dependency management
- **Docker** for containerization

## 📦 Features

- ✅ Product catalog with categories and subcategories
- ✅ Shopping cart system with price calculation
- ✅ User registration and management
- ✅ Product and inventory management
- ✅ Sales tracking and history
- ✅ H2 Console for database inspection

## 🏗️ Project Structure

```
MusicStoreSpring/
├── .github/
│   └── workflows/
│       └── deploy.yml          # GitHub Actions CI/CD
├── musicStore/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── br/senac/tads/musicStore/
│   │   │   │       ├── controller/
│   │   │   │       ├── entidade/
│   │   │   │       ├── repository/
│   │   │   │       └── MusicStoreApplication.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       ├── schema.sql          # Database schema
│   │   │       ├── data.sql            # Initial data
│   │   │       ├── static/             # CSS, JS, Images
│   │   │       └── templates/          # Thymeleaf templates
│   │   └── test/
│   ├── pom.xml
│   ├── mvnw
│   └── mvnw.cmd
├── Dockerfile
└── .dockerignore
```

## 🛠️ Local Development

### Prerequisites

- Java 8 or higher
- Maven 3.6+

### Running Locally

```bash
cd musicStore
./mvnw spring-boot:run
```

The application will start at `http://localhost:7090`

### Access H2 Console

- URL: `http://localhost:7090/h2-console`
- JDBC URL: `jdbc:h2:mem:musicstore`
- Username: `sa`
- Password: (leave empty)

## 🐳 Docker Deployment

### Build Docker Image

```bash
docker build -t music-store:latest .
```

### Run Container

```bash
docker run -d \
  -p 7090:7090 \
  --name music-store \
  --restart unless-stopped \
  -v ~/Projects/music_store/uploads:/app/uploads \
  -v ~/Projects/music_store/logs:/app/logs \
  music-store:latest
```

### Check Container Status

```bash
docker ps | grep music-store
docker logs music-store
```

## 🚀 CI/CD Deployment

The project uses GitHub Actions for automatic deployment to an Orange Pi server.

### Workflow Trigger

Push to `master` branch automatically triggers deployment:

```bash
git add .
git commit -m "Your message"
git push origin master
```

### Deployment Steps

1. ✅ Checkout code
2. ✅ Navigate to musicStore directory
3. ✅ Build JAR with Maven
4. ✅ Build Docker image
5. ✅ Stop old container
6. ✅ Start new container
7. ✅ Verify deployment
8. ✅ Cleanup old images

### Production URL

🌐 **https://musicstore.hardman.app.br**

## 📊 Database Schema

### Tables

- **PRODUTO** - Products (guitars, basses, amps, etc.)
- **CATEGORIA** - Product categories
- **SUBCATEGORIA** - Product subcategories
- **USUARIO** - User accounts
- **CARRINHO** - Shopping cart
- **VENDA** - Sales records

### Pre-loaded Data

- 5 Categories (Áudio e Tecnologia, Estúdio, Percussão, Cordas, Acessórios)
- 16 Subcategories
- 10 Products (guitars, amplifiers, microphones, etc.)
- 1 Test user (arthur@hardman.com.br / admin123)

## 🔧 Configuration

### application.properties

```properties
# Server
server.port=7090

# H2 Database
spring.datasource.url=jdbc:h2:mem:musicstore
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# SQL Initialization
spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema.sql
spring.sql.init.data-locations=classpath:data.sql
```

## 🧪 Testing

```bash
cd musicStore
./mvnw test
```

## 📝 Build

```bash
cd musicStore
./mvnw clean package
```

JAR file will be generated at: `musicStore/target/musicStore-0.0.1-SNAPSHOT.jar`

## 🐛 Troubleshooting

### Application won't start

Check if port 7090 is already in use:
```bash
lsof -i :7090
```

### Database not initializing

Verify that `schema.sql` and `data.sql` are in `src/main/resources/`

### Docker container fails

Check logs:
```bash
docker logs music-store
```

## 📚 Additional Information

- Built for university project
- Spring Boot version: 2.1.4.RELEASE
- Java version: 1.8
- Maven wrapper included

## 👨‍💻 Author

Arthur Hardman Borges

## 📄 License

University Project - Educational Use

