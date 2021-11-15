package xmlhandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modelo.Legislatura;

public class LegislaturaHandler {

	private List<Legislatura> legislaturas;

	public List<Legislatura> fazerParsing(String pathArq)
			throws SAXException, IOException, ParserConfigurationException {

		legislaturas = new ArrayList<Legislatura>();

		File xmlFile = new File(pathArq);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("legislatura");

		// System.out.printf("Quantidade de Legislaturas: %d\n", nList.getLength());

		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element elem = (Element) nNode;
				Legislatura leg = new Legislatura();
				Node node;
				
				node = elem.getElementsByTagName("idLegislatura").item(0);
				int idLeg = Integer.parseInt(node.getTextContent());
				
				node = elem.getElementsByTagName("uri").item(0);
				String uri = node.getTextContent();
				
				node = elem.getElementsByTagName("dataInicio").item(0);
				String dataInicio = node.getTextContent();
				
				node = elem.getElementsByTagName("dataFim").item(0);
				String dataFim = node.getTextContent();
				
				node = elem.getElementsByTagName("anoEleicao").item(0);
				int anoEleicao = Integer.parseInt(node.getTextContent());

				leg.setIdLegislatura(idLeg);
				leg.setUri(uri);
				leg.setDataInicio(dataInicio);
				leg.setDataFim(dataFim);
				leg.setAnoEleicao(anoEleicao);
				
				legislaturas.add(leg);
				// System.out.println(leg);

			}
		}

		return legislaturas;
		
	}

}
