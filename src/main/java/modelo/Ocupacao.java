package modelo;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ocupacao")
public class Ocupacao {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Basic(optional = false)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_deputado", nullable = false)
	private Deputado deputado;

	@Column(name = "uri")
	private String uri;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "entidade")
	private String entidade;

	@Column(name = "entidade_uf")
	private String entidadeUF;

	@Column(name = "entidade_pais")
	private String entidadePais;

	@Column(name = "ano_inicio")
	private String anoInicio;

	@Column(name = "ano_fim")
	private String anoFim;

	public Ocupacao() {
		super();
	}

	public Ocupacao(Deputado deputado, String uri, String titulo, String entidade, String entidadeUF,
			String entidadePais, String anoInicio, String anoFim) {
		super();
		this.setDeputado(deputado);
		this.setUri(uri);
		this.setTitulo(titulo);
		this.setEntidade(entidade);
		this.setEntidadeUF(entidadeUF);
		this.setEntidadePais(entidadePais);
		this.setAnoInicio(anoInicio);
		this.setAnoFim(anoFim);
	}

	public Ocupacao(int id, Deputado deputado, String uri, String titulo, String entidade, String entidadeUF,
			String entidadePais, String anoInicio, String anoFim) {
		super();
		this.setId(id);
		this.setDeputado(deputado);
		this.setUri(uri);
		this.setTitulo(titulo);
		this.setEntidade(entidade);
		this.setEntidadeUF(entidadeUF);
		this.setEntidadePais(entidadePais);
		this.setAnoInicio(anoInicio);
		this.setAnoFim(anoFim);
	}

	@Override
	public String toString() {
		return "Ocupacao [id=" + id + ", deputado=" + deputado + ", uri=" + uri + ", titulo=" + titulo + ", entidade="
				+ entidade + ", entidadeUF=" + entidadeUF + ", entidadePais=" + entidadePais + ", anoInicio="
				+ anoInicio + ", anoFim=" + anoFim + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Deputado getDeputado() {
		return deputado;
	}

	public void setDeputado(Deputado deputado) {
		this.deputado = deputado;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEntidade() {
		return entidade;
	}

	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}

	public String getEntidadeUF() {
		return entidadeUF;
	}

	public void setEntidadeUF(String entidadeUF) {
		this.entidadeUF = entidadeUF;
	}

	public String getEntidadePais() {
		return entidadePais;
	}

	public void setEntidadePais(String entidadePais) {
		this.entidadePais = entidadePais;
	}

	public String getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	public String getAnoFim() {
		return anoFim;
	}

	public void setAnoFim(String anoFim) {
		this.anoFim = anoFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoFim == null) ? 0 : anoFim.hashCode());
		result = prime * result + ((anoInicio == null) ? 0 : anoInicio.hashCode());
		result = prime * result + ((deputado == null) ? 0 : deputado.hashCode());
		result = prime * result + ((entidade == null) ? 0 : entidade.hashCode());
		result = prime * result + ((entidadePais == null) ? 0 : entidadePais.hashCode());
		result = prime * result + ((entidadeUF == null) ? 0 : entidadeUF.hashCode());
		result = prime * result + id;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Ocupacao other = (Ocupacao) obj;
		if (anoFim == null) {
			if (other.anoFim != null)
				return false;
		} else if (!anoFim.equals(other.anoFim))
			return false;
		if (anoInicio == null) {
			if (other.anoInicio != null)
				return false;
		} else if (!anoInicio.equals(other.anoInicio))
			return false;
		if (deputado == null) {
			if (other.deputado != null)
				return false;
		} else if (!deputado.equals(other.deputado))
			return false;
		if (entidade == null) {
			if (other.entidade != null)
				return false;
		} else if (!entidade.equals(other.entidade))
			return false;
		if (entidadePais == null) {
			if (other.entidadePais != null)
				return false;
		} else if (!entidadePais.equals(other.entidadePais))
			return false;
		if (entidadeUF == null) {
			if (other.entidadeUF != null)
				return false;
		} else if (!entidadeUF.equals(other.entidadeUF))
			return false;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

}
