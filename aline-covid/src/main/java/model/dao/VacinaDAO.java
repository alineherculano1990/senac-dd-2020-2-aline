package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.vo.PesquisadorVO;
import model.vo.VacinaVO;

public class VacinaDAO {

	public int cadastrarVacina(VacinaVO vacina) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "INSERT INTO `vacinas` VALUES (NULL, '"
				+ vacina.getPaisDeOrigem() +"', "
				+ vacina.getEstagioDaPesquisa() +", '"
				+ vacina.getDataInicioDaPesquisa() +"', "
				+ vacina.getPesquisador().getId() +")";

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar vacina.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public int excluirVacina(int idVacina) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "DELETE FROM `vacinas` WHERE id = " + idVacina;

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao excluir vacina");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public int alterarVacina(VacinaVO vacina, int idVacina) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "UPDATE `vacinas` SET "
				+ "PAIS = '"+vacina.getPaisDeOrigem()+"', "
				+ "ESTAGIO = "+vacina.getEstagioDaPesquisa()+", "
				+ "DATAINICIO = '"+vacina.getDataInicioDaPesquisa()+"', "
				+ "PESQUISADOR = "+vacina.getPesquisador().getId()+" WHERE ID = " + idVacina;

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao alterar vacina");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public VacinaVO encontrarVacina(int idVacina) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		VacinaVO vacina = new VacinaVO();
		PesquisadorVO pesquisador = new PesquisadorVO();
		String query = "SELECT * FROM `vacinas` WHERE ID = " + idVacina;

		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				vacina.setId(Integer.parseInt(resultado.getString("ID")));
				vacina.setPaisDeOrigem(resultado.getString("PAIS"));
				vacina.setEstagioDaPesquisa(Integer.parseInt(resultado.getString("ESTAGIO")));
				vacina.setDataInicioDaPesquisa(resultado.getString("DATAINICIO"));
				pesquisador.setId(Integer.parseInt(resultado.getString("PESQUISADOR")));
				vacina.setPesquisador(pesquisador);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar vacina");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(resultado);
		}
		return vacina;
	}

	public ArrayList<VacinaVO> listarVacinas() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		VacinaVO vacina = new VacinaVO();
		PesquisadorVO pesquisador = new PesquisadorVO();
		ArrayList<VacinaVO> listaDeVacinas = new ArrayList();
		String query = "SELECT * FROM `vacinas`";

		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {

				vacina.setId(Integer.parseInt(resultado.getString("ID")));
				vacina.setPaisDeOrigem(resultado.getString("PAIS"));
				vacina.setEstagioDaPesquisa(Integer.parseInt(resultado.getString("ESTAGIO")));
				vacina.setDataInicioDaPesquisa(resultado.getString("DATAINICIO"));
				pesquisador.setId(Integer.parseInt(resultado.getString("PESQUISADOR")));
				vacina.setPesquisador(pesquisador);

				listaDeVacinas.add(vacina);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar todas as instituições");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaDeVacinas;
	}

}
