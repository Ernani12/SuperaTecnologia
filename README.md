# **Sistema de Gerenciamento de Tarefas Abstrato
**

![Badge](https://img.shields.io/badge/versão-1.0.0-blue) ![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellowgreen)

## **Descrição**

Objetivo: Desenvolver uma aplicação web que permita aos usuários gerenciar listas e 
itens de forma eficiente.

## **Índice**

- [**Funcionalidades**](#funcionalidades)
- [**Tecnologias Utilizadas**](#tecnologias-utilizadas)
- [**Instalação**](#instalação)
- [**Como Usar**](#como-usar)
- [**Endpoints**](#endpoints)
- [**Contribuição**](#contribuição)
- [**Licença**](#licença)

## **Funcionalidades**

- [x] Listar todos os itens em destaque.
- [x] Adicionar, editar e remover itens.
- [x] [Outras funcionalidades importantes]

## **Tecnologias Utilizadas**

Este projeto foi desenvolvido com as seguintes tecnologias:

| Tecnologia     | Versão   |
|----------------|----------|
| Java           | 17       |
| Spring Boot    | 3.1.0    |
| Maven          | 3.8.6    |
| H2 Database    | 1.4.200  |
| Thymeleaf      | 3.0.15   |

## **Instalação**

Para instalar e rodar a aplicação localmente, siga as etapas abaixo:

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   
2. **Navegue até o diretório do projeto:

   ```bash
   cd nome-do-repositorio
   ```

3. **Instale as dependências:
   ```bash
   mvn clean install
   ```

4. ** Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

## **Como Usar**

Após a instalação, você pode acessar a aplicação no seu navegador, através da URL `http://localhost:8080`.

## **Exemplos de Uso**

Para listar todos os itens em destaque, acesse `http://localhost:8080/items/destaque`.

## **Endpoints**

Abaixo estão os principais endpoints da API:

| **Método HTTP** | **Endpoint**            | **Descrição**                     |
|-----------------|-------------------------|-----------------------------------|
| GET             | `/items`                | Lista todos os itens              |
| GET             | `/items/destaque`       | Lista todos os itens em destaque  |
| POST            | `/items`                | Adiciona um novo item             |
| PUT             | `/items/{id}`           | Atualiza um item existente        |
| DELETE          | `/items/{id}`           | Remove um item                    |




