package br.com.cpassos.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.com.cpassos.entidades.Usuario;

public class AssertTest {
	
	@Test
	public void testAssert() {
		
		//Assert True
		Assert.assertTrue("Falha: ",true);
		//Assert.assertTrue(false);
		Assert.assertTrue(!false);
		Assert.assertFalse(false);
		
		//Assert Equals
		//Double, Float utilizar delta
		Assert.assertEquals(1, 1);
		// Assert.assertEquals(1, 2); //Falha
		//Assert.assertEquals(0.51, 0.51);
		Assert.assertEquals(0.51, 0.51,0.01);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		//Comparando Strings
		Assert.assertEquals("bola","bola");
		//Assert.assertEquals("bola","Bola"); //Case Sensitive
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		//Comparando objetos
		//Necessita implementar equals() na classe [objeto]
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		
		Assert.assertNotEquals(u1,u2);
		
		
		//Comparando objetos da mesma instancia [Same]
		//Assert.assertSame(u1, u2);
		Usuario u3 = u2;
		Assert.assertSame(u2, u3);
		
		//Verificar se o usuario u3 é nulo
		//Assert.assertTrue(u3 == null);
		//Assert.assertNull(u3);
		
		
		//Assertivas negativas
		Assert.assertNotEquals(u1,u2);
		//Assert.assertNotNull(u3);
		Assert.assertNotSame(u2, u3);
		
	}
}
