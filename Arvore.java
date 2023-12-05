package br.com.uninassau.floresta;

public class Arvore extends Planta {
	public Arvore(int atualX, int atualY) {
		super('|', "Arvore", atualX, atualY);
	}

	public void alimentarAnimal(Animal animal) {
		System.out.printf("%c recebeu +1 de vida por ter se alimentado %n", animal.getabbreviation());
		animal.increaseLife();
	}
}
