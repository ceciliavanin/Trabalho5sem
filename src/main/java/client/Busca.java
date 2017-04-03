package client;

import java.io.Serializable;

public abstract class Busca<R> implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3019144513886030654L;
	
	private R resultado;

	public R getResultado() {
		return resultado;
	}

	protected final void setResultado(R resultado) {
		this.resultado = resultado;
	}
	
	public abstract void buscaArquivo();

}
