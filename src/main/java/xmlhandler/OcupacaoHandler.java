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

import modelo.Deputado;
import modelo.Ocupacao;

public class OcupacaoHandler {

	private List<Ocupacao> ocupacoes;

	public void fazerParsing(String pathArq) throws SAXException, IOException, ParserConfigurationException {

		ocupacoes = new ArrayList<Ocupacao>();

		File xmlFile = new File(pathArq);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("ocupacoes");

		// System.out.printf("Quantidade de Ocupações: %d\n", nList.getLength());

		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element elem = (Element) nNode;
				Ocupacao o = new Ocupacao();
				Deputado d = new Deputado();
				Node node;

				node = elem.getElementsByTagName("id").item(0);
				int id = Integer.parseInt(node.getTextContent());
				d.setId(id);
				o.setDeputado(d);

				node = elem.getElementsByTagName("uri").item(0);
				String uri = node.getTextContent();

				node = elem.getElementsByTagName("titulo").item(0);
				String titulo = node.getTextContent();
				
				node = elem.getElementsByTagName("entidade").item(0);
				String entidade = node.getTextContent();
				
				node = elem.getElementsByTagName("entidadeUF").item(0);
				String entidadeUF = node.getTextContent();
				
				node = elem.getElementsByTagName("entidadePais").item(0);
				String entidadePais = node.getTextContent();
				
				node = elem.getElementsByTagName("anoInicio").item(0);
				String anoInicio = node.getTextContent();
				
				node = elem.getElementsByTagName("anoFim").item(0);
				String anoFim = node.getTextContent();
				
				o.setUri(uri);
				o.setTitulo(titulo);
				o.setEntidade(entidade);
				o.setEntidadeUF(entidadeUF);
				o.setEntidadePais(entidadePais);
				o.setAnoInicio(anoInicio);
				o.setAnoFim(anoFim);
				this.ocupacoes.add(o);
				// System.out.println(o);

			}
		}

	}

	public List<Ocupacao> getOcupacoes() {
		return ocupacoes;
	}
	
	public static void main(String[] args) {

		List<Ocupacao> ocupacoes = new ArrayList<Ocupacao>();

		try {

			OcupacaoHandler dom = new OcupacaoHandler();

			dom.fazerParsing("src/main/java/files/deputadosOcupacoes.xml");

			ocupacoes = dom.getOcupacoes();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			StringBuilder msg = new StringBuilder();
			msg.append("Erro :\n");
			msg.append(e.getMessage() + "\n");
			msg.append(e.toString());
			System.out.println(msg);
		}

		for (int i = 0; i < ocupacoes.size(); i++)
			System.out.println(ocupacoes.get(i).toString());

	}

}
