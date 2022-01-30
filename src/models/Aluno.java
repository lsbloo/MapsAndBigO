package models;


public class Aluno {
	private String identifier;
	private String name;
	private String age;
	private String turma;
	
	public Aluno() {}
	public Aluno(String identifier, String name, String age, String turma) {
		setIdentifier(identifier);
		setName(name);
		setAge(age);
		setTurma(turma);
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getIdentifier() {
		return this.identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
