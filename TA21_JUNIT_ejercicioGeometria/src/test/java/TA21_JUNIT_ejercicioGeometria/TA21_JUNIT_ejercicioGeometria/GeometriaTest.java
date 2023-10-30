/**
 * 
 */
package TA21_JUNIT_ejercicioGeometria.TA21_JUNIT_ejercicioGeometria;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import model.Geometria;

/**
 * 
 */
class GeometriaTest {
	
	Geometria geo;
	
	private static Stream<Arguments> getFormatConstructorId(){
		return Stream.of(
				Arguments.of(1, "cuadrado",1),
				Arguments.of(7,"Romboide",7),
				Arguments.of(5,"Pentagono",5)
				);
	}
	
	private static Stream<Arguments> getFormatAreaCuadrado(){
		return Stream.of(
				Arguments.of(25,5,1),
				Arguments.of(4,2,1),
				Arguments.of(49,7,1)
				);
	}
	
	private static Stream<Arguments> getFormatAreaCirculo(){
		return Stream.of(
				Arguments.of(78.54,5,1),
				Arguments.of(314,10,1),
				Arguments.of(201.06,8,1)
				);
	}
	
	private static Stream<Arguments> getFormatAreaTriangulo(){
		return Stream.of(
				Arguments.of(10, 5, 4, 1),
				Arguments.of(12, 4, 6, 1),
				Arguments.of(90,30, 6, 1)
				);
	}
	
	private static Stream<Arguments> getFormatAreaRectangulo(){
		return Stream.of(
				Arguments.of(15, 5, 3, 1),
				Arguments.of(225, 25, 9, 1),
				Arguments.of(180,30, 6, 1)
				);
	}
	
	private static Stream<Arguments> getFormatAreaTrapecio(){
		return Stream.of(
				Arguments.of(42, 10, 5, 6,1),
				Arguments.of(119, 25, 9, 7, 1),
				Arguments.of(91,23, 3, 7,1)
				);
	}
	
	private static Stream<Arguments> getFormatFigura(){
		return Stream.of(
				Arguments.of("cuadrado", 1),
				Arguments.of("Circulo", 2),
				Arguments.of("Triangulo", 3),
				Arguments.of("Rectangulo", 4),
				Arguments.of("Pentagono", 5),
				Arguments.of("Rombo", 6),
				Arguments.of("Romboide", 7),
				Arguments.of("Trapecio", 8),
				Arguments.of("Default",23)
				);
	}
	
	private static Stream<Arguments> getFormatGetterID(){
		return Stream.of(
				Arguments.of(1, 1),
				Arguments.of(7, 7),
				Arguments.of(5, 5)
				);
	}
	
	private static Stream<Arguments> getFormatSetterID(){
		return Stream.of(
				Arguments.of(1, 1),
				Arguments.of(7, 7),
				Arguments.of(5, 5)
				);
	}
	
	private static Stream<Arguments> getFormatGetterNombre(){
		return Stream.of(
				Arguments.of("cuadrado", 1),
				Arguments.of("Romboide", 7),
				Arguments.of("Pentagono", 5)
				);
	}
	
	private static Stream<Arguments> getFormatSetterNombre(){
		return Stream.of(
				Arguments.of("cuadrado", "cuadrado"),
				Arguments.of("Triangulo Hequilatero", "Triangulo Hequilatero"),
				Arguments.of("Tetaedreo", "Tetaedreo")
				);
	}
	
	private static Stream<Arguments> getFormatToString(){
		return Stream.of(
				Arguments.of("Geometria [id=1, nom=cuadrado, area=25.0]", 1, 5),
				Arguments.of("Geometria [id=5, nom=Pentagono, area=4.0]", 5, 2),
				Arguments.of("Geometria [id=7, nom=Romboide, area=49.0]", 7, 7)
				);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		geo = new Geometria();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		geo = null;
	}

	/**
	 * Test method for {@link model.Geometria#Geometria(int)}.
	 */
	@ParameterizedTest
	 @MethodSource("getFormatConstructorId")
	void testGeometriaInt(int perspectID, String perspectName, int id) {
		Geometria geo2 = new Geometria(id);
		assertEquals(perspectID, geo2.getId());
		assertEquals(perspectName, geo2.getNom());
	}

	/**
	 * Test method for {@link model.Geometria#Geometria()}.
	 */
	@Test
	void testGeometria() {
		Geometria geo2 = new Geometria();
		assertEquals(9, geo2.getId());
		assertEquals("Default", geo2.getNom());
	}

	/**
	 * Test method for {@link model.Geometria#areacuadrado(int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaCuadrado")
	void testAreaCuadrado(int perspect, int num, int delta) {
		double resultado = geo.areaCuadrado(num);
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for {@link model.Geometria#areaCirculo(int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaCirculo")
	void testAreaCirculo(double perspect, int num, int delta) {
		 double resultado = geo.areaCirculo(num);
			assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for {@link model.Geometria#areatriangulo(int, int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaTriangulo")
	void testAreatriangulo(int perspect, int valor1, int valor2,int delta) {
		 double resultado = geo.areatriangulo(valor1, valor2);
			assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for {@link model.Geometria#arearectangulo(int, int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaRectangulo")
	void testArearectangulo(int perspect, int valor1, int valor2,int delta) {
		 double resultado = geo.arearectangulo(valor1, valor2);
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for {@link model.Geometria#areapentagono(int, int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaTriangulo")
	void testAreapentagono(int perspect, int valor1, int valor2,int delta) {	 
		 double resultado = geo.areapentagono(valor1, valor2);
			assertEquals(perspect, resultado, 10);
	}

	/**
	 * Test method for {@link model.Geometria#arearombo(int, int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaTriangulo")
	void testArearombo(int perspect, int valor1, int valor2,int delta) {
		 double resultado = geo.arearombo(valor1, valor2);
			assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for {@link model.Geometria#arearomboide(int, int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaRectangulo")
	void testArearomboide(int perspect, int valor1, int valor2,int delta) {
		 double resultado = geo.arearomboide(valor1, valor2);
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for {@link model.Geometria#areatrapecio(int, int, int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaTrapecio")
	void testAreatrapecio(int perspect, int valor1, int valor2, int valor3,int delta) {
		 double resultado = geo.areatrapecio(valor1, valor2, valor3);
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for {@link model.Geometria#figura(int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatFigura")
	void testFigura(String perspect, int valor) {
		 String resultado = geo.figura(valor);
		assertEquals(perspect, resultado);
	}

	/**
	 * Test method for {@link model.Geometria#getId()}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatGetterID")
	void testGetId(int perspect,int id) {
		Geometria geo2 = new Geometria(id);
		int result = geo2.getId();
		assertEquals(perspect, result);
	}

	/**
	 * Test method for {@link model.Geometria#setId(int)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatSetterID")
	void testSetId(int perspect,int id) {
		 Geometria geo2 = new Geometria();
		 geo2.setId(id);
			int result = geo2.getId();
			assertEquals(perspect, result);
	}

	/**
	 * Test method for {@link model.Geometria#getNom()}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatGetterNombre")
	void testGetNom(String persepct, int id) {
		 Geometria geo2 = new Geometria(id);
			String result = geo2.getNom();
			assertEquals(persepct, result);
	}

	/**
	 * Test method for {@link model.Geometria#setNom(java.lang.String)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatSetterNombre")
	void testSetNom(String persepct, String newName) {
		 Geometria geo2 = new Geometria();
		 geo2.setNom(newName);
			String result = geo2.getNom();
			assertEquals(persepct, result);
	}

	/**
	 * Test method for {@link model.Geometria#getArea()}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaCuadrado")
	void testGetArea(int perspect, int num, int delta) {
		 geo.setArea(geo.areaCuadrado(num));
		double resultado = geo.getArea();
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for {@link model.Geometria#setArea(double)}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatAreaCuadrado")
	void testSetArea(int perspect, int num, int delta) {
		 geo.setArea(geo.areaCuadrado(num));
		double resultado = geo.getArea();
		assertEquals(perspect, resultado, delta);
	}

	/**
	 * Test method for {@link model.Geometria#toString()}.
	 */
	 @ParameterizedTest
	 @MethodSource("getFormatToString")
	void testToString(String perspect, int id, int num) {
		Geometria gao2 = new Geometria(id);
		gao2.setArea(gao2.areaCuadrado(num));
		String resultado = gao2.toString();
		assertEquals(perspect, resultado);
	}

}
