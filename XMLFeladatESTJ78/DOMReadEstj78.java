package hu.domparse.estj78;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import hu.domparse.estj78.DOMModifyEstj78;;

public class DOMReadEstj78 {
	private static void printNode(Node r) {
		NodeList els = r.getChildNodes();
		for (int j = 0; j < els.getLength(); j++) {
			if (els.item(j).getNodeName() != "#text") {
				Node n = els.item(j);
				System.out.println(n.getNodeName());
				if (n.hasChildNodes()) {
					for (int i = 0; i < n.getChildNodes().getLength(); i++) {
						Node s = n.getChildNodes().item(i);
						if (s.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println("\t" + s.getNodeName() + ": " + s.getTextContent());
						}
					}

				}

			}

		}
	}

	public static void main(String[] args) {
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			Document document = db.parse("webaruhaz.xml");
			// root data
			Element root = document.getDocumentElement();
			printNode(root);
			DOMModifyEstj78.modifyPrices(root);
			printNode(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
