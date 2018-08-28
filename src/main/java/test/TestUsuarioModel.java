package test;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.edu.uniopet.Reader;
import form.login.cadastro.web.model.UsuarioModel;
import form.login.cadastro.web.util.UsuarioModelException;
import form.login.cadastro.web.vo.Usuario;
import junit.framework.TestCase;

/**
 * Unit Test to the model layer to the Usuario entity.
 * 
 * @author Baracho
 * 
 * @since junho 24, 2018
 *
 * @version 1.0
 *
 */
class TestUsuarioModel extends TestCase {

	/**
	 * Instance variables
	 */

	private UsuarioModel usuarioModel;

	/**
	 * Default constructor
	 */
	public TestUsuarioModel() {
		// TODO Auto-generated constructor stub

		this.usuarioModel = new UsuarioModel();
	}

	@Test
	void test() {
	}

	@Test
	public void testUsuarioList() {

		// Variables declaration

		List<Usuario> usuarios = null;

		// Data processing

		try {

			usuarios = this.usuarioModel.list();

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		assertNotNull(usuarios);

		assertTrue(usuarios.size() > 0);
	}

	@Test
	public void testUsuarioSearch() {

		// Variables declaration

		List<Usuario> usuarios = null;

		String nome = null;

		Usuario usuario = null;

		// Data processing

		nome = "maria garcia";

		try {

			usuarios = this.usuarioModel.search(nome);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block

			usuarios = null;

			e.printStackTrace();
		}

		assertNotNull(usuarios);

		usuario = usuarios.get(0);

		assertEquals(nome.toUpperCase(), usuario.getNome());

		nome = "jo";

		try {

			usuarios = this.usuarioModel.search(nome);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(usuarios != null && usuarios.size() > 0);

		nome = "paulo";

		try {

			usuarios = this.usuarioModel.search(nome);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNull(usuarios);
	}

	@Test
	public void testSaveOrUpdate() {

		// Variables declaration

		Usuario usuario = null;

		String nome = null;

		Date dataNascimento = null;

		Character sexo = null;

		String email = null;

		Boolean status = null;

		String login = null;

		String senha = null;

		// Data processing

		nome = "karla brandão";

		try {

			dataNascimento = Reader.converterStringToDate("5/5/1985");

		} catch (Exception e) {
			// TODO Auto-generated catch block

			dataNascimento = null;

			e.printStackTrace();
		}

		sexo = new Character('f');

		email = "karla.brandao@gmail.com";

		status = new Boolean(true);

		login = "karla";

		senha = "brandao";

		usuario = new Usuario();

		usuario.setNome(nome);

		usuario.setDataNascimento(dataNascimento);

		usuario.setSexo(sexo);

		usuario.setEmail(email);

		usuario.setStatus(status);

		usuario.setLogin(login);

		usuario.setSenha(senha);

		try {

			this.usuarioModel.saveOrUpdate(usuario);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block

			usuario = null;

			e.printStackTrace();
		}

		assertNotNull(usuario);

		assertNotNull(usuario.getId());

		assertEquals(nome.toUpperCase(), usuario.getNome());

		assertEquals(dataNascimento, usuario.getDataNascimento());

		sexo = new Character(Character.toUpperCase(sexo.charValue()));

		assertEquals(sexo, usuario.getSexo());

		assertEquals(email, usuario.getEmail());

		assertEquals(status, usuario.getStatus());

		assertEquals(login, usuario.getLogin());

		assertEquals(senha, usuario.getSenha());

		if (usuario != null) {

			System.out.println("\n Usuário inserido com sucesso:" + usuario.toString());
		}

		// Update

		nome = "josé lima";

		try {

			dataNascimento = Reader.converterStringToDate("4/7/2018");

		} catch (Exception e) {
			// TODO Auto-generated catch block

			dataNascimento = null;

			e.printStackTrace();
		}

		sexo = new Character('m');

		email = "jose.lima@hotmail.com";

		status = new Boolean(false);

		login = "carlos";

		senha = "lima";

		usuario.setNome(nome);

		usuario.setDataNascimento(dataNascimento);

		usuario.setSexo(sexo);

		usuario.setEmail(email);

		usuario.setStatus(status);

		usuario.setLogin(login);

		usuario.setSenha(senha);

		try {

			this.usuarioModel.saveOrUpdate(usuario);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block

			usuario = null;

			e.printStackTrace();
		}

		assertNotNull(usuario);

		assertNotNull(usuario.getId());

		assertEquals(nome.toUpperCase(), usuario.getNome());

		assertEquals(dataNascimento, usuario.getDataNascimento());

		sexo = new Character(Character.toUpperCase(sexo.charValue()));

		assertEquals(sexo, usuario.getSexo());

		assertEquals(email, usuario.getEmail());

		assertEquals(status, usuario.getStatus());

		assertEquals(login, usuario.getLogin());

		assertEquals(senha, usuario.getSenha());

		if (usuario != null) {

			System.out.println("\n Usuário atualizado com sucesso:" + usuario.toString());
		}

		// Delete

		try {

			this.usuarioModel.delete(usuario);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		try {

			this.usuarioModel.search(usuario);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNull(usuario.getId());

		System.out.println("\n Usuário excluído com sucesso.");
	}

	@Test
	public void testAuthenticateUsuario() {

		// Variables declaration

		Usuario usuario = null;

		Integer id = null;

		String login = null;

		String senha = null;

		// Data processing

		id = new Integer(1);

		login = "maria";

		senha = "garcia";

		usuario = new Usuario();

		usuario.setId(id);

		usuario.setLogin(login);

		usuario.setSenha(senha);

		try {

			this.usuarioModel.authenticateUsuario(usuario);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(usuario);

		assertNotNull(usuario.getId());

		assertEquals(login, usuario.getLogin());

		assertEquals(senha, usuario.getSenha());
	}

	@Test
	public void testValidateteLogin() {

		// Variables declaration

		Usuario usuario = null;

		String login = null;

		// Data processing

		login = "maria";

		try {

			usuario = this.usuarioModel.validateLogin(login);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(usuario);

		assertEquals(login, usuario.getLogin());

		login = "xxxxxx";

		try {

			usuario = this.usuarioModel.validateLogin(login);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNull(usuario);
	}

	@Test
	public void testValidateLoginToUpdate() {

		// Variables declaration

		Usuario usuario = null;

		Integer id = null;

		String login = null;

		// Data processing

		id = new Integer(1);

		login = "vera";

		try {

			usuario = this.usuarioModel.validateLogin(login, id);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNull(usuario);

		login = "joanna";

		try {

			usuario = this.usuarioModel.validateLogin(login, id);

		} catch (UsuarioModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(usuario);
	}
}