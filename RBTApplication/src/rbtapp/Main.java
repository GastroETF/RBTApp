package rbtapp;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
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
			
			NodeList startPointList = doc.getElementsByTagName("start-point");
			Node startPoint = startPointList.item(0);
			NamedNodeMap startPoingMap = startPoint.getAttributes();
			String startPointRow = startPoingMap.getNamedItem("row").getTextContent();
			String startPointCol = startPoingMap.getNamedItem("col").getTextContent();
			
			NodeList endPointList = doc.getElementsByTagName("end-point");
			Node endPoint = endPointList.item(0);
			NamedNodeMap endPoingMap = endPoint.getAttributes();
			String endPointRow = endPoingMap.getNamedItem("row").getTextContent();
			String endPointCol = endPoingMap.getNamedItem("col").getTextContent();
			
			NodeList cellList = doc.getElementsByTagName("cell");
			
			for(int i = 0; i < cellList.getLength();i++) {
				Node cell = cellList.item(i);
				NamedNodeMap cellMap = cell.getAttributes();
				Node cellRow = cellMap.getNamedItem("row");
				Node cellCol = cellMap.getNamedItem("col");
				
				System.out.println(cellRow.getTextContent() + " " + cellCol.getTextContent());
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
