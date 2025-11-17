import model.*;
import services.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static ClienteServico clienteServico;
    private static CarroServico carroServico;
    private static AluguelServico aluguelServico;
    private static FuncionarioServico funcionarioServico;
    private static PagamentoServico pagamentoServico;
    private static SeguroServico seguroServico;
    private static ManutencaoServico manutencaoServico;
    
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        inicializarDados();
        
        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    menuCarros();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 3:
                    menuAlugueis();
                    break;
                case 4:
                    menuFuncionarios();
                    break;
                case 5:
                    menuPagamentos();
                    break;
                case 6:
                    menuSeguros();
                    break;
                case 7:
                    menuManutencoes();
                    break;
                case 8:
                    exibirRelatorioGeral();
                    break;
                case 0:
                    System.out.println("\n=== Sistema encerrado. Até logo! ===");
                    continuar = false;
                    break;
                default:
                    System.out.println("\n❌ Opção inválida!");
            }
        }
        
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--------------------------------------------");
        System.out.println("   SISTEMA DE GERENCIAMENTO LOCALIZA   ");
        System.out.println("--------------------------------------------");
        System.out.println("1. Gerenciar Carros");
        System.out.println("2. Gerenciar Clientes");
        System.out.println("3. Gerenciar Aluguéis");
        System.out.println("4. Gerenciar Funcionários");
        System.out.println("5. Gerenciar Pagamentos");
        System.out.println("6. Gerenciar Seguros");
        System.out.println("7. Gerenciar Manutenções");
        System.out.println("8. Relatório Geral");
        System.out.println("0. Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    private static void menuCarros() {
        System.out.println("\n=== GERENCIAR CARROS ===");
        System.out.println("1. Cadastrar Carro");
        System.out.println("2. Listar Carros");
        System.out.println("3. Buscar Carro");
        System.out.println("4. Atualizar Valor da Diária");
        System.out.println("5. Verificar Disponibilidade");
        System.out.print("Opção: ");
        
        int opcao = lerOpcao();
        switch (opcao) {
            case 1:
                cadastrarCarro();
                break;
            case 2:
                listarCarros();
                break;
            case 3:
                buscarCarro();
                break;
            case 4:
                atualizarValorDiaria();
                break;
            case 5:
                verificarDisponibilidadeCarro();
                break;
        }
    }

    private static void cadastrarCarro() {
        System.out.println("\n--- Cadastrar Novo Carro ---");
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Valor da Diária: R$ ");
        double valor = Double.parseDouble(scanner.nextLine());
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Tipo de Combustível: ");
        String combustivel = scanner.nextLine();
        
        Carro carro = new Carro(modelo, placa, valor, cor, combustivel);
        carroServico.cadastrar(carro);
        System.out.println("✓ Carro cadastrado com sucesso!");
    }

    private static void listarCarros() {
        System.out.println("\n=== LISTA DE CARROS ===");
        ArrayList<Carro> carros = carroServico.listar();
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            for (int i = 0; i < carros.size(); i++) {
                System.out.println((i + 1) + ". " + carros.get(i));
            }
        }
    }

    private static void buscarCarro() {
        System.out.print("\nDigite a placa do carro: ");
        String placa = scanner.nextLine();
        Carro carro = carroServico.buscarPorPlaca(placa);
        
        if (carro != null) {
            carro.mostrarInfo();
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    private static void atualizarValorDiaria() {
        System.out.print("\nDigite a placa do carro: ");
        String placa = scanner.nextLine();
        Carro carro = carroServico.buscarPorPlaca(placa);
        
        if (carro != null) {
            System.out.print("Novo valor da diária: R$ ");
            double novoValor = Double.parseDouble(scanner.nextLine());
            carro.atualizarValorDiaria(novoValor);
            System.out.println("✓ Valor atualizado!");
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    private static void verificarDisponibilidadeCarro() {
        System.out.print("\nDigite a placa do carro: ");
        String placa = scanner.nextLine();
        Carro carro = carroServico.buscarPorPlaca(placa);
        
        if (carro != null) {
            carro.checarDisponibilidade();
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    private static void menuClientes() {
        System.out.println("\n=== GERENCIAR CLIENTES ===");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Buscar Cliente");
        System.out.print("Opção: ");
        
        int opcao = lerOpcao();
        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                listarClientes();
                break;
            case 3:
                buscarCliente();
                break;
        }
    }

    private static void cadastrarCliente() {
        System.out.println("\n--- Cadastrar Novo Cliente ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("CNH: ");
        String cnh = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        
        Cliente cliente = new Cliente(nome, cnh, cpf, telefone, email, genero);
        clienteServico.cadastrar(cliente);
        System.out.println("✓ Cliente cadastrado com sucesso!");
    }

    private static void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        ArrayList<Cliente> clientes = clienteServico.listar();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println((i + 1) + ". " + clientes.get(i));
            }
        }
    }

    private static void buscarCliente() {
        System.out.print("\nDigite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = clienteServico.buscarPorCpf(cpf);
        
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void menuAlugueis() {
        System.out.println("\n=== GERENCIAR ALUGUÉIS ===");
        System.out.println("1. Criar Aluguel");
        System.out.println("2. Listar Aluguéis");
        System.out.println("3. Cancelar Aluguel");
        System.out.print("Opção: ");
        
        int opcao = lerOpcao();
        switch (opcao) {
            case 1:
                criarAluguel();
                break;
            case 2:
                listarAlugueis();
                break;
            case 3:
                cancelarAluguel();
                break;
        }
    }

    private static void criarAluguel() {
        System.out.println("\n--- Criar Novo Aluguel ---");
        
        listarClientes();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = clienteServico.buscarPorCpf(cpf);
        
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        listarCarrosDisponiveis();
        System.out.print("Digite a placa do carro: ");
        String placa = scanner.nextLine();
        Carro carro = carroServico.buscarPorPlaca(placa);
        
        if (carro == null || !carro.isDisponivel()) {
            System.out.println("Carro não disponível!");
            return;
        }
        
        System.out.print("Local de retirada: ");
        String local = scanner.nextLine();
        
        Aluguel aluguel = new Aluguel(cliente, carro, LocalDate.now(), local);
        aluguel.criarAluguel();
        carro.alugarCarro();
        aluguelServico.cadastrar(aluguel);
        
        System.out.println("✓ Aluguel criado com sucesso!");
    }

    private static void listarAlugueis() {
        System.out.println("\n=== LISTA DE ALUGUÉIS ===");
        ArrayList<Aluguel> alugueis = aluguelServico.listar();
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel registrado.");
        } else {
            for (int i = 0; i < alugueis.size(); i++) {
                System.out.println((i + 1) + ". " + alugueis.get(i) + " | Confirmado: " + alugueis.get(i).isConfirmado());
            }
        }
    }

    private static void cancelarAluguel() {
        listarAlugueis();
        System.out.print("\nDigite o número do aluguel para cancelar: ");
        int index = lerOpcao() - 1;
        
        ArrayList<Aluguel> alugueis = aluguelServico.listar();
        if (index >= 0 && index < alugueis.size()) {
            Aluguel aluguel = alugueis.get(index);
            aluguel.cancelarAluguel();
            aluguel.getCarro().setDisponivel(true);
            System.out.println("✓ Aluguel cancelado!");
        } else {
            System.out.println("Aluguel inválido!");
        }
    }

    private static void menuFuncionarios() {
        System.out.println("\n=== GERENCIAR FUNCIONÁRIOS ===");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Gerar Relatório");
        System.out.print("Opção: ");
        
        int opcao = lerOpcao();
        switch (opcao) {
            case 1:
                cadastrarFuncionario();
                break;
            case 2:
                listarFuncionarios();
                break;
            case 3:
                gerarRelatorioFuncionario();
                break;
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n--- Cadastrar Funcionário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        Funcionario funcionario = new Funcionario(nome, cpf, cargo, departamento, telefone);
        funcionarioServico.cadastrar(funcionario);
        System.out.println("✓ Funcionário cadastrado!");
    }

    private static void listarFuncionarios() {
        System.out.println("\n=== LISTA DE FUNCIONÁRIOS ===");
        ArrayList<Funcionario> funcionarios = funcionarioServico.listar();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (int i = 0; i < funcionarios.size(); i++) {
                System.out.println((i + 1) + ". " + funcionarios.get(i));
            }
        }
    }

    private static void gerarRelatorioFuncionario() {
        listarFuncionarios();
        System.out.print("\nDigite o número do funcionário: ");
        int index = lerOpcao() - 1;
        
        ArrayList<Funcionario> funcionarios = funcionarioServico.listar();
        if (index >= 0 && index < funcionarios.size()) {
            funcionarios.get(index).gerarRelatorio();
        } else {
            System.out.println("Funcionário inválido!");
        }
    }

    private static void menuPagamentos() {
        System.out.println("\n=== GERENCIAR PAGAMENTOS ===");
        System.out.println("1. Criar Pagamento");
        System.out.println("2. Listar Pagamentos");
        System.out.println("3. Processar Pagamento");
        System.out.println("4. Estornar Pagamento");
        System.out.print("Opção: ");
        
        int opcao = lerOpcao();
        switch (opcao) {
            case 1:
                criarPagamento();
                break;
            case 2:
                listarPagamentos();
                break;
            case 3:
                processarPagamento();
                break;
            case 4:
                estornarPagamento();
                break;
        }
    }

    private static void criarPagamento() {
        System.out.println("\n--- Criar Pagamento ---");
        System.out.print("Tipo (Cartão/PIX/Dinheiro): ");
        String tipo = scanner.nextLine();
        System.out.print("Valor: R$ ");
        double valor = Double.parseDouble(scanner.nextLine());
        
        Pagamento pagamento = new Pagamento(tipo, valor);
        pagamentoServico.cadastrar(pagamento);
        System.out.println("✓ Pagamento criado!");
    }

    private static void listarPagamentos() {
        System.out.println("\n=== LISTA DE PAGAMENTOS ===");
        ArrayList<Pagamento> pagamentos = pagamentoServico.listar();
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento registrado.");
        } else {
            for (int i = 0; i < pagamentos.size(); i++) {
                System.out.println((i + 1) + ". " + pagamentos.get(i));
            }
        }
    }

    private static void processarPagamento() {
        listarPagamentos();
        System.out.print("\nDigite o número do pagamento: ");
        int index = lerOpcao() - 1;
        
        ArrayList<Pagamento> pagamentos = pagamentoServico.listar();
        if (index >= 0 && index < pagamentos.size()) {
            pagamentos.get(index).processarPagamento();
        } else {
            System.out.println("Pagamento inválido!");
        }
    }

    private static void estornarPagamento() {
        listarPagamentos();
        System.out.print("\nDigite o número do pagamento: ");
        int index = lerOpcao() - 1;
        
        ArrayList<Pagamento> pagamentos = pagamentoServico.listar();
        if (index >= 0 && index < pagamentos.size()) {
            pagamentos.get(index).estornarPagamento();
        } else {
            System.out.println("Pagamento inválido!");
        }
    }

    private static void menuSeguros() {
        System.out.println("\n=== GERENCIAR SEGUROS ===");
        System.out.println("1. Criar Seguro");
        System.out.println("2. Listar Seguros");
        System.out.print("Opção: ");
        
        int opcao = lerOpcao();
        switch (opcao) {
            case 1:
                criarSeguro();
                break;
            case 2:
                listarSeguros();
                break;
        }
    }

    private static void criarSeguro() {
        System.out.println("\n--- Criar Seguro ---");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        
        listarCarros();
        System.out.print("Digite a placa do carro: ");
        String placa = scanner.nextLine();
        Carro carro = carroServico.buscarPorPlaca(placa);
        
        if (carro == null) {
            System.out.println("Carro não encontrado!");
            return;
        }
        
        System.out.print("Valor: R$ ");
        double valor = Double.parseDouble(scanner.nextLine());
        
        Seguro seguro = new Seguro(codigo, tipo, carro);
        seguro.setValor(valor);
        seguro.setInicio(LocalDate.now());
        seguro.setTermino(LocalDate.now().plusYears(1));
        seguroServico.cadastrar(seguro);
        
        System.out.println("✓ Seguro criado!");
    }

    private static void listarSeguros() {
        System.out.println("\n=== LISTA DE SEGUROS ===");
        ArrayList<Seguro> seguros = seguroServico.listar();
        if (seguros.isEmpty()) {
            System.out.println("Nenhum seguro cadastrado.");
        } else {
            for (int i = 0; i < seguros.size(); i++) {
                System.out.println((i + 1) + ". " + seguros.get(i));
            }
        }
    }

    private static void menuManutencoes() {
        System.out.println("\n=== GERENCIAR MANUTENÇÕES ===");
        System.out.println("1. Agendar Manutenção");
        System.out.println("2. Listar Manutenções");
        System.out.print("Opção: ");
        
        int opcao = lerOpcao();
        switch (opcao) {
            case 1:
                agendarManutencao();
                break;
            case 2:
                listarManutencoes();
                break;
        }
    }

    private static void agendarManutencao() {
        System.out.println("\n--- Agendar Manutenção ---");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        
        listarCarros();
        System.out.print("Digite a placa do carro: ");
        String placa = scanner.nextLine();
        Carro carro = carroServico.buscarPorPlaca(placa);
        
        if (carro == null) {
            System.out.println("Carro não encontrado!");
            return;
        }
        
        System.out.print("Tipo de manutenção: ");
        String tipo = scanner.nextLine();
        
        Manutencao manutencao = new Manutencao(codigo, carro, tipo);
        manutencaoServico.cadastrar(manutencao);
        carro.setDisponivel(false);
        
        System.out.println("✓ Manutenção agendada!");
    }

    private static void listarManutencoes() {
        System.out.println("\n=== LISTA DE MANUTENÇÕES ===");
        ArrayList<Manutencao> manutencoes = manutencaoServico.listar();
        if (manutencoes.isEmpty()) {
            System.out.println("Nenhuma manutenção cadastrada.");
        } else {
            for (int i = 0; i < manutencoes.size(); i++) {
                System.out.println((i + 1) + ". " + manutencoes.get(i));
            }
        }
    }

    private static void exibirRelatorioGeral() {
        System.out.println("\n--------------------------------------------");
        System.out.println("RELATÓRIO GERAL DO SISTEMA");
        System.out.println("--------------------------------------------");
        System.out.println("Total de Carros: " + carroServico.totalCarros());
        System.out.println("Carros Disponíveis: " + contarCarrosDisponiveis());
        System.out.println("Total de Clientes: " + clienteServico.totalClientes());
        System.out.println("Total de Aluguéis: " + aluguelServico.totalAlugueis());
        System.out.println("Aluguéis Ativos: " + contarAlugueisAtivos());
        System.out.println("Total de Funcionários: " + funcionarioServico.totalFuncionarios());
        System.out.println("Total de Pagamentos: " + pagamentoServico.totalPagamentos());
        System.out.println("Pagamentos Processados: " + contarPagamentosProcessados());
        System.out.println("Total de Seguros: " + seguroServico.totalSeguros());
        System.out.println("Total de Manutenções: " + manutencaoServico.totalManutencoes());
    }

    private static void inicializarDados() {
        carroServico = new CarroServico();
        clienteServico = new ClienteServico();
        aluguelServico = new AluguelServico();
        funcionarioServico = new FuncionarioServico();
        pagamentoServico = new PagamentoServico();
        seguroServico = new SeguroServico();
        manutencaoServico = new ManutencaoServico();
        
        carroServico.cadastrar(new Carro("Gol", "ABC-1234", 150.0, "Branco", "Flex"));
        carroServico.cadastrar(new Carro("Civic", "XYZ-5678", 250.0, "Preto", "Gasolina"));
        carroServico.cadastrar(new Carro("Onix", "DEF-9012", 180.0, "Prata", "Flex"));
        
        clienteServico.cadastrar(new Cliente("João Silva", "11111111111", "12345678900", "11999999999", "joao@email.com", "M"));
        clienteServico.cadastrar(new Cliente("Maria Santos", "22222222222", "98765432100", "11988888888", "maria@email.com", "F"));
        
        funcionarioServico.cadastrar(new Funcionario("Carlos Oliveira", "55555555555", "Gerente", "Atendimento", "11977777777"));
        
        System.out.println("✓ Sistema inicializado com dados de exemplo!");
    }

    private static void listarCarrosDisponiveis() {
        System.out.println("\n=== CARROS DISPONÍVEIS ===");
        ArrayList<Carro> carros = carroServico.listarDisponiveis();
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro disponível no momento.");
        } else {
            for (Carro c : carros) {
                System.out.println("- " + c);
            }
        }
    }

    private static int contarCarrosDisponiveis() {
        return carroServico.totalCarrosDisponiveis();
    }

    private static int contarAlugueisAtivos() {
        return aluguelServico.totalAlugueisConfirmados();
    }

    private static int contarPagamentosProcessados() {
        int count = 0;
        for (Pagamento p : pagamentoServico.listar()) {
            if (p.getStatus().equals("Pago")) count++;
        }
        return count;
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
