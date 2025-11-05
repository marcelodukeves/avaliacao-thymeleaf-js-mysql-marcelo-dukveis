# CRUD Pessoa - Spring Boot + Thymeleaf (Java 21)

Projeto simples demonstrando CRUD (Create, Read, Update, Delete) da entidade `Pessoa` usando:

- Java 21
- Spring Boot (Starter Web, Data JPA, Thymeleaf)
- Hibernate (JPA)
- MySQL
- Maven

## Estrutura principal

- `Pessoa` - entidade com campos `id`, `nome`, `email`, `telefone`
- `PessoaRepository` - Spring Data JPA repository
- `PessoaController` - controlador MVC (Thymeleaf) com rotas para listar, salvar, editar e deletar
- `templates/index.html` - único arquivo Thymeleaf com formulário e tabela
- `static/js/main.js` - JS mínimo para limpeza do formulário

## Requisitos

- Java 21 JDK instalado
- Maven instalado
- MySQL rodando localmente (ou ajuste `application.properties`)

## Criar banco de dados

No MySQL (por exemplo via `mysql` CLI ou Workbench):

```sql
CREATE DATABASE pessoa_db;
```

ou se quiser nome `avaliacao` apenas altere em `application.properties`.

## Configurar usuário/senha

Por padrão, `application.properties` usa `root/root`. Ajuste conforme seu ambiente.

## Rodar o projeto

1. Importar o projeto no IntelliJ como projeto Maven (ou via CLI).
2. No terminal, rodar:

```bash
mvn clean package
mvn spring-boot:run
```

3. Abrir no navegador: `http://localhost:8080/pessoas`

## Rotas principais

- `GET /pessoas` - lista e mostra formulário
- `POST /pessoas/salvar` - cria ou atualiza (envia o form)
- `GET /pessoas/editar/{id}` - carrega os dados no formulário para edição
- `GET /pessoas/deletar/{id}` - deleta e redireciona

## Observações

- O projeto usa `spring.jpa.hibernate.ddl-auto=update` para criar/atualizar tabelas automaticamente (bom para desenvolvimento).
- Para produção, configure corretamente as credenciais e a política de `ddl-auto`.
- O template `index.html` concentra todas as operações em uma única página usando Thymeleaf.

---
Se quiser, eu posso:
- Gerar o projeto com outro nome de pacote que você preferir.
- Incluir testes unitários simples.
- Alterar o banco para PostgreSQL ou H2 em memória para testes.
