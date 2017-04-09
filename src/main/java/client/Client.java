package client;

import java.io.Serializable;

public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4462502260206522050L;
	
	private long idCli;
	private String nomeCli;
	private String ipCli;
	private int portaCli;

	public long getIdCli() {
		return idCli;
	}

	public void setIdCli(long idCli) {
		this.idCli = idCli;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	public String getIpCli() {
		return ipCli;
	}

	public void setIpCli(String ipCli) {
		this.ipCli = ipCli;
	}

	public int getPortaCli() {
		return portaCli;
	}

	public void setPortaCli(int portaCli) {
		this.portaCli = portaCli;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCli ^ (idCli >>> 32));
		result = prime * result + ((ipCli == null) ? 0 : ipCli.hashCode());
		result = prime * result + ((nomeCli == null) ? 0 : nomeCli.hashCode());
		result = prime * result + portaCli;
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
		Client other = (Client) obj;
		if (idCli != other.idCli)
			return false;
		if (ipCli == null) {
			if (other.ipCli != null)
				return false;
		} else if (!ipCli.equals(other.ipCli))
			return false;
		if (nomeCli == null) {
			if (other.nomeCli != null)
				return false;
		} else if (!nomeCli.equals(other.nomeCli))
			return false;
		if (portaCli != other.portaCli)
			return false;
		return true;
	}

}
