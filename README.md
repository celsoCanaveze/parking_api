# 🅿️ Parking API - Sistema de Gerenciamento do Pátio

Este projeto é uma API RESTful para gerenciamento de um sistema de Gerenciamento do Pátio, com controle de usuários, clientes, motos e pátios. Foi desenvolvida com Java e Spring Boot, utilizando autenticação via JWT e seguindo boas práticas de arquitetura em camadas.

---

## 👨‍💻 Desenvolvido por

- Celso Canaveze Teixeira Pinto: **RM556118**
- Sofia Domingues Gonçalves: **RM554920**
- Thiago Moreno Matheus: **RM554507**

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- Maven
- ModelMapper
- H2 (ambiente de desenvolvimento)
- Lombok

---

## 📁 Estrutura do Projeto

```
parking_api/
├── config/           # Configurações da aplicação (CORS, JWT, ModelMapper, etc)
├── controller/       # Camada de controle (exposição das rotas)
├── dto/              # Data Transfer Objects para entrada/saída de dados
├── exception/        # Tratamento de exceções personalizadas
├── model/            # Entidades do sistema (Cliente, Moto, Pátio, Usuário, etc)
├── repository/       # Interfaces para acesso ao banco de dados
├── service/          # Regras de negócio
└── resources/
    └── application.properties
```

---

## 🔐 Autenticação

A autenticação é baseada em **JWT**. Os usuários devem se autenticar para obter um token válido para realizar operações nas rotas protegidas.

### Endpoints de Autenticação

- `POST /auth/login` – Realiza login com `username` e `password`.
- `POST /auth/register` – Registra novo usuário com papel (ROLE_USER/ADMIN).

---

## 📦 Entidades Principais

### `Cliente`
- Nome
- CPF
- Telefone

### `Moto`
- Modelo
- Placa
- Cor
- Status (ATIVA, INATIVA)
- Cliente associado

### `Pátio`
- Nome
- Endereço
- Capacidade

### `Usuário`
- Username
- Senha (criptografada)
- Role (USER, ADMIN)

---

## 📡 Endpoints Principais

### Clientes
- `GET /clientes` - Listar todos os clientes
- `POST /clientes` - Criar um novo cliente
- `PUT /clientes/{id}` - Atualizar cliente
- `DELETE /clientes/{id}` - Deletar cliente

### Motos
- `GET /motos` - Listar motos
- `POST /motos` - Criar nova moto
- `PUT /motos/{id}` - Atualizar dados da moto
- `DELETE /motos/{id}` - Remover moto

### Pátios
- `GET /patios` - Listar pátios
- `POST /patios` - Criar novo pátio
- `PUT /patios/{id}` - Atualizar pátio
- `DELETE /patios/{id}` - Deletar pátio

---

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/celsoCanaveze/parking_api.git
   cd parking_api
   ```

2. Compile o projeto:
   ```bash
   ./mvnw clean install
   ```

3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse no navegador:
   ```
   http://localhost:8080
   ```

---

## 🧪 Testes

Os testes estão localizados em `src/test/java/...`. Para executá-los:

```bash
./mvnw test
```

---

## 🗂️ Configuração

As propriedades do projeto estão em:

```
src/main/resources/application.properties
```

Exemplo de propriedades:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

---

## 🧰 Requisitos

- Java 17 ou superior
- Maven 3.8+
- IDE compatível (IntelliJ, VSCode, Eclipse)

---
