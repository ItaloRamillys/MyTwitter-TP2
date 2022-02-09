import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import mytwitter.MyTwitter;
import mytwitter.PessoaFisica;
import mytwitter.PessoaJuridica;
import mytwitter.RepositorioUsuario;

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
	public void testCriarPerfil3() {
		//Test Exception
		RepositorioUsuario rep = new RepositorioUsuario();
		MyTwitter mt = new MyTwitter(rep);
		PessoaFisica pf = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf);
		PessoaFisica pf2 = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf2);

		PessoaFisica pfT = (PessoaFisica)mt.repositorio.buscar("Italo Ramillys");
	}

	@Test
	public void testCancelarPerfil() {
		RepositorioUsuario rep = new RepositorioUsuario();
		MyTwitter mt = new MyTwitter(rep);
		PessoaFisica pf = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf);
		mt.cancelarPerfil("Italo Ramillys");

		assertEquals(false, rep.buscar("Italo Ramillys").isAtivo());
	}

	@Test
	public void testCancelarPerfil2() {
		RepositorioUsuario rep = new RepositorioUsuario();
		MyTwitter mt = new MyTwitter(rep);
		PessoaFisica pf = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf);
		mt.cancelarPerfil("Italo Ramillys");

		assertNotEquals(true, rep.buscar("Italo Ramillys").isAtivo());
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
		RepositorioUsuario rep = new RepositorioUsuario();
		MyTwitter mt = new MyTwitter(rep);
		PessoaFisica pf = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf);

		PessoaJuridica pj = new PessoaJuridica("Raimundo Vieira", 92183499123l);
		mt.criarPerfil(pj);

		mt.seguir("Italo Ramillys", "Raimundo Vieira");
		
	}

	@Test
	public void testNumeroSeguidores() {
		RepositorioUsuario rep = new RepositorioUsuario();
		MyTwitter mt = new MyTwitter(rep);
		PessoaFisica pf = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf);

		PessoaJuridica pj = new PessoaJuridica("Raimundo Vieira", 92183499123l);
		mt.criarPerfil(pj);
		
		mt.seguir("Italo Ramillys","Raimundo Vieira");
		
		assertEquals(1, mt.numeroSeguidores("Raimundo Vieira"));
	}
	
	@Test
	public void testNumeroSeguidores2() {
		RepositorioUsuario rep = new RepositorioUsuario();
		MyTwitter mt = new MyTwitter(rep);
		PessoaFisica pf = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf);

		PessoaJuridica pj = new PessoaJuridica("Raimundo Vieira", 92183499123l);
		mt.criarPerfil(pj);
		
		rep.buscar("Italo Ramillys").addSeguidor("Raimundo Vieira");
		
		assertEquals(0, mt.numeroSeguidores("Raimundo Vieira"));
	}

	@Test
	public void testSeguidores() {
		RepositorioUsuario rep = new RepositorioUsuario();
		MyTwitter mt = new MyTwitter(rep);
		PessoaFisica pf = new PessoaFisica("Italo Ramillys", 92183499123l);
		mt.criarPerfil(pf);

		PessoaJuridica pj = new PessoaJuridica("Raimundo Vieira", 92183499123l);
		mt.criarPerfil(pj);
		
		rep.buscar("Italo Ramillys").addSeguidor("Raimundo Vieira");
		
		assertEquals(1, mt.seguidores("Italo Ramillys").size());
	}

}
