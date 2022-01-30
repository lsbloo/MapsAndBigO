package maps;

import models.Aluno;
import java.util.List;

/**
 * 
 * @author osvaldoairon
 * 
 * -> 
 */
public interface AlunosMap<K,V> {
	
	
	/**
	 * 
	 * @param identificador
	 * @return Aluno
	 *  -> retorna um Aluno de acordo com seu identificador (KEY)
	 */
	Aluno recuperarAlunoPorIdentificador(String identificador);
	
	/**
	 * 
	 * @param identificador
	 * @param aluno
	 * @return 
	 *  -> atualiza um aluno de acordo com seu identificador e a nova instancia do Aluno
	 *  -> retorna a instancia de Aluno antiga depois da atualização;
	 */
	Aluno atualizarAluno(String identificador, Aluno aluno);
	/**
	 * 
	 * @return
	 *  -> retorna a quantidade de entradas no hashMap;
	 */
	int recuperarTamanhoMap();
	/**
	 * 
	 * @param identificador
	 * @param aluno
	 * -> salva um aluno de acordo com seu identificador (KEY) e valor de entrada (Aluno)
	 * -> se a inserção ocorrer com sucesso retorna true : false;
	 */
	Object salvarAluno(String identificador, Aluno aluno);
	
	boolean salvarAluno(List<Aluno> listAluno);
	
	boolean estaVazio();
	
	/**
	 * 
	 * @param identificador
	 * @return
	 * -> permite remover um Aluno (value) de acordo com o identificador (KEY)
	 * retorna true se a remoção foi um sucesso;
	 */
	boolean removerAluno(String identificador);
	/**
	 * 
	 * @return
	 *  -> retorna a lista de alunos
	 */
	List<Aluno> listarAlunos();
	
	/**
	 * retorna a lista de identificadores dos alunos;
	 * @return
	 */
	List<String> listarIdentificadores();
}
