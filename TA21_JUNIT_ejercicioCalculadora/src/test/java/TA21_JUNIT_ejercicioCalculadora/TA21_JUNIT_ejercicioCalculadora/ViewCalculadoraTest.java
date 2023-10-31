package TA21_JUNIT_ejercicioCalculadora.TA21_JUNIT_ejercicioCalculadora;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import view.ViewCalculadora;

class ViewCalculadoraTest {
	
	ViewCalculadora frame;
	
	private static Stream<Arguments> getFormatBorrarUnCaracter() {
		return Stream.of(
				Arguments.of("6.7", "6.75"),
				Arguments.of("3.1", "3.14"),
				Arguments.of("1", "10"));
	}
	
	private static Stream<Arguments> getFormatPositivoNegativo() {
		return Stream.of(
				Arguments.of("-6.75", "6.75"),
				Arguments.of("3.14", "-3.14"),
				Arguments.of("-10.0", "10.0"));
	}
	
	private static Stream<Arguments> getFormatComprobarComa() {
		return Stream.of(
				Arguments.of(",", ","),
				Arguments.of("10.", "10"),
				Arguments.of("10.", "10."));
	}
	
	@BeforeEach
	void setUp() throws Exception {
		frame = new ViewCalculadora();
	}

	@AfterEach
	void tearDown() throws Exception {
		frame = null;
	}

	@Test
	void testViewCalculadora() {
		ViewCalculadora view = new ViewCalculadora();
		int heig = view.getHeight();
		int perspect = 400;
		assertEquals(perspect, heig);
	}

	
	@ParameterizedTest
	@MethodSource("getFormatBorrarUnCaracter")
	void testBorrarUnCaracter(String perspect, String text) {
		String result = frame.borrarUnCaracter(text);
		assertEquals(perspect, result);
	}

	@ParameterizedTest
	@MethodSource("getFormatPositivoNegativo")
	void testInvertirPositivoNegativo(String perspect, String text) {
		String result = frame.invertirPositivoNegativo(text);
		assertEquals(perspect, result);
	}

	@ParameterizedTest
	@MethodSource("getFormatComprobarComa")
	void testComprobarComa(String perspect, String text) {
		String result = frame.comprobarComa(text);
		assertEquals(perspect, result);
	}

}
