package popularBD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dao.LegislaturaDAO;
import modelo.Legislatura;
import xmlhandler.LegislaturaHandler;

public class PopularLegislatura {
	
	private List<Legislatura> legs;

	private void pegaDados() {
		
		legs = new ArrayList<Legislatura>();

		try {

			LegislaturaHandler dom = new LegislaturaHandler();

			legs = dom.fazerParsing("src/main/java/files/legislaturas.xml");

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
		
		LegislaturaDAO dao = new LegislaturaDAO();
		
		dao.setup();
		
		for (int i = 0; i < legs.size(); i++)
			dao.create(legs.get(i));
		
		dao.exit();
	}

}
