package gestorAluno;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		int escolha;
		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("\n ");
			System.out.println("- Bem vindo ao seu sistema de gestão");
			System.out.println("----> Escolha uma das opções no menu");
			System.out.println("[1] - Listar todos os alunos");
			System.out.println("[2] - Listar Alunos Aprovados/Reprovados");
			System.out.println("[3] - Listar Alunos por Média");
			System.out.println("[4] - Listar Alunos por faltas");
			System.out.println("[0] - Encerrar");

			escolha = teclado.nextInt();
			teclado.nextLine();

			switch (escolha) {
			case 1:
				Alunos.ExibirTodosAlunos();
				break;
			case 2:
				subMenuStatus();
				break;
			case 3:
				Alunos.ordenarAlunos("media");
				break;
			case 4:
				Alunos.ordenarAlunos("faltas");
				break;
			case 0:
				System.out.println("Encerrando sistema.");
				break;
			default:
				System.out.println("Opção inválida" + "\n" + "Por favor, escolha a opção disponivel .");
			}
		} while (escolha != 0);
		teclado.close();
	}

	public static void subMenuStatus() {

		Scanner teclado = new Scanner(System.in);

		System.out.println("----> Escolha uma das opções no menu");
		System.out.println("[1] - Alunos Aprovados");
		System.out.println("[2] - Alunos Reprovados");
		System.out.println("[3] - Retornar ao Menu anterior");

		int escolha = teclado.nextInt();
		teclado.nextLine();

		switch (escolha) {

		case 1:
			Alunos.ExibirAlunosAprovados("Aprovado");
			menu();
			break;

		case 2:
			Alunos.ExibirAlunosReprovados("Reprovados");
			menu();
			break;
		case 3:
			menu();
			break;
		case 0:
			System.out.println("Encerrando sistema.");
		default:
			System.out.println("Opção inválida" + "\n" + "Por favor, escolha a opção disponivel .");
			teclado.close();
		}

		teclado.close();
	}
}
