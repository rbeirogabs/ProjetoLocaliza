# 🚗 LocalizaP - Sistema de Gerenciamento de Locação de Veículos

Sistema completo de gerenciamento de locadora de veículos desenvolvido em Java com arquitetura em camadas (Model, Repository, Service) seguindo princípios SOLID e boas práticas de Programação Orientada a Objetos.

---

## 📌 Sobre o Projeto

O **LocalizaP** é uma aplicação console para gerenciar todos os aspectos de uma locadora de veículos, incluindo:
- 🚙 Cadastro e controle de carros
- 👤 Gerenciamento de clientes e funcionários
- 📝 Gestão de aluguéis e contratos
- 💰 Controle de pagamentos
- 🔧 Agendamento de manutenções
- 🛡️ Administração de seguros

---

## 🏗️ Arquitetura do Sistema

O projeto segue uma arquitetura em **3 camadas** com separação clara de responsabilidades:

```
┌─────────────────────────────────────────────────────────┐
│                    APP.JAVA (UI)                        │
│              Menu Interativo do Usuário                 │
└───────────────────────┬─────────────────────────────────┘
                        │
┌───────────────────────▼─────────────────────────────────┐
│                 CAMADA DE SERVIÇOS                      │
│   Regras de Negócio e Validações (implements IServico) │
│   CarroServico, ClienteServico, AluguelServico...      │
└───────────────────────┬─────────────────────────────────┘
                        │
┌───────────────────────▼─────────────────────────────────┐
│              CAMADA DE REPOSITÓRIOS                     │
│   Persistência em ArrayList (implements IRepositorio)   │
│   CarroRepositorio, ClienteRepositorio...               │
└───────────────────────┬─────────────────────────────────┘
                        │
┌───────────────────────▼─────────────────────────────────┐
│                 CAMADA DE MODELO                        │
│   Entidades do Domínio (extends EntidadeBase)          │
│   Carro, Cliente, Aluguel, Funcionario...              │
└─────────────────────────────────────────────────────────┘
```

---

## 📂 Estrutura de Diretórios

```
ProjetoLocaliza/
│
├── 📄 App.java                      # Classe principal com menu interativo
├── 📄 README.md                     # Documentação do projeto
├── 📄 LICENSE                       # Licença do projeto
│
├── 📁 model/                        # 🎯 Camada de Modelo (Entidades)
│   ├── EntidadeBase.java           # Classe abstrata base com ID auto-incremento
│   ├── Carro.java                  # Entidade Carro (modelo, placa, diária)
│   ├── Cliente.java                # Entidade Cliente (nome, CPF, CNH)
│   ├── Aluguel.java                # Entidade Aluguel (cliente, carro, datas)
│   ├── Funcionario.java            # Entidade Funcionário (cargo, salário)
│   ├── Pagamento.java              # Entidade Pagamento (tipo, valor, status)
│   ├── Manutencao.java             # Entidade Manutenção (carro, tipo, custo)
│   └── Seguro.java                 # Entidade Seguro (tipo, valor, vigência)
│
├── 📁 interfaces/                   # 🔌 Camada de Contratos
│   ├── IRepositorio.java           # Interface genérica para repositórios
│   └── IServico.java               # Interface genérica para serviços
│
├── 📁 repositories/                 # 💾 Camada de Persistência (ArrayList)
│   ├── CarroRepositorio.java       # CRUD de Carros
│   ├── ClienteRepositorio.java     # CRUD de Clientes
│   ├── AluguelRepositorio.java     # CRUD de Aluguéis
│   ├── FuncionarioRepositorio.java # CRUD de Funcionários
│   ├── PagamentoRepositorio.java   # CRUD de Pagamentos
│   ├── ManutencaoRepositorio.java  # CRUD de Manutenções
│   └── SeguroRepositorio.java      # CRUD de Seguros
│
└── 📁 services/                     # ⚙️ Camada de Lógica de Negócio
    ├── CarroServico.java           # Validações e regras para Carros
    ├── ClienteServico.java         # Validações e regras para Clientes
    ├── AluguelServico.java         # Validações e regras para Aluguéis
    ├── FuncionarioServico.java     # Validações e regras para Funcionários
    ├── PagamentoServico.java       # Validações e regras para Pagamentos
    ├── ManutencaoServico.java      # Validações e regras para Manutenções
    └── SeguroServico.java          # Validações e regras para Seguros
```

---

## 🎓 Critérios de POO Implementados

| Critério | Status | Implementação | Localização |
|----------|--------|---------------|-------------|
| **Classe Abstrata** | ✅ | `EntidadeBase` | `model/EntidadeBase.java` |
| **Método Abstrato** | ✅ | `obterDescricao()` | `model/EntidadeBase.java` (linha 20) |
| **Herança** | ✅ | Todas as 7 entidades estendem `EntidadeBase` | Todas as classes em `model/` |
| **Sobrecarga de Método** | ✅ | `exibir()` e `exibir(String)` | `model/EntidadeBase.java` (linhas 23-28) |
| **Sobrecarga de Construtor** | ✅ | 3-4 construtores em todas as classes | Todas as entidades, serviços e repositórios |
| **Interfaces** | ✅ | `IRepositorio<T>` e `IServico<T>` | `interfaces/` |
| **ArrayList** | ✅ | Usado em todos os 7 repositórios | `repositories/` |
| **CRUD Completo** | ✅ | Create, Read, Update, Delete em todas as 7 entidades | Todos os repositórios e serviços |
| **Polimorfismo** | ✅ | Implementação de interfaces e sobrescrita de métodos | Todo o projeto |
| **Encapsulamento** | ✅ | Atributos privados com getters/setters | Todas as classes modelo |

---

## 🎮 Funcionalidades do Sistema

### 📋 Menu Principal

```
============================================
   SISTEMA DE GERENCIAMENTO LOCALIZA   
============================================
1. 🚗 Gerenciar Carros
2. 👤 Gerenciar Clientes
3. 📝 Gerenciar Aluguéis
4. 👔 Gerenciar Funcionários
5. 💰 Gerenciar Pagamentos
6. 🛡️ Gerenciar Seguros
7. 🔧 Gerenciar Manutenções
8. 📊 Relatório Geral
0. 🚪 Sair
============================================
```

### 🚗 Módulo de Carros
- ➕ Cadastrar novo carro (modelo, placa, valor diária, cor, combustível)
- 📋 Listar todos os carros
- 🔍 Buscar carro por placa
- 💵 Atualizar valor da diária
- ✅ Verificar disponibilidade

### 👤 Módulo de Clientes
- ➕ Cadastrar novo cliente (nome, CPF, CNH, telefone, email)
- 📋 Listar todos os clientes
- 🔍 Buscar cliente por CPF

### 📝 Módulo de Aluguéis
- ➕ Criar novo aluguel (cliente + carro + data + local)
- 📋 Listar todos os aluguéis
- ❌ Cancelar aluguel (libera o carro)
- 🔄 Controle automático de disponibilidade do carro

### 👔 Módulo de Funcionários
- ➕ Cadastrar funcionário (nome, CPF, cargo, departamento)
- 📋 Listar funcionários
- 📄 Gerar relatório individual

### 💰 Módulo de Pagamentos
- ➕ Criar pagamento (tipo: Cartão/PIX/Dinheiro, valor)
- 📋 Listar pagamentos
- ✅ Processar pagamento
- ↩️ Estornar pagamento

### 🛡️ Módulo de Seguros
- ➕ Criar seguro (código, tipo, carro, valor)
- 📋 Listar seguros ativos

### 🔧 Módulo de Manutenções
- ➕ Agendar manutenção (código, carro, tipo)
- 📋 Listar manutenções
- 🚫 Torna carro indisponível durante manutenção

### 📊 Relatório Geral
Exibe estatísticas completas do sistema:
- Total de carros e carros disponíveis
- Total de clientes cadastrados
- Total de aluguéis e aluguéis ativos
- Total de funcionários
- Total de pagamentos e valor processado
- Total de seguros ativos
- Total de manutenções agendadas

---

## 🔧 Como Executar

### Pré-requisitos
- ☕ **Java JDK 17** ou superior
- 💻 IDE (VS Code, IntelliJ, Eclipse) ou terminal

### Passos para Execução

#### Opção 1: Via Terminal
```bash
# Navegue até a pasta do projeto
cd ProjetoLocaliza

# Compile todos os arquivos
javac App.java model/*.java repositories/*.java services/*.java interfaces/*.java

# Execute a aplicação
java App
```

#### Opção 2: Via IDE
1. Abra o projeto na sua IDE favorita
2. Localize o arquivo `App.java`
3. Execute o método `main`

---

## 💡 Conceitos de POO Demonstrados

### 1️⃣ **Abstração**
```java
public abstract class EntidadeBase {
    public abstract String obterDescricao(); // Método abstrato
}
```

### 2️⃣ **Herança**
```java
public class Carro extends EntidadeBase { }
public class Cliente extends EntidadeBase { }
```

### 3️⃣ **Polimorfismo**
```java
@Override
public String obterDescricao() {
    return "Carro{id=" + id + ", modelo='" + modelo + "'}";
}
```

### 4️⃣ **Encapsulamento**
```java
private String nome;
public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }
```

### 5️⃣ **Interfaces**
```java
public interface IRepositorio<T> {
    void adicionar(T entidade);
    ArrayList<T> listar();
}
```

### 6️⃣ **Generics**
```java
public class CarroRepositorio implements IRepositorio<Carro> { }
public class ClienteServico implements IServico<Cliente> { }
```

---

## 🗂️ Detalhes Técnicos

### Sistema de IDs Automático
Cada entidade possui um ID único gerado automaticamente:
```java
protected static int contadorId = 1;
public EntidadeBase() {
    this.id = contadorId++;  // Auto-incremento global
}
```

### Persistência em Memória
Os dados são armazenados em `ArrayList` durante a execução:
```java
private ArrayList<Carro> carros = new ArrayList<>();
```

### Validações de Negócio
Cada serviço implementa validações específicas:
```java
@Override
public boolean validar(Carro carro) {
    if (carro.getModelo() == null || carro.getModelo().trim().isEmpty()) 
        return false;
    if (carro.getValorDiaria() <= 0) 
        return false;
    return true;
}
```

---

## 📊 Dados de Exemplo

O sistema é inicializado com dados de exemplo:

**Carros pré-cadastrados:**
- Gol (Branco, Flex) - R$ 150,00/dia
- Civic (Preto, Gasolina) - R$ 250,00/dia
- Onix (Prata, Flex) - R$ 180,00/dia

**Clientes pré-cadastrados:**
- João Silva
- Maria Santos

**Funcionários pré-cadastrados:**
- Carlos Oliveira (Gerente)

---

## 👨‍💻 Autores

Desenvolvido como projeto acadêmico de Programação Orientada a Objetos.

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 🚀 Melhorias Futuras

- [ ] Persistência em banco de dados (MySQL/PostgreSQL)
- [ ] Interface gráfica (JavaFX ou Swing)
- [ ] Sistema de login com autenticação
- [ ] Relatórios em PDF
- [ ] API REST com Spring Boot
- [ ] Cálculo automático de valores de aluguel
- [ ] Sistema de multas e descontos
- [ ] Notificações por email

---

**Feito com ☕ e 💙 em Java**
