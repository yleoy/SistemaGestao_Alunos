package gestorAluno;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Leitor {

	public static void IniciarJson() {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("src/json/alunos.json")) {

			Object obj = jsonParser.parse(reader);
			JSONArray alunosLista = (JSONArray) obj;

			alunosLista.forEach(aluno -> parserAlunos((JSONObject) aluno));

		} catch (IOException e) {
			System.out.println("Erro de leitura do arquivo: " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Erro ao interpretar o JSON: " + e.getMessage());
		}
	}

	public static void parserAlunos(JSONObject aAluno) {
		System.out.println(Integer.parseInt(aAluno.get("id").toString()));
		System.out.print(aAluno.get("primeiro_nome") + " ");
		System.out.println(aAluno.get("ultimo_nome"));
		double nota1 = (aAluno.get("nota_1") == null ? 0.0 : Double.parseDouble(aAluno.get("nota_1").toString()));
		double nota2 = (aAluno.get("nota_2") == null ? 0.0 : Double.parseDouble(aAluno.get("nota_2").toString()));
		double nota3 = (aAluno.get("nota_3") == null ? 0.0 : Double.parseDouble(aAluno.get("nota_3").toString()));
		double nota4 = (aAluno.get("nota_4") == null ? 0.0 : Double.parseDouble(aAluno.get("nota_4").toString()));
		int faltas = Integer.parseInt(aAluno.get("faltas").toString());
		System.out.printf("Notas: %.1f, %.1f, %.1f, %.1f \n", nota1, nota2, nota3, nota4);
		System.out.printf("Total de Faltas: %d", faltas);

		System.out.println("\n-----------------------------");
	}

}
