# API To-Do List (Spring Boot)

Um projeto back-end focado para gerenciamento de tarefas, construído com Java 21 e Spring Boot 3.

## Sobre o Projeto

Este é um projeto de back-end que implementa uma API RESTful completa para um sistema de "To-Do List" (Lista de Tarefas).
O objetivo principal é solidificar os conceitos de desenvolvimento back-end com Java e Spring Boot, seguindo as melhores
práticas de arquitetura em camadas (Controller, Service, Repository).

O projeto expõe uma API RESTful para operações CRUD (Criar, Ler, Atualizar, Deletar) e também inclui uma 
interface de linha de comando (CLI) interativa para manipulação direta dos dados via console.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3** (usando Jakarta EE)
- **Spring Web** (Para a API REST)
- **Spring Data JPA** (Para persistência de dados)
- **H2 Database** (Banco de dados em memória)
- **Springdoc OpenAPI** (Documentação automática da API - Swagger)
- **Lombok** (Redução de código boilerplate)
- **Apache Maven** (Gerenciador de dependências)

## Funcionalidades

### 1. API RESTful (CRUD Completo)

- **Criar** novas tarefas (`POST`).
- **Listar** todas as tarefas (`GET`).
- **Buscar** uma tarefa específica por ID (`GET /{id}`).
- **Marcar** uma tarefa como completa (`PATCH /{id}/complete`).
- **Deletar** uma tarefa (`DELETE /{id}`).

### 2. Menu Interativo (CLI)

Ao iniciar a aplicação, um menu interativo é apresentado no console, permitindo ao usuário:

- 1. Adicionar Tarefa
- 2. Listar Todas as Tarefas
- 3. Buscar Tarefa por ID
- 4. Marcar Tarefa como Completa
- 5. Deletar Tarefa
- 6. Sair do Menu

### Pré-requisitos

- JDK 21 (ou superior)
- Apache Maven 3.6 (ou superior)
- Uma IDE (ex: IntelliJ IDEA)

### Executando a Aplicação

1.  Clone este repositório para sua máquina local.
2.  Abra o projeto na sua IDE (IntelliJ).
3.  Rode a classe principal `TodolistApplication.java`.
4.  A aplicação estará rodando em `http://localhost:8080`.
5.  O menu interativo (CLI) aparecerá no console da sua IDE (na aba "Run").
