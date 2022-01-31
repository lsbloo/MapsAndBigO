package main;

import models.Aluno;

import java.util.HashMap;
import java.util.List;

import dataset.AlunosDataSet;
import dataset.KeyGeneratorIdentifier;
import maps.AlunosHashMap;
import maps.Operations;
import maps.OperationsObserver;
import java.util.List;

public class MapsBigOApplication {

	private static AlunosHashMap hashMapAlunos;
	public static void main(String args[]) {
		setupHashMapAlunos();
	}
	
	
	public static void setupHashMapAlunos() {
			hashMapAlunos = new AlunosHashMap(new HashMap<String, Aluno>(), new OperationsObserver() {
				@SuppressWarnings("unchecked")
				@Override
				public void notifyDataSet(Operations operations, Object output, String map) {
					if(output == null) {
					hashMapAlunos.showStatusMap(operations, null , map);
					} else {
						hashMapAlunos.showStatusMap(operations, output , map);
					}
				}
				
			});
		hashMapAlunos.showHeaderTable();
		hashMapAlunos.estaVazio();
		hashMapAlunos.salvarAluno(AlunosDataSet.getDataSetAluno());
		hashMapAlunos.atualizarAluno(
				AlunosDataSet.getDataSetAluno().get(0).getIdentifier(), 
				new Aluno(KeyGeneratorIdentifier.getIdentifier("20"),"Osvaldo","14","Turma C"));
		hashMapAlunos.removerAluno(AlunosDataSet.getDataSetAluno().get(1).getIdentifier());
		hashMapAlunos.recuperarAlunoPorIdentificador(AlunosDataSet.getDataSetAluno().get(3).getIdentifier());
		hashMapAlunos.recuperarAlunoPorIdentificador("320");
		hashMapAlunos.recuperarTamanhoMap();
	}
}
