package common;

import java.io.Serializable;
import java.util.Date;

public class Arquivo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7523687951015011276L;
	
	private long id;
	private long tamanhoArq;
	private String path;
	private String nomeArq;
	private String extArq;
	private Date dataMod;
	private String md5;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTamanhoArq() {
		return tamanhoArq;
	}

	public void setTamanhoArq(long tamanhoArq) {
		this.tamanhoArq = tamanhoArq;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNomeArq() {
		return nomeArq;
	}

	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}

	public String getExtArq() {
		return extArq;
	}

	public void setExtArq(String extArq) {
		this.extArq = extArq;
	}

	public Date getDataMod() {
		return dataMod;
	}

	public void setDataMod(Date dataMod) {
		this.dataMod = dataMod;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataMod == null) ? 0 : dataMod.hashCode());
		result = prime * result + ((extArq == null) ? 0 : extArq.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((md5 == null) ? 0 : md5.hashCode());
		result = prime * result + ((nomeArq == null) ? 0 : nomeArq.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + (int) (tamanhoArq ^ (tamanhoArq >>> 32));
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
		Arquivo other = (Arquivo) obj;
		if (dataMod == null) {
			if (other.dataMod != null)
				return false;
		} else if (!dataMod.equals(other.dataMod))
			return false;
		if (extArq == null) {
			if (other.extArq != null)
				return false;
		} else if (!extArq.equals(other.extArq))
			return false;
		if (id != other.id)
			return false;
		if (md5 == null) {
			if (other.md5 != null)
				return false;
		} else if (!md5.equals(other.md5))
			return false;
		if (nomeArq == null) {
			if (other.nomeArq != null)
				return false;
		} else if (!nomeArq.equals(other.nomeArq))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (tamanhoArq != other.tamanhoArq)
			return false;
		return true;
	}
}