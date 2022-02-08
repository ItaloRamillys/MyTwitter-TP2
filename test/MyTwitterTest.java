package mytwitter;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTwitterTest {

	@Test
	public void testCriarPerfil() {
		RepositorioUsuario rep = new RepositorioUsuario();
		MyTwitter mt = new MyTwitter(rep);
		PessoaFisica pf = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf);
		
		PessoaFisica pfT = (PessoaFisica)mt.repositorio.buscar("Italo Ramillys");

		assertEquals(92183499123l, pfT.getCpf());
	}
	
	@Test
	public void testCriarPerfil2() {
		RepositorioUsuario rep = new RepositorioUsuario();
		MyTwitter mt = new MyTwitter(rep);
		PessoaFisica pf = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf);
		
		PessoaFisica pfT = (PessoaFisica)mt.repositorio.buscar("Italo Ramillys");

		assertNotEquals(32183499123l, pfT.getCpf());
	}

	@Test
	public void testCancelarPerfil() {
		fail("Not yet implemented");
	}

	@Test
	public void testTweetar() {
		fail("Not yet implemented");
	}

	@Test
	public void testTimeline() {
		fail("Not yet implemented");
	}

	@Test
	public void testTweets() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeguir() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumeroSeguidores() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeguidores() {
		fail("Not yet implemented");
	}

}
