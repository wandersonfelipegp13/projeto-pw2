package popularBD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dao.ProfissaoDAO;
import modelo.Profissao;
import xmlhandler.ProfissaoHandler;

public class PopularProfissao {
	
	private List<Profissao> profissoes;

	private void pegaDados() {
		
		profissoes = new ArrayList<Profissao>();

		try {

			ProfissaoHandler dom = new ProfissaoHandler();
			dom.fazerParsing("src/main/java/files/deputadosProfissoes.xml");
			profissoes = dom.getProfissoes();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			StringBuilder msg = new StringBuilder();
			msg.append("Erro:\n");
			msg.append(e.getMessage() + "\n");
			msg.append(e.toString());
			System.out.println(msg);
		}

	}
	
	public void insereDados() {
		
		this.pegaDados();
		
		ProfissaoDAO dao = new ProfissaoDAO();
		
		dao.setup();
		
		for (int i = 0; i < profissoes.size(); i++)
			dao.create(profissoes.get(i));
		
		dao.exit();
	}

}
