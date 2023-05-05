package br.edu.unespar.mercado;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	public static Queue queue1 = new PriorityQueue<Integer>();
	public static Queue queue2 = new PriorityQueue<Integer>();
	public static Queue queue3 = new PriorityQueue<Integer>();
	public static boolean stop = false;
	
	public static void main(String[] args) {
		
		
		long inicio = System.currentTimeMillis();
		long fim = System.currentTimeMillis();
		
		Thread fila = new Thread(new GeradorDeClientes());
		fila.start();
		
		System.out.println("Abrindo os caixas");
		Thread caixa1 = new Thread(new Caixa(1));
		Thread caixa2 = new Thread(new Caixa(2));
		Thread caixa3 = new Thread(new Caixa(3));
		caixa1.start();
		caixa2.start();
		caixa3.start();
		
		while((fim - inicio) <= 5 * 100000) {
			fim = System.currentTimeMillis();
		}
		
	}
	
	public synchronized static int getCliente(int i) {
		Queue q = Main.queue1;
		if(i == 2) {
			q = Main.queue2;
		}else if(i == 3) {
			q = Main.queue3;
		}
		
		if(q.size() > 0) {
			int deq = (int) q.poll();
			return deq;
		}
		return 0;
		
	}

}
