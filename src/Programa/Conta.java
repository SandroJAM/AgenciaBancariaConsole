package Programa;

import Utilitarios.Utils;

public class Conta {

	private static int contadorDeContas = 1;

	private int numeroConta;
	private Cliente cliente;
	private double saldo = 0.0;

	public Conta(Cliente cliente) {
		this.numeroConta = contadorDeContas;
		this.cliente = cliente;
		contadorDeContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return "\nNumero da Conta: " + this.getNumeroConta() + "\nNome do Cliente: " + this.cliente.getNome()
				+ "\nCPF do Cliente: " + this.cliente.getCpf() + "\nNEmail Cliente: " + this.cliente.getEmail()
				+ "\nTelefone Cliente: " + this.cliente.getTelefone() + "\nSaldo da Conta : "
				+ Utils.doubleToString(getSaldo());
	}

	public void depositar(double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Depósito Realizado com Sucesso!");
		} else {
			System.out.println("Não Foi Possível Realizar o Depósito!");
		}
	}

	public void sacar(double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque Realizado com Sucesso!");
		} else {
			System.out.println("Não Foi Possível Realizar o Saque!");
		}
	}

	public void transferir(Conta contaPoupanca, double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaPoupanca.saldo = contaPoupanca.getSaldo() + valor;
			System.out.println("Transferência Realizada com Sucesso!");
		} else {
			System.out.println("Não Foi Possível Realizar a Transferência!");
		}
	}

}