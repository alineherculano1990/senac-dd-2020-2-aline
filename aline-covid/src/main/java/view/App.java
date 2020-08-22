package view;

import java.util.ArrayList;

import model.dao.InstituicaoDAO;
import model.dao.UsuarioDAO;
import model.dao.VacinaDAO;
import model.vo.EnderecoVO;
import model.vo.InstituicaoVO;
import model.vo.PesquisadorVO;
import model.vo.VacinaVO;

public class App {

	public static void main(String[] args) {

		/*Exemplo para cadastrar instituição */
		EnderecoVO endereco = new EnderecoVO();
		endereco.setRua("Avenida Gaspar Dutra");
		endereco.setNumero("43");
		endereco.setBairro("Estreito");
		endereco.setCidade("Florianópolis");
		endereco.setEstado("SC");

		InstituicaoVO instituicao = new InstituicaoVO();
		instituicao.setNome("Laboratório La Roche");
		instituicao.setCnpj("99999999/99");
		instituicao.setEndereco(endereco);

		/* Cadastro de vacinas */
		PesquisadorVO pesquisador = new PesquisadorVO();
		pesquisador.setId(1);

		VacinaVO vacina = new VacinaVO();
		vacina.setPaisDeOrigem("Reino Unido");
		vacina.setEstagioDaPesquisa(1);
		vacina.setDataInicioDaPesquisa("2020-08-22");
		vacina.setPesquisador(pesquisador);

		/* cadastrando usuário para testes */
		PesquisadorVO usuario = new PesquisadorVO();
		usuario.setNome("Jânio Pontes de Oliveira");
		usuario.setDataNascimento("1977-04-30");
		usuario.setSexo(1);
		usuario.setCpf("00096509654");
		usuario.setTipo(1);
		usuario.setFoiVacinada(false);
		usuario.setReacaoAVacina(3);
		EnderecoVO enderecoUsuario = new EnderecoVO();
		enderecoUsuario.setRua("Rua das Fontes");
		enderecoUsuario.setNumero("33A");
		enderecoUsuario.setBairro("Barreiros");
		enderecoUsuario.setCidade("São José");
		enderecoUsuario.setEstado("SC");
		usuario.setEndereco(enderecoUsuario);

		/*Criando as entidades para testes*/
		InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		VacinaDAO vacinaDAO = new VacinaDAO();

		/* ====== CRUD INSTITUIÇÃO ======*/
		/* cadastra instituição */
		//instituicaoDAO.cadastrarInstituicao(instituicao);

		/* altera instituição passando um objeto instituição e o ID dela no banco de dados */
	    //instituicaoDAO.alterarInstituicao(instituicao, 1);

		/* retorna um objeto instituição passando o ID como parâmetro */
		//InstituicaoVO i = instituicaoDAO.encontrarInstituicao(1); 
		//System.out.println(i.getNome());

		/* retorna um arraylist de instituições com todas as instituições cadastradas no banco */
		//ArrayList<InstituicaoVO> lista = instituicaoDAO.listarInstituicoes();
		//for (int c = 0; c < lista.size(); c++) {
		//System.out.println(lista.get(c).getNome());
		//}

		/* exclui uma instituição passando o ID dela no banco como parâmetro */
		//instituicaoDAO.excluirInstituicao(2);

		/* ====== CRUD USUÁRIOS ======*/
		/* cadastra usuário */
		//usuarioDAO.cadastrarUsuario(usuario);

		/* exclui um usuário pelo ID */
		//usuarioDAO.excluirUsuario(1);

		/* alterar usuário pelo ID */
		//usuarioDAO.alterarUsuario(usuario, 2);

		/* encontrar usuário pelo ID */
		//usuarioDAO.encontrarUsuario(2);

		/* listar todos os usuários */
		//usuarioDAO.listarUsuarios();

		/* ====== CRUD VACINAS ======*/
		/* cadastrar vacina */
		//vacinaDAO.cadastrarVacina(vacina);

		/* excluir vacina pelo ID */
		//vacinaDAO.excluirVacina(2);

		/* alterar vacina através do ID */
		//vacinaDAO.alterarVacina(vacina, 1);

		/* encontrarvacina através do IF */
		//vacinaDAO.encontrarVacina(1);

		/* lista todas as vacinas */
		//vacinaDAO.listarVacinas();

	}

}
