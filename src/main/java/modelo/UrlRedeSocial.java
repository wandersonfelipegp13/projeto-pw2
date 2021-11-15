package modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urlredesocial")
public class UrlRedeSocial {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id_deputado")
	@Basic(optional = false)
	private int idDeputado;
	
	@Column(name = "url")
	@Basic(optional = false)
	private String url;
	
	public UrlRedeSocial() {
		super();
	}
	
	public UrlRedeSocial(int id, int idDeputado, String url) {
		super();
		this.setId(id);
		this.setIdDeputado(idDeputado);
		this.setUrl(url);
	}
	
	public UrlRedeSocial(int idDeputado, String url) {
		super();
		this.setIdDeputado(idDeputado);
		this.setUrl(url);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDeputado() {
		return idDeputado;
	}

	public void setIdDeputado(int idDeputado) {
		this.idDeputado = idDeputado;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		url = url.replaceAll("\n", "");
		url = url.replaceAll("\t", "");
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idDeputado;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		UrlRedeSocial other = (UrlRedeSocial) obj;
		if (id != other.id)
			return false;
		if (idDeputado != other.idDeputado)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UrlRedeSocial [id=" + id + ", idDeputado=" + idDeputado + ", url=" + url + "]";
	}

}
