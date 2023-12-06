package br.com.uninassau.floresta;

public class Arbusto extends Planta {

	public Arbusto(int atualX, int atualY) {
		super('*', "Arbusto", atualX, atualY);
	}

	// Método para o animal se esconder
	public void esconderAnimal(Animal animal) {
		System.out.printf("%c está escondido %n", animal.getabbreviation());
	}
}