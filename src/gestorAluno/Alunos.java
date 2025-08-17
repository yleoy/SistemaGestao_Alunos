package gestorAluno;

import java.util.Comparator;
import java.util.List;

public class Alunos {

	private int id;
	private String primeiroNome;
	private String ultimoNome;
	private double nota1;
	private double nota2;
	private double nota3;
	private double nota4;
	private int faltas;
	private String media;

	public Alunos(int id, String primeiroNome, String ultimoNome, double nota1, double nota2, double nota3,
			double nota4, int faltas) {
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.faltas = faltas;
	}

	public int getId() {
		return id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public double getNota1() {
		return nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public double getNota4() {
		return nota4;
	}

	public int getFaltas() {
		return faltas;
	}

	public String getMedia() {
		return media;
	}

	public double media() {

		double M = (nota1 + nota2 + nota3 + nota4) / 4.0;
		int f = (faltas);

		if (M >= 7 && f <= 7) {
			media = "Aprovado";
		} else if (M < 7) {
			media = "Reprovado por Média insuficiente";
		} else if (f > 7) {
			media = "Reprovado por Excesso de faltas";
		}
		return M;
	}

	public String exibirAlunos() {

		double M = media();

		return id + " - " + primeiroNome + " " + ultimoNome + "| Media: " + String.format("%.2f", M) + " | Faltas: "
				+ faltas + " | " + media;

	}

	public static void ExibirTodosAlunos() {
		List<Alunos> alunos = Leitor.IniciarJson();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-15s %-15s %-20s %s\n", "Id", "Nome", "Media", "Faltas", "Status" );
		System.out.println("------------------------------------------------------------------------------------");
		for (Alunos a : alunos) {
			System.out.println(a.exibirAlunos());
		}
	}

	public static void ExibirAlunosAprovados(String status) {
		List<Alunos> alunos = Leitor.IniciarJson();

		for (Alunos a : alunos) {
			a.media();
			if ("Aprovado".equalsIgnoreCase(a.getMedia())) {
				System.out.println(a.exibirAlunos());
			}
		}
	}

	public static void ExibirAlunosReprovados(String status) {
		List<Alunos> alunos = Leitor.IniciarJson();

		for (Alunos a : alunos) {
			a.media();
			if ("Reprovado por Média insuficiente".equalsIgnoreCase(a.getMedia())
					|| "Reprovado por Excesso de faltas".equalsIgnoreCase(a.getMedia())) {
				System.out.println(a.exibirAlunos());
			}
		}
	}

	public static void ordenarAlunos(String criterio) {

		List<Alunos> alunos = Leitor.IniciarJson();

		switch (criterio.toLowerCase()) {

		case "nome":
			alunos.sort(Comparator.comparing(Alunos::getPrimeiroNome).thenComparing(Alunos::getUltimoNome));
			break;
		case "media":
			alunos.sort(Comparator.comparingDouble(Alunos::media).reversed());
			break;
		case "faltas":
			alunos.sort(Comparator.comparingInt(Alunos::getFaltas));
			break;
		default:
			System.out.println("Critério inválido.");
			return;
		}

		for (Alunos a : alunos) {
			System.out.println(a.exibirAlunos());
		}

	}

}