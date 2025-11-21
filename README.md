# 🛒 API REST de Ponto de Venda (PDV) em Spring Boot

API desenvolvida em **Java** com o framework **Spring Boot** para atuar como o *core* transacional de um sistema de Ponto de Venda. Implementa uma arquitetura RESTful para gerenciar de forma eficiente:
* **Catálogo** (Produtos e Categorias)
* **Sessões de Venda** (Carrinhos de Compra)
* **Itens do Pedido** (Composição do Carrinho)

## 🚀 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* H2 / MySQL
* Lombok
* Maven

---

## 🛠️ Como Executar

1.  **Clone o repositório:** `git clone https://github.com/Ntzsbiel/Projeto-Spring-Boot`
2.  **Navegue até o diretório:** `cd nome-do-projeto`
3.  **Execute via Maven:** `./mvnw spring-boot:run`
4.  A API estará disponível em: **`http://localhost:8080`**

---

## 📘 Descrição e Objetivo do Projeto

O **objetivo real** deste projeto é ser o **motor operacional (backend)** para um **Ponto de Venda (PDV)** ou sistema de Caixa. A API oferece a base para que o **funcionário/operador** execute e gerencie as transações de venda da loja.

| Área de Foco | Funcionalidade Operacional | Perspectiva do Operador/Caixa |
| :--- | :--- | :--- |
| **Gestão de Catálogo** | Organização e Consulta de Inventário | Permite que o operador encontre e organize produtos rapidamente (**Produtos** e **Categorias**). |
| **Abertura da Transação** | Iniciação da Venda | Cria um novo **Carrinho de Compras** (nova venda) para o cliente que está sendo atendido. |
| **Processamento do Pedido** | Inserção e Modificação de Itens | O operador adiciona, remove e ajusta a **quantidade** de itens conforme o cliente dita, montando o pedido. |


---

## 📐 Arquitetura de Dados (Diagrama ER)
 

O projeto utiliza um design focado em entidades bem relacionadas:
* **Produto** possui **Categoria** (Um para Muitos).
* **Carrinho** possui vários **Itens de Carrinho** (Um para Muitos).
* **Item de Carrinho** referencia um **Produto** e um **Carrinho** (Muitos para Um).

#### Abaixo, o diagrama de classes (UML) que representa a modelagem das entidades do sistema.

![Diagrama UML](docs/PrintUML.png)


---

## 🔹 Endpoints Principais


### 📦 Produtos
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| **GET** | `/produtos` | Lista todos os produtos |
| **POST** | `/produtos` | Cadastra um **novo** produto |
| **GET** | `/produtos/{id}` | Busca produto por ID |
| **PUT** | `/produtos/{id}` | **Atualiza** produto por ID |
| **DELETE** | `/produtos/{id}` | **Remove** produto por ID |

---

### 🏷️ Categorias
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| **GET** | `/categorias` | Lista todas as categorias |
| **POST** | `/categorias` | Cria uma **nova** categoria |
| **PUT** | `/categorias/{id}` | **Atualiza** categoria por ID |
| **DELETE** | `/categorias/{id}` | **Remove** categoria por ID |

---

### 🛒 Carrinho (Transações)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| **POST** | `/carrinho` | Cria um **novo** carrinho/sessão de venda |
| **GET** | `/carrinho` | Lista todos os carrinhos |
| **GET** | `/carrinho/{id}` | Busca carrinho por ID |
| **DELETE** | `/carrinho/{id}` | Remove carrinho por ID (se não finalizado) |
| **GET** | `/carrinho/total/{id}` | **Calcula** o valor total do carrinho por ID |
| **POST** | `/carrinho/finalizar/{id}` | **Finaliza** a transação de venda por ID |
| **POST** | `/carrinho/cancelar/{id}` | **Cancela** a transação por ID |

---

### ➕ Itens do Carrinho (Composição)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| **POST** | `/carrinho-itens/adicionar?idCarrinho=1&idProduto=1&quantidade=1` | Adiciona item ao carrinho |
| **DELETE** | `/carrinho-itens/remover?idCarrinho=1&idProduto=1` | **Remove** item do carrinho |
| **PUT** | `/carrinho-itens/atualizar?idCarrinho=1&idProduto=1&quantidade=5` | **Atualiza** quantidade do item no carrinho |
---

## 🧪 Exemplo de Requisição: Criação de Produto

Para cadastrar um novo produto (POST /produtos), o corpo da requisição deve ser:

### Requisição

```json
{
  "nome": "Cerveja Artesanal IPA",
  "preco": 18.50,
  "quantidade": 150,
  "categoriaId": {"id": 1} 
}
````

## 🧱 Estrutura de Pastas

    src/main/java/
     └── com.projetoSpringBoot
          ├── controller (Recebe requisições HTTP e retorna respostas)
          ├── service (Implementa a lógica de negócio)
          ├── repository (Interage com o banco de dados)
          └── entities (Representa as entidades do banco de dados)