package br.com.uninassau.floresta;

import java.util.List;

public class Terreno {
	private char[][] mapa;
	private int tamanho;

	// CRIA O TAMANHO DO TERRENO

	public Terreno(int tamanho) {
		this.tamanho = tamanho;
		mapa = new char[tamanho][tamanho];
		inicializarMapa();
	}

	public int getTamanho() {
		return this.tamanho;
	}

	// INICIA O MAPA

	private void inicializarMapa() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				mapa[i][j] = ' ';
			}
		}
	}

	// ADICIONAR O ANIMAL NO MAPA

	public void adicionarAnimal(Animal animal, double x, double y) {
		if (x >= 0 && x < mapa.length && y < mapa[0].length) {
			mapa[(int) x][(int) y] = animal.getabbreviation();
		}
	}

	// ADICIONAR PLANTAS NO MAPA

	public void adicionarPlanta(char abbreviation, int posX, int posY) {
		int x = posX;
		int y = posY;

		mapa[x][y] = abbreviation;
	}

	// TIRAR ANIMAL ANIMAL DO TERRENO
	public void tirarAnimal(double xAtual, double yAtual, List<Animal> animals) {
		for (Animal animal : animals) {
			if (animal.getAtualX() == xAtual && animal.getAtualY() == yAtual) {
				mapa[(int) xAtual][(int) yAtual] = ' ';
			}
		}
	}

	// EXIBIR O TERRENO NO CONSOLE

	public void exibirTerreno(List<Animal> animals, List<Planta> plantas) {
		limparTerreno();

		for (Planta planta : plantas) {
			adicionarPlanta(planta.getAbbreviation(), planta.getAtualX(), planta.getAtualY());
		}

		for (Animal animal : animals) {
			if (animal.getLife() > 0) {
				adicionarAnimal(animal, animal.getAtualX(), animal.getAtualY());
			}
		}

		// Exibir o terreno
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				System.out.print(mapa[i][j] + "_");
			}
			System.out.println();
		}
		System.out.println();
	}

	// limpar terreno
	public void limparTerreno() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				mapa[i][j] = ' ';
			}
		}
	}

}
