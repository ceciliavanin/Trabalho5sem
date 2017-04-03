package client;

public class BuscaSimples extends Busca<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7309477450832243738L;

	@Override
	public void buscaArquivo() {

		System.out.println("Realizando busca");
//
//		for (int i = 0; i < 20; i++) {
//			System.out.print(".");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

		super.setResultado("Arquivo encontrado!");

		System.out.println("\nExecução finalizada.");
	}

}
