package popularBD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dao.OcupacaoDAO;
import modelo.Ocupacao;

import xmlhandler.OcupacaoHandler;

public class PopularOcupacao {

	private List<Ocupacao> ocupacoes;

	private void pegaDados() {

		ocupacoes = new ArrayList<Ocupacao>();

		try {

			OcupacaoHandler dom = new OcupacaoHandler();

			dom.fazerParsing("src/main/java/files/deputadosOcupacoes.xml");

			ocupacoes = dom.getOcupacoes();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			StringBuilder msg = new StringBuilder();
			msg.append("Erro no pegaDados() de PopularDeputado:\n");
			msg.append(e.getMessage() + "\n");
			msg.append(e.toString());
			System.out.println(msg);
		}

	}

	public void insereDados() {

		this.pegaDados();

		OcupacaoDAO daoOcp = new OcupacaoDAO();
		daoOcp.setup();
		for (int i = 0; i < ocupacoes.size(); i++) {
			daoOcp.create(ocupacoes.get(i));
			// System.out.println(ocupacoes.get(i).toString());
		}
		daoOcp.exit();

	}

	public static void main(String[] args) {

		PopularOcupacao o = new PopularOcupacao();
		o.insereDados();

	}

}
