package popularBD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dao.DeputadoDAO;
import dao.UrlRedeSocialDAO;
import dao.UrlWebsiteDAO;
import modelo.Deputado;
import modelo.UrlRedeSocial;
import modelo.UrlWebsite;
import xmlhandler.DeputadoHandler;

public class PopularDeputado {
	
	private List<Deputado> deps;
	private List<UrlRedeSocial> redes;
	private List<UrlWebsite> sites;

	private void pegaDados() {
		
		deps = new ArrayList<Deputado>();
		redes = new ArrayList<UrlRedeSocial>();
		sites = new ArrayList<UrlWebsite>();

		try {

			DeputadoHandler dom = new DeputadoHandler();

			dom.fazerParsing("src/main/java/files/deputados.xml");

			deps = dom.getDeputados();
			redes = dom.getRedes();
			sites = dom.getSites();
			
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
		
		DeputadoDAO daoDep = new DeputadoDAO();
		daoDep.setup();
		for (int i = 0; i < deps.size(); i++)
			daoDep.create(deps.get(i));
		daoDep.exit();
		
		UrlRedeSocialDAO daoRede = new UrlRedeSocialDAO();
		daoRede.setup();
		for (int i = 0; i < redes.size(); i++)
			daoRede.create(redes.get(i));
		daoRede.exit();
		
		UrlWebsiteDAO daoSites = new UrlWebsiteDAO();
		daoSites.setup();
		for (int i = 0; i < sites.size(); i++)
			daoSites.create(sites.get(i));
		daoSites.exit();
		
	}

}
