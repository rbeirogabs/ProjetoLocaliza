# ProjetoLocaliza

Sistema de Gerenciamento de Locação de Veículos desenvolvido em Java com arquitetura em camadas (Model, Repository, Service) seguindo princípios SOLID.

## 🏗️ Arquitetura e Padrões de Projeto

### Critérios Implementados:
✅ **Classe Abstrata** - `EntidadeBase` (classe abstrata com método abstrato)  
✅ **Herança** - Todas as entidades herdam de `EntidadeBase`  
✅ **Método Abstrato** - `atualizar()` implementado em todas as classes  
✅ **Sobrecarga de Método** - Múltiplos construtores e métodos de busca  
✅ **Sobrecarga de Construtor** - Todos os serviços e repositórios possuem múltiplos construtores  
✅ **Interfaces** - `IRepositorio<T>` e `IServico<T>` para contrato  
✅ **ArrayList** - Utilizados em todos os repositórios para persistência  
✅ **CRUD Completo** - Cadastrar, listar, atualizar e remover em todas as entidades  

## 📁 Estrutura de Pastas

```
ProjetoLocaliza/
├── model/                          # Camada de Modelo
│   ├── EntidadeBase.java          # Classe abstrata base
│   ├── Carro.java                 # Entidade Carro
│   ├── Cliente.java               # Entidade Cliente
│   ├── Aluguel.java               # Entidade Aluguel
│   ├── Funcionario.java           # Entidade Funcionário
│   ├── Pagamento.java             # Entidade Pagamento
│   ├── Manutencao.java            # Entidade Manutenção
│   └── Seguro.java                # Entidade Seguro
│
├── interfaces/                     # Camada de Contratos
│   ├── IRepositorio.java          # Interface genérica para repositórios
│   └── IServico.java              # Interface genérica para serviços
│
├── repositories/                   # Camada de Persistência
│   ├── CarroRepositorio.java      # CRUD de Carros (ArrayList)
│   ├── ClienteRepositorio.java    # CRUD de Clientes (ArrayList)
│   ├── AluguelRepositorio.java    # CRUD de Aluguéis (ArrayList)
│   ├── FuncionarioRepositorio.java# CRUD de Funcionários (ArrayList)
│   ├── PagamentoRepositorio.java  # CRUD de Pagamentos (ArrayList)
│   ├── ManutencaoRepositorio.java # CRUD de Manutenções (ArrayList)
│   └── SeguroRepositorio.java     # CRUD de Seguros (ArrayList)
│
├── services/                       # Camada de Negócio
│   ├── CarroServico.java          # Regras de negócio para Carros
│   ├── ClienteServico.java        # Regras de negócio para Clientes
│   ├── AluguelServico.java        # Regras de negócio para Aluguéis
│   ├── FuncionarioServico.java    # Regras de negócio para Funcionários
│   ├── PagamentoServico.java      # Regras de negócio para Pagamentos
│   ├── ManutencaoServico.java     # Regras de negócio para Manutenções
│   └── SeguroServico.java         # Regras de negócio para Seguros
│
└── App.java                        # Menu Principal Interativo

```

## 📋 Menu Principal com 7 Opções:

1. **Gerenciar Carros** - Cadastrar, listar, buscar, atualizar e remover
2. **Gerenciar Clientes** - Cadastrar, listar, buscar por CPF, atualizar e remover
3. **Gerenciar Aluguéis** - Cadastrar, listar, buscar, atualizar e remover
4. **Gerenciar Funcionários** - Cadastrar, listar, buscar, atualizar e remover
5. **Gerenciar Pagamentos** - Cadastrar, listar, buscar, atualizar e remover
6. **Gerenciar Manutenções** - Cadastrar, listar, buscar, atualizar e remover
7. **Gerenciar Seguros** - Cadastrar, listar, buscar, atualizar e remover

## ✨ Características:

- Interface de menu interativa com Scanner
- Persistência de dados em ArrayList (em memória)
- Dados de exemplo pré-carregados para testes
- CRUD completo para todas as 5 entidades principais
- Interfaces genéricas para código reutilizável
- Classe abstrata com métodos abstratos
- Herança e polimorfismo
- Validações e regras de negócio
- Sistema de IDs com auto-incremento
