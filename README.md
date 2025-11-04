🧑‍💻 CRUD Spring Boot + Thymeleaf + MySQL

Projeto simples de CRUD (Create, Read, Update, Delete) usando Spring Boot 3, Java 21, JPA/Hibernate, Thymeleaf e MySQL.

O sistema permite cadastrar, listar, editar e excluir registros (notas ou pessoas) diretamente pelo navegador.

🚀 Tecnologias Utilizadas

Java 21, Spring Boot 3.3.4, Spring Data JPA, Spring Web, Spring Validation (Jakarta), Thymeleaf, MySQL e Maven.

⚙️ Configuração do Projeto

1️⃣ Crie o banco de dados MySQL executando no MySQL Workbench ou terminal:
CREATE DATABASE crud_db;

2️⃣ Configure o arquivo application.properties no caminho src/main/resources:
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/crud_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
(Ajuste o usuário e senha conforme seu MySQL)

▶️ Como Rodar o Projeto

💡 Opção 1 – IntelliJ IDEA
Abra o projeto no IntelliJ, espere o Maven baixar as dependências, vá até a classe principal (src/main/java/com/senac/crud/CrudApplication.java) e clique no botão verde “Run”.

💡 Opção 2 – Linha de Comando
Na raiz do projeto (onde está o arquivo pom.xml), execute:
mvn spring-boot:run

🌐 Acessar no Navegador

Após iniciar o servidor, abra o navegador e acesse:
http://localhost:8080/notes

Você poderá:
✅ Cadastrar novas notas
✏️ Editar notas existentes
🗑️ Excluir notas
📋 Listar todas as notas

🧱 Estrutura do Projeto

src/main/java/com/senac/crud
├── CrudApplication.java (classe principal)
├── controller/NoteController.java
├── model/Note.java
├── repository/NoteRepository.java
└── exception/ResourceNotFoundException.java
src/main/resources
├── templates (páginas HTML Thymeleaf)
├── static (arquivos CSS e JS)
└── application.properties

🧾 Licença

Projeto educacional desenvolvido para fins de estudo no Senac.

👨‍💻 Desenvolvido por: Marcelo Dukeveis
