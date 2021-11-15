package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "legislatura")
public class Legislatura {
	
	@Id
	@Column(name = "idLegislatura")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLegislatura;
	
	@Column(name = "uri")
	private String uri;
	
	@Column(name = "dataInicio")
	private String dataInicio;
	
	@Column(name = "dataFim")
	private String dataFim;
	
	@Column(name = "anoEleicao")
	private int anoEleicao;

	public Legislatura() {
		super();
	}

	public Legislatura(int idLegislatura, String uri, String dataInicio, String dataFim, int anoEleicao) {
		super();
		this.setIdLegislatura(idLegislatura);
		this.setUri(uri);
		this.setDataInicio(dataInicio);
		this.setDataFim(dataFim);
		this.setAnoEleicao(anoEleicao);
	}
	
	public Legislatura(String uri, String dataInicio, String dataFim, int anoEleicao) {
		super();
		this.setUri(uri);
		this.setDataInicio(dataInicio);
		this.setDataFim(dataFim);
		this.setAnoEleicao(anoEleicao);
	}

	public int getIdLegislatura() {
		return idLegislatura;
	}

	public void setIdLegislatura(int idLegislatura) {
		this.idLegislatura = idLegislatura;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public int getAnoEleicao() {
		return anoEleicao;
	}

	public void setAnoEleicao(int anoEleicao) {
		this.anoEleicao = anoEleicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoEleicao;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + idLegislatura;
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Legislatura other = (Legislatura) obj;
		if (anoEleicao != other.anoEleicao)
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (idLegislatura != other.idLegislatura)
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Legislatura [idLegislatura=" + idLegislatura + ", uri=" + uri + ", dataInicio=" + dataInicio
				+ ", dataFim=" + dataFim + ", anoEleicao=" + anoEleicao + "]";
	}

}
