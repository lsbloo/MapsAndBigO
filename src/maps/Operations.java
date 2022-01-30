package maps;

public enum Operations {
	
	SALVAR("salvar"),
	RECUPERAR("recuperar"),
	ATUALIZAR("atualizar"),
	REMOVER("remover"),
	TAMANHO("tamanho"),
	VAZIO("vazio");
	
	private String operation;
	
	Operations(String operation) {
		this.operation = operation;
	}

}
