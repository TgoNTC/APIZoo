🦁 API Zoo
API REST desenvolvida em Spring Boot para gerenciar um zoológico. O sistema permite o cadastro e gerenciamento de animais, cuidadores, veterinários e alimentações.

🚀 Tecnologias utilizadas
Java 17+

Spring Boot (Web, Data JPA)

Hibernate / JPA

Lombok

Banco de Dados Relacional (MySQL ou PostgreSQL)

📂 Estrutura do projeto
com.example.Zoo
 ├── Controller   → Camada de controle (endpoints REST)
 ├── DTO          → Objetos de transferência de dados
 ├── Models       → Entidades do domínio
 └── Service      → Regras de negócio
📌 Endpoints principais
🐾 Animais (/animais)
Método	Rota	Descrição
GET	/animais	Lista todos os animais.
GET	/animais/{id}	Busca um animal pelo ID.
GET	/animais/especie/{especie}	Busca animais por espécie.
GET	/animais/idade?idadeMin=&idadeMax=	Busca animais por faixa etária.
POST	/animais	Cria um novo animal.
PUT	/animais/{id}	Atualiza um animal existente.
DELETE	/animais/{id}	Remove um animal.

Exportar para as Planilhas
🍖 Alimentações (/alimentacoes)
Método	Rota	Descrição
GET	/alimentacoes	Lista todas as alimentações.
GET	/alimentacoes/{id}	Busca uma alimentação pelo ID.
POST	/alimentacoes	Registra uma nova alimentação.
PUT	/alimentacoes/{id}	Atualiza uma alimentação.
DELETE	/alimentacoes/{id}	Remove uma alimentação.

Exportar para as Planilhas
👨‍🌾 Cuidadores (/cuidadores)
Método	Rota	Descrição
GET	/cuidadores	Lista todos os cuidadores.
GET	/cuidadores/{id}	Busca um cuidador pelo ID.
GET	/cuidadores/filter?especialidade=&turno=	Filtra cuidadores por especialidade ou turno.
POST	/cuidadores	Cadastra um novo cuidador.
PUT	/cuidadores/{id}	Atualiza um cuidador.
DELETE	/cuidadores/{id}	Remove um cuidador.

Exportar para as Planilhas
🩺 Veterinários (/veterinarios)
Método	Rota	Descrição
GET	/veterinarios	Lista todos os veterinários.
GET	/veterinarios/{id}	Busca um veterinário pelo ID.
POST	/veterinarios	Cadastra um novo veterinário.
PUT	/veterinarios/{id}	Atualiza um veterinário.
DELETE	/veterinarios/{id}	Remove um veterinário.

Exportar para as Planilhas
📖 Exemplos de requisição
Criar Animal (POST /animais)
JSON

{
  "nome": "Leão Simba",
  "especie": "Leão",
  "idade": 5,
  "habitatId": 1
}
Criar Cuidador (POST /cuidadores)
JSON

{
  "nome": "Carlos Silva",
  "especialidade": "Mamíferos",
  "turnoDeTrabalho": "Manhã"
}
▶️ Como rodar o projeto
Clone o repositório:
   bash    git clone https://github.com/seu-usuario/APIZoo.git    

Acesse a pasta do projeto:
   bash    cd APIZoo    

Configure o banco de dados em application.properties:
   properties    spring.datasource.url=jdbc:mysql://localhost:3306/zoo    spring.datasource.username=root    spring.datasource.password=senha    spring.jpa.hibernate.ddl-auto=update    

Rode a aplicação:
   bash    mvn spring-boot:run    

Acesse a API em: http://localhost:8080

📌 Melhorias futuras
Implementar autenticação e autorização (Spring Security + JWT).

Adicionar documentação com Swagger/OpenAPI.

Criar testes unitários e de integração.

📌 Autor: Projeto acadêmico inspirado em sistemas de gestão de zoológicos.
