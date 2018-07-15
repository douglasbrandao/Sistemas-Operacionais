package br.ifmt.edu.br.so.imp1;

// Programa de implementa��o para a solu��o do problema Produtor-Consumidor

public class Main {

	public static void main(String[] args) throws InterruptedException {

		final ProdutorConsumidor pc = new ProdutorConsumidor();

		// Cria��o do thread do produtor

		Thread t1 = new Thread(new Runnable() {@Override
			public void run() {
				try {
					pc.produtor();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Cria��o do thread do consumidor

		Thread t2 = new Thread(new Runnable() {@Override
			public void run() {
				try {
					pc.consumidor();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Inicia os dois threads

		t1.start();
		t2.start();

		// t1 finaliza antes de t2

		t1.join();
		t2.join();
	}
}