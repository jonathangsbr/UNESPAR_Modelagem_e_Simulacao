package br.edu.unespar.mercado;

import java.util.Queue;
import java.util.Random;

public class GeradorDeClientes implements Runnable {

	@Override
	public void run() {
		while(!Main.stop) {
			Random sleep = new Random();
			Random carrinho = new Random();
			Queue q = Main.queue1;
			int num = 1;
			
			if(Main.queue2.size() < q.size()) {
				q = Main.queue2;
				num = 2;
			}else if(Main.queue3.size() < q.size()) { 
				q = Main.queue3;
				num = 3;
			}
			
			try {
				int enq = carrinho.nextInt(30) + 1;
				q.add(enq);
				System.out.println("Chegando cliente na fila do caixa " + num + " com " + enq + " itens");
				System.out.println("Fila do Caixa 1 " + Main.queue1.toString());
				System.out.println("Fila do Caixa 2 " + Main.queue2.toString());
				System.out.println("Fila do Caixa 3 " + Main.queue3.toString() + "\n\n");
				Thread.currentThread();
				Thread.sleep(sleep.nextInt(10000));
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
