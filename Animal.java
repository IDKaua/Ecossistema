package br.com.uninassau.floresta;

import java.util.List;
import java.util.Random;

public class Animal {
	// variaveis da classe Animal
	private char abbreviation;
	private String name, species;
	private int life;
	private int atualX;
	private int atualY;

	// Construtor da classe Animal
	public Animal(String name, String species, char abbreviation, int life, int startX, int startY) {
		// Inicializa os campos com os valores passados como argumentos
		this.name = name;
		this.species = species;
		this.abbreviation = abbreviation;
		this.life = life;
		this.atualX = startX;
		this.atualY = startY;
	}

	// MÉTODOS DO ANIMAL

	// retorna o nome do animal
	public String getName() {
		return name;
	};

	// retorna a especie do animal
	public String getSpecies() {
		return species;
	}

	// retorna a sigla do animal
	public char getabbreviation() {
		return abbreviation;
	}

	// retorna a quantidade de vida do animal
	public int getLife() {
		return life;
	}

	// retorna a coordenada X do animal
	public int getAtualX() {
		return atualX;
	}

	// retorna a coordenada Y do animal
	public int getAtualY() {
		return atualY;
	}

	// Define a vida do animal
	public void setLife(int life) {
		this.life = life;
	}

	// Diminui a vida do animal em 1
	public void decreaseLife() {
		this.life--;
	}

	// Aumenta a vida do animal em 1
	public void increaseLife() {
		this.life++;
	}

	// Mover o animal no terreno
	public void andar(Terreno terreno, List<Animal> animals) {
		// Gera uma direção de movimento aleatória (0 a 3)
		int direcao = new Random().nextInt(4);
		int novoX = atualX;
		int novoY = atualY;

		switch (direcao) {
		case 0: // baixo
			novoX++;
			break;
		case 1: // cima
			novoX--;
			break;
		case 2: // direita
			novoY++;
			break;
		case 3: // esquerda
			novoY--;
			break;
		}

		// Verifica se as novas coordenadas estão dentro do terreno
		if (novoX >= 0 && novoX < terreno.getTamanho() && novoY >= 0 && novoY < terreno.getTamanho()) {
			if (animals.contains(this)) {
				terreno.tirarAnimal(atualX, atualY, animals);
				atualX = novoX;
				atualY = novoY;
				terreno.adicionarAnimal(this, novoX, novoY);
			}

		}
	}

	public boolean podeAtacar(Animal outroAnimal) {
		return this.getSpecies().equals("Predador") && !this.equals(outroAnimal)
				&& outroAnimal.getSpecies().equals("Presa");
	}

	public void atacar(Animal outroAnimal) {
		if (this.podeAtacar(outroAnimal)) {
			outroAnimal.decreaseLife();
		}
	}
}