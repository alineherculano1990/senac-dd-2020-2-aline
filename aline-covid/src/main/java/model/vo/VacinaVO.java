package model.vo;



public class VacinaVO {

	private int id;
	private String paisDeOrigem;
	private int estagioDaPesquisa;
	private String dataInicioDaPesquisa;
	private PesquisadorVO pesquisador;

	public VacinaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}
	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}
	public int getEstagioDaPesquisa() {
		return estagioDaPesquisa;
	}
	public void setEstagioDaPesquisa(int estagioDaPesquisa) {
		this.estagioDaPesquisa = estagioDaPesquisa;
	}

	public String getDataInicioDaPesquisa() {
		return dataInicioDaPesquisa;
	}

	
	public void setDataInicioDaPesquisa(String dataInicioDaPesquisa) {
		this.dataInicioDaPesquisa = dataInicioDaPesquisa;
	}

	public PesquisadorVO getPesquisador() {
		return pesquisador;
	}
	public void setPesquisador(PesquisadorVO pesquisador) {
		this.pesquisador = pesquisador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
