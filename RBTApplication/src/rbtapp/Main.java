package rbtapp;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		String fileInput = args[0];
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(fileInput));
			
			doc.getDocumentElement().normalize();
			
			NodeList cellList = doc.getElementsByTagName("cells");
			
			Node cell = cellList.item(0);
			NodeList cellChield = cell.getChildNodes();
			System.out.println(cellChield.getLength());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
