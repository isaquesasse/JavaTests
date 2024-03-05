package br.com.cpassos.servicos;

import static br.com.cpassos.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.com.cpassos.entidades.Filme;
import br.com.cpassos.entidades.Locacao;
import br.com.cpassos.entidades.Usuario;
import br.com.cpassos.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception {
		
		if(filme.getEstoque() == 0) {
			throw new Exception("Filme sem estoque");
		}
		
		//Usuario obrigatorio
		if(usuario.getNome() == null || usuario.getNome().isEmpty()) {
			throw new Exception("Usuário obrigatório");
		}
		
		//Filme obrigatorio
		if(filme.getNome() == null || filme.getNome().isEmpty()) {
			throw new Exception("Nome do filme obrigatório");
		}
		
		
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	
	public static void main(String[] args) {
				

	}
}