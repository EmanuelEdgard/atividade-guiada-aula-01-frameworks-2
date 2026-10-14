# API CRUD para Controle de Tarefas

Atividade guiada da disciplina Frameworks 2 — Unilavras.

## Tecnologias

- Java 21
- Spring Boot 4.1.1
- Maven
- Spring Web
- Armazenamento em memória (sem banco de dados)

## Funcionalidades

- `GET /tasks` — lista todas as tarefas.
- `GET /tasks/{id}` — consulta uma tarefa por ID.
- `POST /tasks` — cria uma tarefa.
- `PUT /tasks/{id}` — atualiza uma tarefa existente.
- `DELETE /tasks/{id}` — exclui uma tarefa.

## Requisitos

Instale o JDK 21 ou uma versão compatível com Spring Boot e Maven (ou use o Maven Wrapper, caso o adicione pela sua IDE).

Confira a versão do Java:

```bash
java -version
```

## Executar

Na pasta do projeto, rode:

```bash
mvn spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

## Testar com Postman

Use `http://localhost:8080/tasks`.

### Criar tarefa — POST `/tasks`

Selecione **Body → raw → JSON** e envie:

```json
{
  "title": "Organizar a casa",
  "description": "Organizar as tarefas de casa",
  "dueDate": "2026-12-31T23:59:00"
}
```

O ID é gerado automaticamente pela API.

### Listar tarefas — GET `/tasks`

Envie uma requisição GET para:

```text
http://localhost:8080/tasks
```

### Buscar tarefa — GET `/tasks/1`

Substitua `1` pelo ID retornado na criação.

### Atualizar tarefa — PUT `/tasks/1`

Envie JSON no corpo:

```json
{
  "title": "Organizar o trabalho",
  "description": "Revisar as tarefas do trabalho",
  "dueDate": "2026-12-25T18:00:00"
}
```

### Excluir tarefa — DELETE `/tasks/1`

Substitua `1` pelo ID da tarefa que deseja excluir. A resposta será `204 No Content`.

## Observações

- Os dados são mantidos apenas na memória enquanto a aplicação está em execução. Ao reiniciar, as tarefas são apagadas.
- `dueDate` usa o formato ISO de data e hora: `AAAA-MM-DDTHH:mm:ss`.
- A API retorna `404 Not Found` quando uma tarefa consultada, atualizada ou excluída não existe.

## Publicar no GitHub

1. Crie um repositório público chamado `atividade-guiada-aula-01-frameworks-2`.
2. Extraia o ZIP e abra a pasta do projeto.
3. Envie todos os arquivos para o repositório. Se usar Git no terminal:

```bash
git init
git add .
git commit -m "Adiciona API CRUD de tarefas com Spring Boot"
git branch -M main
git remote add origin https://github.com/SEU-USUARIO/atividade-guiada-aula-01-frameworks-2.git
git push -u origin main
```

Troque `SEU-USUARIO` pelo seu nome de usuário do GitHub.
