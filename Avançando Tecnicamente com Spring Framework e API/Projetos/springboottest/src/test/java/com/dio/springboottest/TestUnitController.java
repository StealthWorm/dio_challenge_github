package com.dio.springboottest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dio.springboottest.controller.TestController;

public class TestUnitController {
	
	@Test
	public void testUnit() {
		TestController controller = new TestController();
		String resultado = controller.saudacao("DIO");
		assertEquals("Bem-vindo, DIO", resultado);
	}
	
/*	@Test
	public void testUnitNotNull() {
		TestController controller = new TestController();
		String resultado = controller.saudacao("");
		assertEquals("Bem-vindo, DIO", resultado);
	}
*/
}
