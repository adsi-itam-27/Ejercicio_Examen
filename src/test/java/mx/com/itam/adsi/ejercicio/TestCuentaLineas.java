package mx.com.itam.adsi.ejercicio;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test; 

public class TestCuentaLineas{
	public CuentaLineas c = new CuentaLineas();
	public String path = System.getProperty("user.dir");

	public boolean testCuenta(String file, int lineas, int comentarios, int codigo){
		boolean res = false;
		c.clear();
		c.cuenta(file);
		// System.out.println(file);
		// System.out.println("Lineas: "+c.lineas);
		// System.out.println("Comentarios: "+c.comentarios);
		// System.out.println("Codigo: "+c.codigo);
		// System.out.println();
		res = (c.lineas == lineas) && (c.comentarios == comentarios) &&
			  (c.codigo == codigo);

	    return res;

	}

	@Test
	public void archivo1(){

		assertTrue("Archivo 1", testCuenta(path+"/Archivo01.java", 6, 0, 6));
	}

	@Test
	public void archivo2(){

		assertTrue("Archivo 2", testCuenta(path+"/Archivo02.java", 7, 2, 6));
	}
	@Test
	public void archivo3(){

		assertTrue("Archivo 3", testCuenta(path+"/Archivo03.java", 12, 7, 6));
	}
	@Test
	public void archivo4(){

		assertTrue("Archivo 4", testCuenta(path+"/Archivo04.java", 13, 8, 6));
	}
	@Test
	public void archivo5(){

		assertTrue("Archivo 5", testCuenta(path+"/Archivo05.java", 11, 6, 6));
	}
}
