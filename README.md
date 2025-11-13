# 🌱 Projeto CRUD com Spring Boot

## 🎯 Objetivo
Desenvolver um **sistema CRUD (Create, Read, Update, Delete)** utilizando **Spring Boot**, com **duas entidades relacionadas** e persistência em **banco relacional (MySQL)**.  
O projeto visa aplicar na prática os conceitos de **modelagem de dados**, **arquitetura em camadas** e **boas práticas de desenvolvimento** em Java com o Spring Framework.

## 📅 Cronograma de Entregas

| Etapa | Descrição | Prazo Limite |
|:--|:--|:--|
| [**1️⃣ Definição do Projeto**](#-etapa-1--definição-do-projeto-até-1311) | Escolha do tema e escopo do sistema | **13/11/2025** |
| [**2️⃣ Modelagem de Dados**](#-etapa-2--modelagem-de-dados-até-1411) | Criação dos modelos conceitual e lógico | **14/11/2025** |
| [**3️⃣ Criação e Configuração do Projeto**](#-etapa-3--criação-e-configuração-do-projeto-até-1511) | Geração e setup do projeto Spring Boot | **15/11/2025** |
| [**4️⃣ Implementação do Backend**](#-etapa-4--implementação-do-backend-até-1711) | Desenvolvimento das operações CRUD | **17/11/2025** |
| [**5️⃣ Testes e Validação**](#-etapa-5--testes-e-validação-até-1911) | Testes funcionais e de integração | **19/11/2025** |
| [**6️⃣ Documentação e Slides**](#-etapa-6--documentação-e-slides-até-2011) | Criação da documentação e apresentação | **20/11/2025** |
| [**📢 Apresentação Final**](#-etapa-7--apresentação-final-2111) | Entrega e demonstração do sistema | **21/11/2025** |

---

## ⚙️ Tecnologias Utilizadas
- ☕ **Java 17+**
- 🧩 **Spring Boot**
- 🗄 **Spring Data JPA**
- 🐬 **MySQL**
- 🪶 **Lombok**
- 📦 **Maven**
- 🧪 **JUnit 5** / **Mockito**
- 📘 **Swagger UI (opcional)**
- 🧰 **Postman / Insomnia**

---

## 🧭 Etapas do Desenvolvimento

---

### 🧩 Etapa 1 — Definição do Projeto (até 13/11)
🎯 **Objetivo:** definir o tema, propósito e entidades principais.

**Tarefas:**
- Escolher um **tema** (ex: sistema de reservas, tarefas, estoque, etc.)
- Escrever um **resumo do projeto**
- Definir **entidades principais** e suas relações
- Validar a ideia com o professor

📄 **Exemplo de resumo:**  
> Sistema para gerenciar reservas de hotel, permitindo cadastrar clientes e reservas com data, valor e status.

📎 **Resultado esperado:**  
Documento simples com o resumo e descrição das entidades principais.

---

### 🧩 Etapa 2 — Modelagem de Dados (até 14/11)
🎯 **Objetivo:** representar visualmente o banco de dados.

**Tarefas:**
- Criar o **modelo conceitual (ER)** com entidades, atributos e relações
- Criar o **modelo lógico** (tabelas, chaves primárias e estrangeiras)
- Definir restrições e tipos de dados
- Ferramentas sugeridas: [draw.io](https://app.diagrams.net/), [Lucidchart](https://www.lucidchart.com/)

📎 **Resultado esperado:**  
- Diagrama conceitual e lógico salvos em `/docs/modelagem/`.

---

### 🧩 Etapa 3 — Criação e Configuração do Projeto (até 15/11)
🎯 **Objetivo:** criar a base do projeto no Spring Boot.

**Tarefas:**
1. Acessar [Spring Initializr](https://start.spring.io/)
2. Configurar:
   - **Project:** Maven  
   - **Language:** Java  
   - **Dependencies:** Spring Web, Spring Data JPA, MySQL Driver, Lombok, Validation
3. Gerar o projeto e abrir na IDE (STS, IntelliJ, VS Code)

4. Configurar o `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nomedobanco
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```


---

### 🧩 Etapa 4 — Implementação do Backend (até 17/11)
🎯 **Objetivo:** desenvolver as funcionalidades CRUD completas.

**Estrutura recomendada:**


**Tarefas:**
1. **Model (Entidades):**
   - Criar classes com `@Entity`, `@Id`, `@GeneratedValue`
   - Definir atributos, validações (`@NotNull`, `@Size`, etc.)
   - Configurar relacionamentos (`@OneToMany`, `@ManyToOne`, etc.)

2. **Repository:**
   - Criar interfaces que extendem `JpaRepository<>`

3. **Service:**
   - Implementar lógica de negócio
   - Utilizar `@Service` e `@Autowired`

4. **Controller:**
   - Criar endpoints REST com `@RestController`:
     - `POST /entidade` → Criar  
     - `GET /entidade` → Listar  
     - `GET /entidade/{id}` → Buscar  
     - `PUT /entidade/{id}` → Atualizar  
     - `DELETE /entidade/{id}` → Remover

5. **Testar endpoints** com Postman/Insomnia.

📎 **Resultado esperado:**  
CRUD funcional com duas entidades relacionadas.

---

### 🧩 Etapa 5 — Testes e Validação (até 19/11)
🎯 **Objetivo:** garantir que todas as operações funcionem corretamente.

**Tarefas:**
1. **Testes funcionais (Postman):**
   - Criar entidade principal  
   - Criar entidade relacionada  
   - Listar todos os registros  
   - Buscar por ID  
   - Atualizar registros  
   - Excluir registros  

2. **Testes automatizados (JUnit 5 / Mockito):**
   - Testar métodos de Service e Repository  
   - Testar retornos HTTP 200, 404, 400  
   - Verificar comportamento com dados inválidos  

3. **Validação no banco:**
   - Conferir persistência dos dados no MySQL  
   - Verificar integridade entre as tabelas  

4. **Refatoração:**
   - Organizar pacotes e nomes  
   - Remover código duplicado  
   - Adicionar logs e tratamento de exceções simples  

📎 **Resultado esperado:**  
Todos os endpoints testados e dados persistindo corretamente.

---

### 🧩 Etapa 6 — Documentação e Slides (até 20/11)
🎯 **Objetivo:** preparar toda a documentação e apresentação.

**Tarefas:**
1. **README.md (este arquivo):**
   - Descrição do projeto  
   - Cronograma de etapas  
   - Tecnologias utilizadas  
   - Estrutura de pacotes  
   - Exemplos de endpoints  
   - Prints dos testes (Postman ou Swagger)  

2. **Documentação técnica:**
   - Adicionar modelos conceitual e lógico em `/docs/modelagem/`
   - Adicionar prints de tela em `/docs/screenshots/`
   - Instruções para rodar o projeto localmente:
     ```bash
     git clone https://github.com/usuario/nome-do-projeto.git
     cd nome-do-projeto
     mvn spring-boot:run
     ```

3. **Slides de apresentação:**
   - Introdução e objetivo do sistema  
   - Modelagem conceitual e lógica  
   - Descrição das entidades  
   - Prints dos endpoints CRUD  
   - Desafios enfrentados e soluções  
   - Link para o repositório GitHub  

📎 **Resultado esperado:**  
README completo, documentação salva em `/docs`, slides prontos para a apresentação.

---

### 🧩 Etapa 7 — Apresentação Final (21/11)
🎯 **Objetivo:** demonstrar o funcionamento do sistema e explicar as etapas.

**Tarefas:**
- Mostrar o projeto rodando (ou prints dos endpoints)  
- Explicar:
  - Tema e objetivo do projeto  
  - Modelagem das entidades  
  - Funcionamento do CRUD  
  - Desafios enfrentados e soluções  
- Entregar:
  - ✅ Link do GitHub  
  - ✅ Slides (PDF ou PowerPoint)  

📎 **Resultado esperado:**  
Apresentação clara, com domínio do código e entendimento das etapas.

---

## 🧠 Critérios de Avaliação
- ✅ Implementação completa das operações CRUD  
- ✅ Estrutura organizada em pacotes  
- ✅ Uso correto das anotações do Spring Boot  
- ✅ Persistência funcional no banco de dados  
- ✅ Modelagem conceitual e lógica bem definidas  
- ✅ Documentação clara e bem estruturada  
- ✅ Apresentação objetiva e explicativa  

---

## 👤 Autor
**Nomes:** Gabriel C, José e Luiz

**Curso:** Desenvolvimento backend

**Data de Entrega:** 21/11/2025  

---

✨ *“Código limpo é melhor que código inteligente.” — Robert C. Martin*
