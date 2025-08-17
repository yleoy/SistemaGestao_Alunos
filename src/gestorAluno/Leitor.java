package gestorAluno;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Leitor {

	public static List<Alunos> IniciarJson() {
		
		JSONParser jsonParser = new JSONParser();
		List<Alunos> listaAlunos = new ArrayList<>();

		try (FileReader reader = new FileReader("src/json/alunos.json")) {

			Object obj = jsonParser.parse(reader);
			JSONArray alunosLista = (JSONArray) obj;
			
			for (Object alunoObj : alunosLista) {
				JSONObject aAluno = (JSONObject) alunoObj;

				int id = Integer.parseInt(aAluno.get("id").toString());
				String primeiroNome = (String) aAluno.get("primeiro_nome");
				String ultimoNome = (String) aAluno.get("ultimo_nome");
				double nota1 = (aAluno.get("nota_1") == null ? 0.0
						: Double.parseDouble(aAluno.get("nota_1").toString()));
				double nota2 = (aAluno.get("nota_2") == null ? 0.0
						: Double.parseDouble(aAluno.get("nota_2").toString()));
				double nota3 = (aAluno.get("nota_3") == null ? 0.0
						: Double.parseDouble(aAluno.get("nota_3").toString()));
				double nota4 = (aAluno.get("nota_4") == null ? 0.0
						: Double.parseDouble(aAluno.get("nota_4").toString()));
				int faltas = Integer.parseInt(aAluno.get("faltas").toString());

				Alunos alunos = new Alunos(id, primeiroNome, ultimoNome, nota1, nota2, nota3, nota4, faltas);
				listaAlunos.add(alunos);
			}

		} catch (IOException e) {
			System.out.println("Erro de leitura do arquivo: " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Erro ao interpretar o JSON: " + e.getMessage());
		}
		
		return listaAlunos;
	}
}
