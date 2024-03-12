package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------- Bem vindo ao Fuctura-Bank --------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("****** Selecione a operação que deseja realizar ********");
		System.out.println("--------------------------------------------------------");
		System.out.println("|                   Opção 1 - Criar Conta              |");
		System.out.println("|                   Opção 2 - Depositar                |");
		System.out.println("|                   Opção 3 - Sacar                    |");
		System.out.println("|                   Opção 4 - Transferir               |");
		System.out.println("|                   Opção 5 - Listar                   |");
		System.out.println("|                   Opção 6 - Sair                     |");
		System.out.println("--------------------------------------------------------");

		int operacao = entrada.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Obrigado por ser nosso Cliente");
			System.exit(0);

		default:
			System.out.println("Opção Inválida!");
			operacoes();
			break;

		}
	}

	public static void criarConta() {

		System.out.print("Nome    : " );
		String nome = entrada.next();

		System.out.print("CPF     : ");
		String cpf = entrada.next();

		System.out.print("Email   : ");
		String email = entrada.next();

		System.out.print("Telefone: ");
		String telefone = entrada.next();

		Cliente cliente = new Cliente(nome, cpf, email, telefone);

		Conta conta = new Conta(cliente);

		contasBancarias.add(conta);
		System.out.println("Sua Conta foi criada como Sucesso!");
		operacoes();

	}

	public static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta)
					;
				conta = c;
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Número da Conta: ");
		int numeroConta = entrada.nextInt();
		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			System.out.print("Qual valor que deseja depositar? ");
			double valorDeposito = entrada.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor Depositado com Sucesso!");
		} else {
			System.out.println("Conta Não Encontrada!");
		}
		operacoes();
	}

	public static void sacar() {

		System.out.println("Número da Conta: ");
		int numeroConta = entrada.nextInt();
		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			System.out.print("Qual valor que deseja sacar? ");
			double valorsaque = entrada.nextDouble();
			conta.sacar(valorsaque);
			System.out.println("Saque Realizado com Sucesso!");
		} else {
			System.out.println("Conta Não Encontrada!");
		}
		operacoes();
	}

	public static void transferir() {
		System.out.print("Informe o Número da Conta de Origem: ");
		int numeroContaOrigem = entrada.nextInt();
		Conta contaOrigem = encontrarConta(numeroContaOrigem);
		if (contaOrigem != null) {
			System.out.print("Informe o Número da Conta de Destino: ");
			int numeroContaDestino = entrada.nextInt();

			Conta contaDestino = encontrarConta(numeroContaDestino);

			if (contaDestino != null) {
				System.out.print("Informe o Valor a Transferir: ");
				double valor = entrada.nextDouble();

				contaOrigem.transferir(contaDestino, valor);
			}
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não Existe Contas Cadastradas!");
		}
		operacoes();
	}

}