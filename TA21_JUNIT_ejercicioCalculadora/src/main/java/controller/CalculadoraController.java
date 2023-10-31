/**
 * 
 */
package controller;

import javax.swing.JOptionPane;

/**
 * 
 */
public class CalculadoraController {

	public double sumar(String valor1, String valor2) {
		double num1 = Double.parseDouble(valor1);
		double num2 = Double.parseDouble(valor2);
		double resultado = num1 + num2;
		return resultado;
	}

	public double restar(String valor1, String valor2) {
		double num1 = Double.parseDouble(valor1);
		double num2 = Double.parseDouble(valor2);
		double resultado = num1 - num2;
		return resultado;

	}

	public double multiplicar(String valor1, String valor2) {
		double num1 = Double.parseDouble(valor1);
		double num2 = Double.parseDouble(valor2);
		double resultado = num1 * num2;
		return resultado;
	}

	public double dividir(String valor1, String valor2) {
		double num1 = Double.parseDouble(valor1);
		double num2 = Double.parseDouble(valor2);
		double resultado = 0;
		if (num2 != 0) {
			resultado = num1 / num2;
		} else {
			JOptionPane.showMessageDialog(null, "Error: División por cero");
			resultado = Double.MIN_VALUE;
		}
		return resultado;
	}

	public double porcentaje(String valor1, String valor2) {
		double num1 = Double.parseDouble(valor1);
		double num2 = Double.parseDouble(valor2);

		double resultado = num1 * (num2 / 100);
		return resultado;
	}

	public String recuperarSimboloOperacion(String text) {
		String simboloOperacion = "";
		String operacionAComprobar = text;
		String simbolos = "+-*/%";

		for (int i = 0; i < simbolos.length(); i++) {
			char caracter = simbolos.charAt(i);
			if (operacionAComprobar.contains(String.valueOf(caracter))) {
				simboloOperacion = String.valueOf(caracter);
				break;
			}
		}

		return simboloOperacion;
	}

	public double operar(String valor1, String valor2, String operacion) {
		double resultado = 0;

		if (!"".equals(valor1) && !"".equals(valor2)) {
			String simbolo = recuperarSimboloOperacion(operacion);
			switch (simbolo) {
			case "+":
				resultado = sumar(valor1, valor2);
				break;
			case "-":
				resultado = restar(valor1, valor2);
				break;
			case "*":
				resultado = multiplicar(valor1, valor2);
				break;
			case "/":
				resultado = dividir(valor1, valor2);
				break;
			case "%":
				resultado = porcentaje(valor1, valor2);
				break;
			default:
				resultado = Double.MIN_VALUE;
				break;
			}
		}

		return resultado;
	}
}
