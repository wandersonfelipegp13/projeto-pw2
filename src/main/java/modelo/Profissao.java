package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profissao")
public class Profissao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "uri")
	private String uri;
	
	@Column(name = "data_hora")
	private String dataHora;
	
	@Column(name = "cod_tipo_profissao")
	private int codTipoProfissao;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "id_deputado")
	private int idDeputado;
	
	public Profissao() {
		super();
	}
	
	public Profissao(int id, String uri, String dataHora, int codTipoProfissao, String titulo, int idDeputado) {
		super();
		this.setId(id);
		this.setUri(uri);
		this.setDataHora(dataHora);
		this.setCodTipoProfissao(codTipoProfissao);
		this.setTitulo(titulo);
		this.setIdDeputado(idDeputado);
	}
	
	public Profissao(String uri, String dataHora, int codTipoProfissao, String titulo, int idDeputado) {
		super();
		this.setUri(uri);
		this.setDataHora(dataHora);
		this.setCodTipoProfissao(codTipoProfissao);
		this.setTitulo(titulo);
		this.setIdDeputado(idDeputado);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public int getCodTipoProfissao() {
		return codTipoProfissao;
	}

	public void setCodTipoProfissao(int codTipoProfissao) {
		this.codTipoProfissao = codTipoProfissao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIdDeputado() {
		return idDeputado;
	}

	public void setIdDeputado(int idDeputado) {
		this.idDeputado = idDeputado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codTipoProfissao;
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + id;
		result = prime * result + idDeputado;
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
		Profissao other = (Profissao) obj;
		if (codTipoProfissao != other.codTipoProfissao)
			return false;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (id != other.id)
			return false;
		if (idDeputado != other.idDeputado)
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

	@Override
	public String toString() {
		return "Profissao [id=" + id + ", uri=" + uri + ", dataHora=" + dataHora + ", codTipoProfissao="
				+ codTipoProfissao + ", titulo=" + titulo + ", idDeputado=" + idDeputado + "]";
	}

}
