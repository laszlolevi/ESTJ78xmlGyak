/*import com.sun.org.apache.xerces.internal.parsers.SAXParser;*/
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*import oracle.jdbc.driver.*;*/
import org.xml.sax.*;

public class SaxSA8QM6 {
	public SaxSA8QM6() {

	}

	public static void main(String[] args) {
		SaxSA8QM6 prog = new SaxSA8QM6();
		prog.process();
	}

	public void process() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser = null;
		try {
			saxParser = spf.newSAXParser();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		XMLReader xmlr = null;
		try {
			xmlr = saxParser.getXMLReader();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		Elemzo sch = new Elemzo();
		xmlr.setContentHandler(sch);
		try {
			xmlr.parse("src/szemelyek.xml");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}

class Elemzo implements ContentHandler {
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// System.out.println(String.valueOf(start) + ":" +
		// String.valueOf(length));
		String t = new String(ch);
		String sz = t.substring(start, start + length);
		System.out.println(sz);

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName + " end");

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if (atts.getLocalName(0) != null) {
			System.out.println(qName + ", {" + atts.getLocalName(0) + ":" + atts.getValue(0) + "}" + " start");
		}

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub

	}
}