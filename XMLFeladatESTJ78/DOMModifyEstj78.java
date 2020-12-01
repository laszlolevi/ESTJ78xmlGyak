package hu.domparse.estj78;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyEstj78 {
	public static void modifyPrices(Node root) {
		try {
			System.out.println(root.getNodeType());
			NodeList els = root.getChildNodes();
			for (int j = 0; j < els.getLength(); j++) {
				if (els.item(j).getNodeName() == "novenyek") {
					for (int i = 0; i < els.item(j).getChildNodes().getLength(); i++) {
						if (els.item(j).getChildNodes().item(i).getNodeName() == "noveny") {
							for (int k = 0; k < els.item(j).getChildNodes().item(i).getChildNodes().getLength(); k++) {
								if (els.item(j).getChildNodes().item(i).getChildNodes().item(k).getNodeName() == "ar") {
									int ar = Integer.parseInt(els.item(j).getChildNodes().item(i).getChildNodes()
											.item(k).getTextContent());
									els.item(j).getChildNodes().item(i).getChildNodes().item(k)
											.setTextContent(String.valueOf(ar + 200));
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
