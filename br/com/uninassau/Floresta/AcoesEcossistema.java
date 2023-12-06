package br.com.uninassau.floresta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcoesEcossistema {
	private List<Animal> animals = new ArrayList<>();
	private List<Planta> plantas = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	private Terreno terreno;
	public AcoesEcossistema() {

		terreno = new Terreno(10);

		System.out.println("Digite quantos leões você quer que tenha no terreno: ");
		int quantLeao = sc.nextInt();
		System.out.println("Digite quantos tigres você quer que tenha no terreno: ");
		int quantTigre = sc.nextInt();
		System.out.println("Digite quantos coelhos você quer que tenha no terreno: ");
		int quantCoelho = sc.nextInt();
		System.out.println("Digite quantos esquilos você quer que tenha no terreno: ");
		int quantEsquilos = sc.nextInt();
		System.out.println("Digite quantos veados você quer que tenha no terreno: ");
		int quantVeado = sc.nextInt();
		System.out.println("Digite quantos arbustos você quer que tenha no terreno: ");
		int quantArbustos = sc.nextInt();
		System.out.println("Digite quantas arvores você quer que tenha no terreno: ");
		int quantArvores = sc.nextInt();

		for (int i = 0; i < quantLeao; i++) {
			animals.add(new Leao((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantTigre; i++) {
			animals.add(new Tigre((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantCoelho; i++) {
			animals.add(new Coelho((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantEsquilos; i++) {
			animals.add(new Esquilos((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantVeado; i++) {
			animals.add(new Veado((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantArvores; i++) {
			plantas.add(new Arvore((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}
		for (int i = 0; i < quantArbustos; i++) {
			plantas.add(new Arbusto((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		System.out.println("Iniciando Ecossistema...");
	}

	// funçäo para iniciar o ecossistema no console
	public void iniciarEcossistema() {
		terreno.exibirTerreno(animals, plantas);

		while (true) {
			for (Animal animal : animals) {
				animal.andar(terreno, animals);
			}

			for (Planta planta : plantas) {
				for (Animal animal : animals) {
					if (animal.getSpecies().equals("Presa") && planta.getType().equals("Arbusto")) {
						if (animal.getAtualX() == planta.getAtualX() && animal.getAtualY() == planta.getAtualY())
							((Arbusto) planta).esconderAnimal(animal);
					}
				}
			}

			for (Planta planta : plantas) {
				for (Animal animal : animals) {
					if (animal.getSpecies().equals("Presa") && planta.getType().equals("Arvore")) {
						if (animal.getAtualX() == planta.getAtualX() && animal.getAtualY() == planta.getAtualY())
							((Arvore) planta).alimentarAnimal(animal);
					}
				}
			}

			for (Animal predador : animals) {
				if (predador.getSpecies().equals("Predador")) {
					for (Animal presa : animals) {
						if (presa.getSpecies().equals("Presa") && predador.podeAtacar(presa)) {
							if (presa.getSpecies().equals("Presa") && presa.getLife() > 0
									&& predador.getAtualX() == presa.getAtualX()
									&& predador.getAtualY() == presa.getAtualY() && predador.podeAtacar(presa)) {
								predador.atacar(presa);
								System.out.printf("%s atacou o %s%n", predador.getName(), presa.getName());
							}
						}
					}
				}
			}

			List<Animal> deadAnimals = new ArrayList<>();

			for (Animal animal : animals) {
				if (animal.getLife() == 0) {
					deadAnimals.add(animal);
				}
			}
			animals.removeAll(deadAnimals);

			terreno.exibirTerreno(animals, plantas);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}