package br.com.uninassau.floresta;

public class Planta {
	char abbreviation;
	int atualX;
	int atualY;
	String type;

	public Planta(char abbreviation, String type, int atualX, int atualY) {
		this.abbreviation = abbreviation;
		this.atualX = atualX;
		this.atualY = atualY;
		this.type = type;
	}

	public char getAbbreviation() {
		return abbreviation;
	}

	public int getAtualX() {
		return atualX;
	}

	public String getType() {
		return type;
	}

	public int getAtualY() {
		return atualY;
	}
}