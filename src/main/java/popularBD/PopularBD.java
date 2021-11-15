package popularBD;

public class PopularBD {

	public static void main(String[] args) {
		
		PopularLegislatura l = new PopularLegislatura();
		l.insereDados();
		
		PopularDeputado d = new PopularDeputado();
		d.insereDados();
				
		PopularOcupacao o = new PopularOcupacao();
		o.insereDados();
		
		PopularProfissao p = new PopularProfissao();
		p.insereDados();

	}

}
