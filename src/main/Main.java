package main;

import java.util.Scanner;

import objetos.DataVacina;


public class Main {
    

    public static void main(String[] args){
        DataVacina sistema = new DataVacina();
        String menu =  "\n\nBem vindo!!!\n\n" +
        "Escolha uma das opções abaixo digitando o número correspondente: \n" + 
        "1 - Cadastro de  pessoa \n" +
        "2 - Vacinar pessoa \n" +
        "3 - Avançarpessoa para proxima fase da vacinação.\n" + 
        "4 - Alterar comorbidades/doenças da pessoa. \n" + 
        "5 - Alterar profissão da pessoa\n" + 
        "6 - Visualizar situação. \n" + 
        "7 - Listar pessoas nao habilitadas\n" +
        "8 - Listar pessoas habilitadas a tomar a 1° dose\n" +
        "9 - Listar pessoas habilitadas a tomar a 2° dose\n" + 
        "10 - Listar pessoas que tomaram a 1° dose \n" + 
        "11 - Listar pessoas que tomaram as 2 doses \n" + 
        "12 - Informações Vacinação \n" + 
        "13 - Habilitar comorbidade para vacinação\n" +
        "14 - Habilitar profissão para vacinação\n" +
        "15 - Atualizar idade minima para vacinaçãoo\n" + 
        "0 - Sair";
        
        
        Scanner sc = new Scanner(System.in);
        int opcao;
        
        while(true){
            System.out.println(menu);
            System.out.println("Digite sua opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();
            String cpf;
            String comorbidades;
            String profissao;
            switch(opcao){
                case(1):
                    cadastrarPessoa(sc, sistema);
                    break;
                case(2):
                    System.out.println("cpf da pessoa");
                    cpf = sc.nextLine();
                    sistema.tomarVacina(cpf);
                    break;
                case(3):
                    System.out.println("cpf da pessoa");
                    cpf = sc.nextLine();
                    sistema.avancarEtapa(cpf);
                    break;
                case(4):
                    System.out.println("cpf da pessoa");
                    cpf = sc.nextLine();
                    System.out.println("Informe as comorbidades da pessoa (com esaço entre elas)");
                    comorbidades = sc.nextLine();
                    sistema.setPessoaComorbidades(cpf, comorbidades);
                    break;
                case(5):
                    System.out.println("cpf da pessoa");
                    cpf = sc.nextLine();
                    System.out.println("Profissão da pessoa");
                    profissao = sc.nextLine();
                    sistema.setProfissaoPessoa(cpf, profissao);
                    break;
                case(6):
                    System.out.println("cpf da pessoa");
                    cpf = sc.nextLine();
                    sistema.pegarSituacaoPessoa(cpf);
                    break;
                case(7):
                    sistema.listarPessoasNaoHabilitadas();
                    break;
                case(8):
                    sistema.listarPessoasHabilitadasDose1();
                    break;
                case(9):
                    sistema.listarPessoasHabilitadasDose2();
                    break;
                case(10):
                    sistema.listarPessoasTomaramDose1();
                    break;
                case(11):
                    sistema.listarPessoasImunizadas();
                    break;
                case(12):
                    sistema.getDetalhes();
                    break;
                case(13):
                    System.out.println("Comorbidade a ser habilitada");
                    comorbidades = sc.nextLine();
                    sistema.adicionarComorbidadeHabilitada(comorbidades);
                    break;
                case(14):
                    System.out.println("Profissão a ser habilitada");
                    profissao = sc.nextLine();
                    sistema.adicionarProfissaoHabilitada(profissao);
                    break;
                case(15):
                    System.out.println("Nova idade minima para vacinação");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    sistema.setIdadeMinimaHabilitada(idade);
                    break;
                case(0):
                    break;
                default: 
                    System.out.println("Opção inválida\n\n");
            }
        
            if (opcao == 0){
                System.out.println("Até logo!!!!");
                break;
            }
        }

   
    
    
    }
    public static void cadastrarPessoa(Scanner sc, DataVacina sistema){
        
        String nome;
        String cpf;
        int idade;
        String endereco;
        String cartaoDoSUS;
        String email;
        String telefone;
        String profissao;
        String comorbidades;

        System.out.println("Nome da pessoa");
        nome = sc.nextLine();

        System.out.println("Cpf da pessoa");
        cpf = sc.nextLine();

        System.out.println("Idade");
        idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Endereço");
        endereco = sc.nextLine();

        System.out.println("Número cartao do SUS");
        cartaoDoSUS = sc.nextLine();

        System.out.println("Email da pessoa");
        email = sc.nextLine();

        System.out.println("Telefone da pessoa");
        telefone = sc.nextLine();

        System.out.println("Profissão da pessoa");
        profissao = sc.nextLine();

        System.out.println("Informe as comorbidades da pessoa (com espaço entre elas)");
        comorbidades = sc.nextLine();

        sistema.adicionarPessoa(nome, cpf, idade, endereco, cartaoDoSUS, email, telefone, profissao, comorbidades);

    }
}
