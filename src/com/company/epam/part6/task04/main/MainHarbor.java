package com.company.epam.part6.task04.main;


import com.company.epam.part6.task04.entity.Cargo;
import com.company.epam.part6.task04.entity.Harbor;
import com.company.epam.part6.task04.entity.Ship;

import java.util.Random;


public class MainHarbor {

	public static void main(String[] args) {
//		Задание 4. Многопоточность. Порт. Корабли заходят в порт для
//		разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
//		в порту и на корабле, должно быть неотрицательным и превышающим заданную
//		грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
//				У одного причала может стоять один корабль. Корабль может загружаться у причала
//		или разгружаться

		Harbor harbor = new Harbor("Central", 3, 10);

		Thread[] shipThreads = new Thread[5];
		Random random = new Random();

		for (int i = 0; i < shipThreads.length; i++) {
			int current = random.nextInt(2) + 2;
			int max = random.nextInt(current) + current;
			shipThreads[i] = new Thread(new Ship(current, max, harbor));
		}

		for (Thread ship : shipThreads) {
			ship.start();
			try {
				ship.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("The cargoes are remaining in the harbor storage:");
		for (Cargo cargo : harbor.getStorage()){
			System.out.print(cargo + ", ");
		}
	}
}
