package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.Processo;

public class Interface {
	public static void main(String[] args) {
		List<Processo> listaDeProcessos = new ArrayList<Processo>();
		Random numeroAleatorio = new Random();
		Scanner leitor = new Scanner(System.in);
		int quantidadeProcessos = 0;
		
		System.out.println("Quantos processo deseja gerar?");
		try {
			quantidadeProcessos = leitor.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\nDeve ser informado um valor inteiro!");
		}
		
		if (quantidadeProcessos < 0) {
			System.out.println("\nDeve ser informado um valor inteiro positivo!");
		}
		
		if (quantidadeProcessos > 50) {
			System.out.println("A quantidade digitada ultrapassa o limite!");
		} else {
			for (int i = 0; i < quantidadeProcessos; i++) {
				Float at = numeroAleatorio.nextFloat();
				int bt = numeroAleatorio.nextInt(1, 35);
				int prioridadeInterna = numeroAleatorio.nextInt(0, 5);
				listaDeProcessos.add(new Processo(at, bt, prioridadeInterna));
			}
			
			Processo.incluirPid(listaDeProcessos);
			
			System.out.println("\n\n-----Lista-----");
			for (Processo processo : listaDeProcessos) {
				System.out.println(processo);
			}
			
			System.out.println("\n\n-----Lista ordenada-----");
			for (Processo processo : Processo.ordenarPrioridadeInterna(listaDeProcessos)) {
				System.out.println(processo);
			}
		}
		leitor.close();
	}
}
