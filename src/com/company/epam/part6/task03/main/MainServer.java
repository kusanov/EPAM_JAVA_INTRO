package com.company.epam.part6.task03.main;

import com.company.epam.part6.task03.entity.Archive;
import com.company.epam.part6.task03.entity.ArchiveService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {

	public static void main(String[] args) {

		String localhost = "127.0.0.1";
		String RMI_HOSTNAME = "java.rmi.server.hostname";

		try {
			System.setProperty(RMI_HOSTNAME, localhost);

			ArchiveService archive = Archive.getInstance();

			String serviceName = "Archive";

			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(serviceName, archive);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
