package com.company.epam.part6.task03.entity;

import org.w3c.dom.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Archive extends UnicastRemoteObject implements ArchiveService{

	private static final long serialVersionUID = 1L;

	private static Archive instance;


	private List<Person> list;

	private Archive() throws RemoteException {
		super();
		this.list = new ArrayList<>();
	}

	public static Archive getInstance() throws RemoteException {
		if (instance == null) {
			return new Archive();
		} else {
			return instance;
		}
	}

	@Override
	public void addStudent(Document document) throws TransformerFactoryConfigurationError, DOMException, RemoteException {
		// Получаем корневой элемент
		Node root = document.getDocumentElement();

		// Создаем нового студента
		// Сам <Student>
		Element student = document.createElement("Student");
		// <Name>
		Element name = document.createElement("Name");
		name.setTextContent("Sergei");
		student.appendChild(name);
		// <Lastname>
		Element lastname = document.createElement("Lastname");
		lastname.setTextContent("Kusanov");
		student.appendChild(lastname);
		out.println("");
		// <Sex>
		Element sex = document.createElement("Sex");
		sex.setTextContent("Male");
		student.appendChild(sex);
		// <Address>
		Element address = document.createElement("Address");
		address.setTextContent("Minsk");
		student.appendChild(address);
		// <Faculty>
		Element faculty = document.createElement("Faculty");
		faculty.setTextContent("Java Web Development");
		student.appendChild(faculty);
		// Добавляем книгу в корневой элемент
		root.appendChild(student);
		// Записываем XML в файл
		writeDocument(document);
	}


	// Функция для сохранения DOM в файл
	public static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
		try {
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(document);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\kusan\\IdeaProjects\\EPAM\\Fundamentals" +
					"\\src\\com\\company\\epam\\part6\\task03xml\\server/Students.xml");
			StreamResult result = new StreamResult(fos);
			tr.transform(source, result);
		} catch (TransformerException | IOException e) {
			e.printStackTrace(out);
		}
	}
}
