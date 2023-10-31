/**
 * 
 */
package TA21_JUNIT_ejercicioCalculadora.TA21_JUNIT_ejercicioCalculadora;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import controller.CalculadoraController;

/**
 * 
 */
class CalculadoraControllerTest {

	CalculadoraController calc;

	private static Stream<Arguments> getFormatSumar() {
		return Stream.of(
				Arguments.of(10.95, "4.2", "6.75", 1),
				Arguments.of(16.03, "12.89", "3.14", 1),
				Arguments.of(20, "10", "10", 1));
	}

	private static Stream<Arguments> getFormatRestar() {
		return Stream.of(
				Arguments.of(6.75, "10.5", "3.75", 1), 
				Arguments.of(8.57, "15.8", "7.23", 1),
				Arguments.of(10.52, "20.12", "9.6", 1));
	}

	private static Stream<Arguments> getFormatMultiplicar() {
		return Stream.of(
				Arguments.of(8.4, "3.5", "2.4", 1), 
				Arguments.of(28.35, "6.75", "4.2", 1),
				Arguments.of(12.0, "1.25", "9.6", 1));
	}

	private static Stream<Arguments> getFormatDividir() {
		return Stream.of(
				Arguments.of(4.0, "8.4", "2.1", 1), 
				Arguments.of(4.5, "15.75", "3.5", 1),
				Arguments.of(Double.MIN_VALUE, "10.8", "0", 1));
	}

	private static Stream<Arguments> getFormatPorcentaje() {
		return Stream.of(
				Arguments.of(5.0, "10", "50", 1), 
				Arguments.of(7.5, "30", "25", 1),
				Arguments.of(20.0, "100", "20", 1));
	}
	
	private static Stream<Arguments> getFormatRecuperarSimbolo() {
		return Stream.of(
				Arguments.of("/","45875/63254"), 
				Arguments.of("*", "1256.1254*23658"),
				Arguments.of("+","25+25"));
	}

	private static Stream<Arguments> getFormatOperar() {
		return Stream.of(
				Arguments.of(10.95,"4.2", "6.75", "4.2+6.75", 1), 
				Arguments.of(6.75, "10.5", "3.75", "10.5-3.75",1),
				Arguments.of(28.35, "6.75", "4.2", "6.75*4.2", 1),
				Arguments.of(Double.MIN_VALUE, "10.8", "0", "10.8/0",1),
				Arguments.of(20.0, "100", "20", "100%20",1),
				Arguments.of(Double.MIN_VALUE, "23", "5", "Hello", 1));
	}
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		calc = new CalculadoraController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		calc = null;
	}

	/**
	 * Test method for
	 * {@link controller.CalculadoraController#sumar(java.lang.String, java.lang.String)}.
	 */
	@ParameterizedTest
	@MethodSource("getFormatSumar")
	void testSumar(double perspect, String valor1, String valor2, int delta) {
		double resultado = calc.sumar(valor1, valor2);
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for
	 * {@link controller.CalculadoraController#restar(java.lang.String, java.lang.String)}.
	 */
	@ParameterizedTest
	@MethodSource("getFormatRestar")
	void testRestar(double perspect, String valor1, String valor2, int delta) {
		double resultado = calc.restar(valor1, valor2);
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for
	 * {@link controller.CalculadoraController#multiplicar(java.lang.String, java.lang.String)}.
	 */
	@ParameterizedTest
	@MethodSource("getFormatMultiplicar")
	void testMultiplicar(double perspect, String valor1, String valor2, int delta) {
		double resultado = calc.multiplicar(valor1, valor2);
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for
	 * {@link controller.CalculadoraController#dividir(java.lang.String, java.lang.String)}.
	 */
	@ParameterizedTest
	@MethodSource("getFormatDividir")
	void testDividir(double perspect, String valor1, String valor2, int delta) {
		double resultado = calc.dividir(valor1, valor2);
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for
	 * {@link controller.CalculadoraController#porcentaje(java.lang.String, java.lang.String)}.
	 */
	@ParameterizedTest
	@MethodSource("getFormatPorcentaje")
	void testPorcentaje(double perspect, String valor1, String valor2, int delta) {
		double resultado = calc.porcentaje(valor1, valor2);
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for
	 * {@link controller.CalculadoraController#recuperarSimboloOperación(java.lang.String)}.
	 */
	@ParameterizedTest
	@MethodSource("getFormatRecuperarSimbolo")
	void testRecuperarSimboloOperación(String perspect,String text) {
		String resultado = calc.recuperarSimboloOperacion(text);
		assertEquals(perspect, resultado);
	}
	
	/**
	 * Test method for
	 * {@link controller.CalculadoraController#operar(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@ParameterizedTest
	@MethodSource("getFormatOperar")
	void testOperar(double perspect,String valor1,String valor2, String operacion, int delta) {
		double resultado = calc.operar(valor1, valor2, operacion);
		assertEquals(perspect, resultado, delta);
	}

}
