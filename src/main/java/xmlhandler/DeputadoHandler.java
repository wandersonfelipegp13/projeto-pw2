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
import modelo.UrlRedeSocial;
import modelo.UrlWebsite;

public class DeputadoHandler {

	private List<Deputado> deputados;
	private List<UrlRedeSocial> redes;
	private List<UrlWebsite> sites;

	public void fazerParsing(String pathArq) throws SAXException, IOException, ParserConfigurationException {

		deputados = new ArrayList<Deputado>();
		redes = new ArrayList<UrlRedeSocial>();
		sites = new ArrayList<UrlWebsite>();

		File xmlFile = new File(pathArq);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("deputado");

		// System.out.printf("Quantidade de Deputados: %d\n", nList.getLength());

		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element elem = (Element) nNode;
				Deputado d = new Deputado();
				Node node;

				node = elem.getElementsByTagName("uri").item(0);
				String uri = node.getTextContent();

				// Pegar o id
				String[] teste = uri.split("/");
				int id = Integer.parseInt(teste[teste.length - 1]);

				node = elem.getElementsByTagName("nome").item(0);
				String nome = node.getTextContent();

				node = elem.getElementsByTagName("idLegislaturaInicial").item(0);
				int idLegislaturaInicial = Integer.parseInt(node.getTextContent());

				node = elem.getElementsByTagName("idLegislaturaFinal").item(0);
				int idLegislaturaFinal = Integer.parseInt(node.getTextContent());

				node = elem.getElementsByTagName("nomeCivil").item(0);
				String nomeCivil = node.getTextContent();

				node = elem.getElementsByTagName("cpf").item(0);
				String cpf = node.getTextContent();

				node = elem.getElementsByTagName("siglaSexo").item(0);
				String siglaSexo = node.getTextContent();

				node = elem.getElementsByTagName("urlRedeSocial").item(0);
				NodeList a = node.getChildNodes();
				for (int j = 0; j < a.getLength(); j++) {

					String urlRedeSocial = a.item(j).getTextContent();

					if (urlRedeSocial != null && urlRedeSocial != "" && !urlRedeSocial.contains("\n")
							&& !urlRedeSocial.contains("\t")) {

						UrlRedeSocial rede = new UrlRedeSocial();

						rede.setIdDeputado(id);
						rede.setUrl(urlRedeSocial);

						redes.add(rede);
					}

				}

				node = elem.getElementsByTagName("urlWebsite").item(0);
				NodeList b = node.getChildNodes();
				for (int j = 0; j < b.getLength(); j++) {

					String urlWebsite = b.item(j).getTextContent();

					if (urlWebsite != null && urlWebsite != "" && !urlWebsite.contains("\n")
							&& !urlWebsite.contains("\t")) {

						UrlWebsite site = new UrlWebsite();

						site.setIdDeputado(id);
						site.setUrl(urlWebsite);

						sites.add(site);
					}

				}

				node = elem.getElementsByTagName("dataNascimento").item(0);
				String dataNascimento = node.getTextContent();

				node = elem.getElementsByTagName("dataFalecimento").item(0);
				String dataFalecimento = node.getTextContent();

				node = elem.getElementsByTagName("ufNascimento").item(0);
				String ufNascimento = node.getTextContent();

				node = elem.getElementsByTagName("municipioNascimento").item(0);
				String municipioNascimento = node.getTextContent();

				d.setId(id);
				d.setUri(uri);
				d.setNome(nome);
				d.setIdLegislaturaInicial(idLegislaturaInicial);
				d.setIdLegislaturaFinal(idLegislaturaFinal);
				d.setNomeCivil(nomeCivil);
				d.setCpf(cpf);
				d.setSiglaSexo(siglaSexo);
				d.setDataNascimento(dataNascimento);
				d.setDataFalecimento(dataFalecimento);
				d.setUfNascimento(ufNascimento);
				d.setMunicipioNascimento(municipioNascimento);

				deputados.add(d);

			}
		}

	}

	public List<UrlRedeSocial> getRedes() {
		return redes;
	}

	public List<Deputado> getDeputados() {
		return deputados;
	}

	public List<UrlWebsite> getSites() {
		return sites;
	}

}
