package br.ifmt.edu.br.so.imp1;

import java.util.LinkedList;

public class ProdutorConsumidor {

	/* Crie uma lista compartilhada pelo produtor e consumidor
 	Tamanho da lista � 3. */

	LinkedList <Integer> lista = new LinkedList <>();
	int capacidade = 3;

	// Fun��o chamada pelo thread produtor

	public void produtor() throws InterruptedException {

		int valor = 1;
		
		while (true) {
			synchronized(this) {

				// thread produtor aguarda enquanto a lista est� cheia

				while (lista.size() == capacidade)
				wait();

				System.out.println("Produtor produziu: " + valor);

				// inserir os trabalhos na lista

				lista.add(valor++);

				// notifica o thread consumidor que agora pode come�ar a consumir

				notify();

				Thread.sleep(1000);
			}
		}
	}

	// Fun��o chamada pelo thread consumidor

	public void consumidor() throws InterruptedException {
		while (true) {
			synchronized(this) {

				// thread consumidor aguarda enquanto a lista est� vazia

				while (lista.size() == 0)
				wait();

				// recuperar o primeiro trabalho da lista

				int val = lista.removeFirst();

				System.out.println("Consumidor consumiu: " + val);

				// Despertar thread produtor

				notify();

				Thread.sleep(1000);
			}
		}
	}
}