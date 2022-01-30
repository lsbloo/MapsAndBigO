package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import dataset.AlunosDataSet;
import models.Aluno;

/**
 * 
 * @author osvaldoairon
 * 
 * Description:
 *   -> Define um conjunto de operações relacionadas a persistencia de informações de alunos
 *   -> Implementa metodos assinados da interface Map como auxiliar;
 *   -> Cria um conjunto de regras para inserção/remoção e atualizaçoes dos dados
 *   -> Espera-se um HashMap padrão na construção ;
 */
public class AlunosHashMap implements AlunosMap<String, Aluno>{
	
	private HashMap<String, Aluno> alunosHashMap;
	private OperationsObserver operationsObserver;
	public AlunosHashMap(HashMap<String, Aluno> hashMap, OperationsObserver operationsObserver) {
		setAlunosHashMap(hashMap);
		this.setOperationsObserver(operationsObserver);
	}

	public HashMap<String, Aluno> getAlunosHashMap() {
		return alunosHashMap;
	}

	public void setAlunosHashMap(HashMap<String, Aluno> alunosHashMap) {
		this.alunosHashMap = alunosHashMap;
	}

	@Override
	public Aluno recuperarAlunoPorIdentificador(String identificador) {
		Aluno result =  this.alunosHashMap.get(identificador);
		operationsObserver.notifyDataSet(Operations.RECUPERAR, result, getMapRepresentation());
		return result;
	}

	@Override
	public Aluno atualizarAluno(String identificador, Aluno aluno) {
		Aluno alunoUpdated = this.alunosHashMap.put(identificador, aluno);
		this.operationsObserver.notifyDataSet(Operations.ATUALIZAR, alunoUpdated,getMapRepresentation());
		return alunoUpdated;
	}

	@Override
	public int recuperarTamanhoMap() {
		this.operationsObserver.notifyDataSet(Operations.TAMANHO, this.alunosHashMap.size(), getMapRepresentation());
		return this.alunosHashMap.size();
	}

	@Override
	public boolean removerAluno(String identificador) {
		boolean result = this.alunosHashMap.remove(identificador) != null ? true : false;
		operationsObserver.notifyDataSet(Operations.REMOVER, result, getMapRepresentation());
		return result;
	}

	@Override
	public List<Aluno> listarAlunos() {
		return (List<Aluno>) this.alunosHashMap.values();
	}

	@Override
	public List<String> listarIdentificadores() {
		List<String> keySet = (List<String>) this.alunosHashMap.keySet();
		return keySet;
	}	

	public void showStatusMap(Operations operation, List<Boolean> outputs, List<String> mapRepresentation) {
		if(operation == Operations.SALVAR) {
			Set<String> keyset = this.alunosHashMap.keySet();
			Integer count = 0;
			for(String key : keyset) {
				System.out.format("%10s %20s %20s",
						operation,outputs.get(count), mapRepresentation.get(count)
						);
				count++;
				System.out.println();
			}
			
		}
	}
	
	public void showStatusMap(Operations operation, Object outputs, String mapRepresentation) {
				if(outputs == null) {
					System.out.format("%10s %20s %20s",operation,"null", mapRepresentation);
					System.out.println();
				}else {
				System.out.format("%10s %20s %20s",operation,outputs.toString(), mapRepresentation);
				System.out.println();
				}
	}
	
	private String t() {
		Set<String> keyset = this.alunosHashMap.keySet();
		List<String> t = new ArrayList<String>();
		String s1 = "{" ;
		String s2 = "}";
		String q = "";
		for(String key : keyset) {
			q = "["+key + ","+this.alunosHashMap.get(key).getName()+"]";
			s1 += q;
			}
		return s1 += s2;
	}
	
	public void showHeaderTable() {
		System.out.println("##################################"
				+ "##################### HashMap Alunos #############"
				+ "###############################");
		System.out.printf("%10s %20s %20s", "[OPERAÇÃO]", "[SAÍDA]", "[MAPA]");
        System.out.println();
	}

	@Override
	public boolean salvarAluno(List<Aluno> listAluno) {
		List<Object> outputs = new ArrayList<Object>();
		List<String> mapRepresentation = new ArrayList<String>();
		Integer count = 0;
		for(Aluno aluno: listAluno) {
			outputs.add(salvarAluno(
					aluno.getIdentifier(), aluno));
			mapRepresentation.add(t());
			operationsObserver.notifyDataSet(Operations.SALVAR, outputs.get(count), 
					mapRepresentation.get(count));
			count++;
		}
		return true;
	}

	@Override
	public boolean estaVazio() {
		boolean result = this.alunosHashMap.isEmpty();
		operationsObserver.notifyDataSet(Operations.VAZIO, result, emptyState());
		return result;
	}

	public OperationsObserver getOperationsObserver() {
		return operationsObserver;
	}

	public void setOperationsObserver(OperationsObserver operationsObserver) {
		this.operationsObserver = operationsObserver;
	}
	
	private String getMapRepresentation() {
		return t();
	}
	private String emptyState() {
		return "{ [0] }";
	}

	@Override
	public Object salvarAluno(String identificador, Aluno aluno) {
			return this.alunosHashMap.put(identificador, aluno) == null ? null : this.alunosHashMap.get(identificador);	
		}
}
