package br.com.cpassos.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.security.Provider.Service;
import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import br.com.cpassos.entidades.Filme;
import br.com.cpassos.entidades.Locacao;
import br.com.cpassos.entidades.Usuario;
import br.com.cpassos.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocacaoServiceTest {
	
	private static int cont;

	private static LocacaoService service;
	
	//ErrorCollector	
	@Rule
	public ErrorCollector error = new ErrorCollector();
		
	/* @Test 
	public void testExample() {
				
		//Preparacao
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 1, 5.0);
		LocacaoService service = new LocacaoService();

		//Acao
		try {
			service.alugarFilme(usuario, filme);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}*/
	
	@Before
	public void beforeMethod() {
		System.out.println("Before");
		service = new LocacaoService();
	}
	
	@BeforeClass
	public static void beforeClassMethod() {
		System.out.println("Before Class");
		//Contador
		service = new LocacaoService();
		cont++;
		System.out.println(cont);
	}
	
	@After
	public void afterMethod() {
		System.out.println("After");
		//Contador
		service = new LocacaoService();
		cont++;
		System.out.println(cont);
	}
		
	@AfterClass
	public static void afterClassMethod() {
		System.out.println("After Class");
		//Contador
		service = new LocacaoService();
		cont++;
		System.out.println(cont);
	}
	
	
	@Test
	public void filmeSemEstoque() throws Exception{
				
		//Preparacao
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 1, 5.0);
		
		//Acao
		Locacao locacao = service.alugarFilme(usuario, filme);	
		//Verificacao
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(locacao.getFilme().getNome(), is(equalTo("Filme 1")));
		error.checkThat(locacao.getUsuario().getNome(), is(equalTo("Usuario 1")));
	}
	
	@Test
	public void usuarioObrigatorio() throws Exception{
				
		//Preparacao
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 1, 5.0);
		
		//Acao
		service.alugarFilme(usuario, filme);
	}
	
	@Test
	public void nomeFilmeObrigatorio() throws Exception{
				
		//Preparacao
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 1, 5.0);
		
		//Acao
		service.alugarFilme(usuario, filme);
	}
}