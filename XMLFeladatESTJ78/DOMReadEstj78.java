package hu.domparse.estj78;

import java.io.File;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import hu.domparse.estj78.DOMModifyEstj78;;

public class DOMReadEstj78 {
	private static void printNode(Node r) {
		// Node nevének kiírása
		if (r.getNodeName() != "#text") {
			System.out.println(r.getNodeName());
		}
		// Gyerekek Node listába helyezése
		NodeList children = r.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			boolean isComplex = child.getTextContent().contains("\n");
			// Attribute kiírása
			if (child.hasAttributes()) {
				NamedNodeMap attributes = child.getAttributes();
				int numAttrs = attributes.getLength();
				for (int j = 0; j < numAttrs; j++) {
					Attr attr = (Attr) attributes.item(j);
					String attrName = attr.getNodeName();
					String attrValue = attr.getNodeValue();
					System.out.println(" " + attrName + " : " + attrValue);
				}
			}
			// Név és tartalom kíírása
			if (isComplex) {
				printNode(child);
			} else {
				System.out.print(" " + child.getNodeName());
				System.out.println(": " + child.getTextContent());
			}
		}
	}

	public static void main(String[] args) {
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			Document doc = dbBuilder.parse("webaruhaz.xml");
			String filepath = "./webaruhaz.xml";
			doc.getDocumentElement().normalize();

			// Xpath
			XPath xPath = XPathFactory.newInstance().newXPath();

			Element root = doc.getDocumentElement();
			printNode(root);
			DOMModifyEstj78.modifyPrices(root);
			printNode(root);
			// Modositott xml mentese
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
