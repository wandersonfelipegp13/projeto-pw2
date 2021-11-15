package popularBD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dao.DeputadoDAO;
import modelo.Deputado;
import xmlhandler.DeputadoHandler;

public class PopularUrlRedeSocial {
	
	private List<Deputado> deps;

	private void pegaDados() {
		
		deps = new ArrayList<Deputado>();

		try {

			DeputadoHandler dom = new DeputadoHandler();

			dom.fazerParsing("src/main/java/files/deputados.xml");

			deps = dom.getDeputados();
			
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
		
		DeputadoDAO dao = new DeputadoDAO();
		
		dao.setup();
		
		for (int i = 0; i < deps.size(); i++)
			dao.create(deps.get(i));
		
		dao.exit();
	}

}
