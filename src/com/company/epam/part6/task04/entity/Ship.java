package com.company.epam.part6.task04.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Ship implements Runnable {

	private static int genID = 1;
	private int id;
	private BlockingQueue<Cargo> shipStorage;
	private int maxCargoQuantity;
	private int currentCargoQuantity;
	private boolean isUnloaded = false;
	private Harbor harbor;
	private Pier pier;

	public Ship(int currentCargoQuantity, int maxCargoQuantity, Harbor harbor) {
		id = genID++;
		this.harbor = harbor;
		setMaxCargoQuantity(maxCargoQuantity);
		setCurrentCargoQuantity(currentCargoQuantity);
		shipStorage = new ArrayBlockingQueue<>(maxCargoQuantity);
		fillShip();
		printShip();
	}

	@Override
	public void run() {
		takePier();
		if (!isUnloaded && currentCargoQuantity != 0) {
			unloadShip();
		}
		if (isUnloaded && currentCargoQuantity == 0) {
			loadShip();
		}
		printShip();
		leavePier();
	}

	private void loadShip() {
		try {
			//System.out.println(this + " ready to be loaded!");
			while (currentCargoQuantity < maxCargoQuantity * 0.5) {
				Cargo cargo = harbor.takeCargo();
				shipStorage.put(cargo);
				currentCargoQuantity++;
			}
			//printShip();
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(this + " was loaded in the " + pier);
	}

	private void unloadShip() {

		try {
			//System.out.println(this + " ready to be unloaded in the " + pier);
			while (currentCargoQuantity != 0) {
				Cargo cargo = shipStorage.take();
				harbor.addCargo(cargo);
				currentCargoQuantity--;
			}
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		isUnloaded = true;
		System.out.println(this + " was unloaded in the " + pier);
	}

	private void takePier() {
		do {
			pier = harbor.getPier();
			try {
				if (pier == null) {
					TimeUnit.MILLISECONDS.sleep(500);
					System.out.println("All the piers are busy!");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (pier == null);
		System.out.println("IN: " + this + " is moored to " + pier);
	}

	private void leavePier() {
		harbor.releasePier(pier);
		System.out.println("OUT: " + this + " has left " + pier);
	}

	private void fillShip() {
		for (int i = 0; i < currentCargoQuantity; i++) {
			shipStorage.add(new Cargo());
		}
	}

	public int getCurrentCargoQuantity() {
		return currentCargoQuantity;
	}

	public void setCurrentCargoQuantity(int currentCargoQuantity) {
		if (currentCargoQuantity <= maxCargoQuantity) {
			this.currentCargoQuantity = currentCargoQuantity;
		} else {
			throw new IllegalArgumentException("Must be less than maxCargoQuantity" + currentCargoQuantity);
		}
	}

	public int getMaxCargoQuantity() {
		return maxCargoQuantity;
	}

	public void setMaxCargoQuantity(int maxCargoQuantity) {
		if (maxCargoQuantity <= 0) {
			throw new IllegalArgumentException("Must be greater than 0: " + maxCargoQuantity);
		} else {
			this.maxCargoQuantity = maxCargoQuantity;
		}
	}

	private void printShip() {
		StringBuilder sb = new StringBuilder();
		sb.append(this).append("{");
		for (Cargo cargo : shipStorage) {
			sb.append(cargo).append(", ");
		}
		System.out.println(sb.toString().substring(0, sb.length() - 2) + "}");
	}

	@Override
	public String toString() {
		return "The ship #" + id;
	}
}
