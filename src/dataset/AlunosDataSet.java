package dataset;

import java.util.ArrayList;
import java.util.List;
import models.Aluno;

public class AlunosDataSet {
	public static List<Aluno> getDataSetAluno(){
		ArrayList<Aluno> newList = new ArrayList<Aluno>();
		newList.add(new Aluno("1",
				"Gabriela","23","TURMA A"));
		newList.add(new Aluno("2",
				"Joao Silva","26","TURMA B"));
		newList.add(new Aluno("3",
				"Matheus Pinheiro","21","TURMA D"));
		newList.add(new Aluno("4",
				"Ragna LothBrok","18","TURMA C"));
		newList.add(new Aluno("5",
				"Thor","38","TURMA A"));
		newList.add(new Aluno("6",
				"Peter Parker","20","TURMA B"));
		return newList;
	} 
	public static List<Aluno> getDataSetAlunoGeneratorMD5Identifier(){
		ArrayList<Aluno> newList = new ArrayList<Aluno>();
		newList.add(new Aluno(KeyGeneratorIdentifier.getIdentifier("1"),
				"Gabriela","23","TURMA A"));
		newList.add(new Aluno(KeyGeneratorIdentifier.getIdentifier("2"),
				"Joao Silva","26","TURMA B"));
		newList.add(new Aluno(KeyGeneratorIdentifier.getIdentifier("3"),
				"Matheus Pinheiro","21","TURMA D"));
		newList.add(new Aluno(KeyGeneratorIdentifier.getIdentifier("4"),
				"Ragna LothBrok","18","TURMA C"));
		newList.add(new Aluno(KeyGeneratorIdentifier.getIdentifier("5"),
				"Thor","38","TURMA A"));
		newList.add(new Aluno(KeyGeneratorIdentifier.getIdentifier("6"),
				"Peter Parker","20","TURMA B"));
		return newList;
	}
}
