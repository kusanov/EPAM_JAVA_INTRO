package com.company.epam.part6.task03.main;

import com.company.epam.part6.task03.entity.ArchiveService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Locale;

import static java.lang.System.out;

public class MainArchive {
//	Задание 3: создайте клиент-серверное приложение “Архив”.
//	Общие требования к заданию:
//			• В архиве хранятся Дела (например, студентов). Архив находится на сервере.
//			• Клиент, в зависимости от прав, может запросить дело на просмотр, внести в
//	него изменения, или создать новое дело.
//	Требования к коду лабораторной работы:
//			• Для реализации сетевого соединения используйте сокеты.
//			• Формат хранения данных на сервере – xml-файлы.

	public static void main(String[] args) {

		String localhost = "127.0.0.1";
		String RMI_HOSTNAME = "java.rmi.server.hostname";
		String SERVICE_PATH = "rmi://localhost/Archive";

		try {

			System.setProperty(RMI_HOSTNAME, localhost);
			ArchiveService archive = (ArchiveService) Naming.lookup(SERVICE_PATH);
			// Создается построитель документа
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			// Создается дерево DOM документа из файла
			Document document = documentBuilder.parse("src\\com\\company\\epam\\part6\\task03\\resources" +
					"\\Students.xml");

			// Получаем корневой элемент
			Node root = document.getDocumentElement();

			System.out.println("List of students:");
			System.out.println("===========>>>>");
			// Просматриваем все подэлементы корневого - т.е. студентов
			NodeList students = root.getChildNodes();
			for (int i = 0; i < students.getLength(); i++) {
				Node student = students.item(i);
				// Если нода не текст, то это книга - заходим внутрь
				if (student.getNodeType() != Node.TEXT_NODE) {
					NodeList studentProps = student.getChildNodes();
					for(int j = 0; j < studentProps.getLength(); j++) {
						Node studentProp = studentProps.item(j);
						// Если нода не текст, то это один из параметров студента - печатаем
						if (studentProp.getNodeType() != Node.TEXT_NODE) {
							System.out.println(studentProp.getNodeName() + ":" + studentProp.getChildNodes().item(0).getTextContent());
						}
					}
					System.out.println("===========>>>>");
				}
			}

			System.out.println("Поиск студента по номеру:");
			XPathFactory pathFactory = XPathFactory.newInstance();
			XPath xpath = pathFactory.newXPath();
			XPathExpression expr = xpath.compile("Students/Student[2]");
			NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++) {
				Node n = nodes.item(i);
				System.out.println("Студент:" + n.getTextContent());
			}

			System.out.println("Поиск студента по фамилии:");
			XPathFactory pathFactory2 = XPathFactory.newInstance();
			XPath xpath2 = pathFactory2.newXPath();
			XPathExpression expr2 = xpath2.compile("//Students/Student[starts-with(Lastname,'Ivanov')]");
			NodeList nodes2 = (NodeList) expr2.evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodes2.getLength(); i++) {
				Node n = nodes2.item(i);
				System.out.println("Студент №" + (i+1) + ":" + n.getTextContent());
			}
			out.println("Все фамилии переводим в верхний регистр");
			NodeList studentsUpdate = document.getElementsByTagName("Student");
			Element studentUp;
			for (int i = 0; i < studentsUpdate.getLength(); i++) {
				studentUp = (Element) studentsUpdate.item(i);
				Node lastname = studentUp.getElementsByTagName("Lastname").item(0).getFirstChild();
				lastname.setNodeValue(lastname.getNodeValue().toUpperCase(Locale.ROOT));
			}
			archive.addStudent(document);
//			archive.updateStudent(document);

			System.out.println("Печать всех студентов");
			XPathFactory pathFactory3 = XPathFactory.newInstance();
			XPath xpath3 = pathFactory3.newXPath();
			XPathExpression expr3 = xpath3.compile("//Students/Student");

			NodeList nodes3 = (NodeList) expr3.evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodes3.getLength(); i++) {
				Node n = nodes3.item(i);
				System.out.println("Студент №" + (i+1) + ":" + n.getTextContent());
			}


		} catch (ParserConfigurationException ex) {
			ex.printStackTrace(System.out);
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();

		}

	}

}

