package com.company.epam.part6.task03.entity;

import org.w3c.dom.*;

import javax.xml.transform.TransformerFactoryConfigurationError;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ArchiveService extends Remote {


    void addStudent(Document document) throws TransformerFactoryConfigurationError, DOMException, RemoteException;


}