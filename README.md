# 🦁 API Zoo

API REST desenvolvida em **Spring Boot** para gerenciar um zoológico. O sistema permite o cadastro e gerenciamento de **animais, cuidadores, veterinários e alimentações**.

---

## 🚀 Tecnologias utilizadas
- **Java 17+**
- **Spring Boot** (Web, Data JPA)
- **Hibernate / JPA**
- **Lombok**
- **Banco de Dados Relacional** (MySQL ou PostgreSQL)

---

## 📂 Estrutura do projeto
```
com.example.Zoo
 ├── Controller   → Camada de controle (endpoints REST)
 ├── DTO          → Objetos de transferência de dados
 ├── Models       → Entidades do domínio
 └── Service      → Regras de negócio
```

---

## 📌 Endpoints principais

### 🐾 Animais (`/animais`)
- **GET /animais** → Lista todos os animais.
- **GET /animais/{id}** → Busca animal por ID.
- **GET /animais/especie/{especie}** → Busca animais por espécie.
- **GET /animais/idade?idadeMin=&idadeMax=** → Busca animais por faixa etária.
- **POST /animais** → Cria um novo animal.
- **PUT /animais/{id}** → Atualiza um animal existente.
- **DELETE /animais/{id}** → Remove um animal.

### 🍖 Alimentações (`/alimentacoes`)
- **GET /alimentacoes** → Lista todas as alimentações.
- **GET /alimentacoes/{id}** → Busca por ID.
- **POST /alimentacoes** → Registra uma nova alimentação.
- **PUT /alimentacoes/{id}** → Atualiza uma alimentação.
- **DELETE /alimentacoes/{id}** → Remove uma alimentação.

### 👨‍🌾 Cuidadores (`/cuidadores`)
- **GET /cuidadores** → Lista todos os cuidadores.
- **GET /cuidadores/{id}** → Busca por ID.
- **GET /cuidadores/filter?especialidade=&turno=** → Filtro por especialidade ou turno.
- **POST /cuidadores** → Cadastra um novo cuidador.
- **PUT /cuidadores/{id}** → Atualiza um cuidador.
- **DELETE /cuidadores/{id}** → Remove um cuidador.

### 🩺 Veterinários (`/veterinarios`)
- **GET /veterinarios** → Lista todos os veterinários.
- **GET /veterinarios/{id}** → Busca por ID.
- **POST /veterinarios** → Cadastra um novo veterinário.
- **PUT /veterinarios/{id}** → Atualiza um veterinário.
- **DELETE /veterinarios/{id}** → Remove um veterinário.

---

## 📖 Exemplos de requisição

### Criar Animal (POST `/animais`)
```json
{
  "nome": "Leão Simba",
  "especie": "Leão",
  "idade": 5,
  "habitatId": 1
}
```

### Criar Cuidador (POST `/cuidadores`)
```json
{
  "nome": "Carlos Silva",
  "especialidade": "Mamíferos",
  "turnoDeTrabalho": "Manhã"
}
```

---

## ▶️ Como rodar o projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/APIZoo.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd APIZoo
   ```
3. Configure o banco de dados em `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/zoo
   spring.datasource.username=root
   spring.datasource.password=senha
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Rode a aplicação:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse a API em: [http://localhost:8080](http://localhost:8080)

---

## 📌 Melhorias futuras
- Implementar autenticação e autorização (Spring Security + JWT).
- Adicionar documentação com Swagger/OpenAPI.
- Criar testes unitários e de integração.

---

📌 **Autor:** Projeto acadêmico inspirado em sistemas de gestão de zoológicos.

