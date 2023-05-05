package br.edu.unespar.mercado;

import java.util.PriorityQueue;
import java.util.Queue;

public class Caixa implements Runnable {

	private int num;
	
	public Caixa(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		while(!Main.stop) {
			Queue q = Main.queue1;
			if(num == 2) {
				q = Main.queue2;
			}else if(num == 3) {
				q = Main.queue3;
			}
			int deq = (q.size() > 0) ? (int )q.poll() : 0;

			if(deq > 0) {
				try {
					System.out.println("Caixa " + this.num + " chamando proximo da fila:");
					System.out.println("Cliente com " + deq + " itens indo para o caixa " + this.num);
					System.out.println(q.toString() + "\n\n");
					Thread.currentThread();
					Thread.sleep(deq * 1000);
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
