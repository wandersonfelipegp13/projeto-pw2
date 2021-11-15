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

import modelo.Profissao;

public class ProfissaoHandler {

	private List<Profissao> profissoes;

	public void fazerParsing(String pathArq) throws SAXException, IOException, ParserConfigurationException {

		profissoes = new ArrayList<Profissao>();

		File xmlFile = new File(pathArq);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("profissao");

		// System.out.printf("Quantidade de Profissoes: %d\n", nList.getLength());

		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element elem = (Element) nNode;
				Profissao p = new Profissao();
				Node node;

				node = elem.getElementsByTagName("uri").item(0);
				String uri = node.getTextContent();	
				
				node = elem.getElementsByTagName("id").item(0);
				int id = Integer.parseInt(node.getTextContent());
				
				node = elem.getElementsByTagName("dataHora").item(0);
				String dataHora = node.getTextContent();	
				
				node = elem.getElementsByTagName("codTipoProfissao").item(0);
				int codTipoProfissao = Integer.parseInt(node.getTextContent());	

				node = elem.getElementsByTagName("titulo").item(0);
				String titulo = node.getTextContent();
				
				p.setUri(uri);
				p.setIdDeputado(id);
				p.setDataHora(dataHora);
				p.setCodTipoProfissao(codTipoProfissao);
				p.setTitulo(titulo);
				
				profissoes.add(p);

			}
		}

	}

	public List<Profissao> getProfissoes() {
		return profissoes;
	}

}
