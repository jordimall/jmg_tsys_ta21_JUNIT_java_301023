package TA21_JUNIT_ejercicioGeometria.TA21_JUNIT_ejercicioGeometria;

import model.Geometria;

public class App {
	public static void main(String[] args) {
		// Creacion de Objeto Circulo
		Geometria gm = new Geometria(2);
		double areaCirc = gm.areaCirculo(8);
		gm.setArea(areaCirc);
		System.out.println(gm.getArea());
	}

}
