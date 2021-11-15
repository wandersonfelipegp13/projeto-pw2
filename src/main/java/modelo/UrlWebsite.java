package modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urlwebsite")
public class UrlWebsite {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "url")
	@Basic(optional = false)
	private String url;

	@Column(name = "id_deputado")
	@Basic(optional = false)
	private int idDeputado;

	public UrlWebsite() {
		super();
	}

	public UrlWebsite(String url, int idDeputado) {
		super();
		this.setUrl(url);
		this.setIdDeputado(idDeputado);
	}

	public UrlWebsite(int id, String url, int idDeputado) {
		super();
		this.setId(id);
		this.setUrl(url);
		this.setIdDeputado(idDeputado);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		UrlWebsite other = (UrlWebsite) obj;
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
		return "UrlWebsite [id=" + id + ", url=" + url + ", idDeputado=" + idDeputado + "]";
	}

}
