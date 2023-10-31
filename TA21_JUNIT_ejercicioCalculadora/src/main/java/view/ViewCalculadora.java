package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.CalculadoraController;

public class ViewCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldValor1;
	private JTextField textFieldValor2;
	private JTextField resultField;
	private JLabel lblOperacion;
	private JLabel lblIgual;
	private JLabel lblInfo1;
	private JLabel lblHistorico;
	private JButton btnIgual;
	private JButton btnSumar;
	private JButton btnPositivoNegativo;
	private JButton btnComa;
	private JButton btnResta;
	private JButton btnDivision;
	private JButton btnReset;
	private JButton btnBorrarUno;
	private JButton btnMultiplicacion;
	private JButton btnPorcentaje;
	CalculadoraController calc = new CalculadoraController();

	/**
	 * Create the frame.
	 */
	public ViewCalculadora() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* LABEL */

		lblOperacion = new JLabel("");
		lblOperacion.setBounds(85, 70, 46, 14);
		lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblOperacion);

		lblInfo1 = new JLabel("");
		lblInfo1.setBounds(105, 36, 161, 20);
		lblInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInfo1);

		lblHistorico = new JLabel("");
		lblHistorico.setBounds(249, 123, 161, 210);
		lblHistorico.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHistorico);

		lblIgual = new JLabel("=");
		lblIgual.setBounds(206, 70, 46, 14);
		lblIgual.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIgual);

		/* BUTTON */

		JButton[] buttons = new JButton[10];
		int buttonWidth = 50;
		int buttonHeight = 50;
		int initialX = 10;
		int initialY = 250;
		int modificador = 50;

		for (int i = 0; i < 10; i++) {
			buttons[i] = new JButton(Integer.toString(i));

			if (i == 0) {
				buttons[i].setBounds(initialX + modificador, initialY + modificador, buttonWidth, buttonHeight);
				buttons[i].addActionListener(añadirValores);
			} else if (i <= 3) {
				buttons[i].setBounds(initialX + (modificador * (i - 1)), initialY, buttonWidth, buttonHeight);
				buttons[i].addActionListener(añadirValores);
			} else if (i <= 6 && i > 3) {
				buttons[i].setBounds(initialX + (modificador * (i - 4)), initialY - modificador, buttonWidth,
						buttonHeight);
				buttons[i].addActionListener(añadirValores);
			} else {
				buttons[i].setBounds(initialX + (modificador * (i - 7)), initialY - (modificador * 2), buttonWidth,
						buttonHeight);
				buttons[i].addActionListener(añadirValores);
			}
			contentPane.add(buttons[i]);
		}

		btnIgual = new JButton("=");
		btnIgual.setBounds(160, 300, 50, 50);
		btnIgual.addActionListener(calcular);
		contentPane.add(btnIgual);

		btnSumar = new JButton("+");
		btnSumar.setBounds(160, 250, 50, 50);
		btnSumar.addActionListener(añadirOperacion);
		contentPane.add(btnSumar);

		btnResta = new JButton("-");
		btnResta.setBounds(160, 200, 50, 50);
		btnResta.addActionListener(añadirOperacion);
		contentPane.add(btnResta);

		btnDivision = new JButton("/");
		btnDivision.setBounds(160, 100, 50, 50);
		btnDivision.addActionListener(añadirOperacion);
		contentPane.add(btnDivision);

		btnMultiplicacion = new JButton("*");
		btnMultiplicacion.setBounds(160, 150, 50, 50);
		btnMultiplicacion.addActionListener(añadirOperacion);
		contentPane.add(btnMultiplicacion);

		btnPorcentaje = new JButton("%");
		btnPorcentaje.setBounds(110, 100, 50, 50);
		btnPorcentaje.addActionListener(añadirOperacion);
		contentPane.add(btnPorcentaje);

		btnPositivoNegativo = new JButton("+/-");
		btnPositivoNegativo.setBounds(10, 300, 50, 50);
		btnPositivoNegativo.addActionListener(positivoNegativo);
		contentPane.add(btnPositivoNegativo);

		btnComa = new JButton(",");
		btnComa.setBounds(110, 300, 50, 50);
		btnComa.addActionListener(añadirComa);
		contentPane.add(btnComa);

		btnReset = new JButton("C");
		btnReset.setBounds(60, 100, 50, 50);
		btnReset.addActionListener(borrarTodo);
		contentPane.add(btnReset);

		btnBorrarUno = new JButton("CE");
		btnBorrarUno.setBounds(10, 100, 50, 50);
		btnBorrarUno.addActionListener(borrar);
		contentPane.add(btnBorrarUno);

		/* TEXT FIELD */
		textFieldValor1 = new JTextField();
		textFieldValor1.setEnabled(false);
		textFieldValor1.setBounds(10, 67, 86, 20);
		contentPane.add(textFieldValor1);
		textFieldValor1.setColumns(10);

		textFieldValor2 = new JTextField();
		textFieldValor2.setEnabled(false);
		textFieldValor2.setBounds(124, 67, 86, 20);
		contentPane.add(textFieldValor2);
		textFieldValor2.setColumns(10);

		resultField = new JTextField();
		resultField.setEnabled(false);
		resultField.setBounds(249, 67, 86, 20);
		contentPane.add(resultField);
		resultField.setColumns(10);

	}

	ActionListener añadirOperacion = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (!"".equals(textFieldValor1.getText())) {
				JButton opcionEscojida = (JButton) e.getSource();
				lblOperacion.setText(opcionEscojida.getText());
				modificarLabelOperacion(" " + opcionEscojida.getText() + " ");
			}

		}
	};

	ActionListener añadirValores = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton botonEscojido = (JButton) e.getSource();
			String simbolo = calc.recuperarSimboloOperacion(lblInfo1.getText());

			if (simbolo.equals("")) {
				borrarResultado();
				textFieldValor1.setText(textFieldValor1.getText() + botonEscojido.getText());
			} else {
				textFieldValor2.setText(textFieldValor2.getText() + botonEscojido.getText());
			}

			if (textFieldValor1.getText().equals("")) {
				modificarLabelOperacion("");
			}

			modificarLabelOperacion(botonEscojido.getText());
		}
	};

	ActionListener positivoNegativo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String simbolo = calc.recuperarSimboloOperacion(lblInfo1.getText());
			if (simbolo.equals("")) {
				textFieldValor1.setText(invertirPositivoNegativo(textFieldValor1.getText()));
			} else {
				textFieldValor2.setText(invertirPositivoNegativo(textFieldValor2.getText()));
			}

		}
	};

	ActionListener borrarTodo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			reseteoParcial();
			borrarResultado();
			lblHistorico.setText("");

		}
	};

	ActionListener añadirComa = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String simbolo = calc.recuperarSimboloOperacion(lblInfo1.getText());
			if (simbolo.equals("")) {
				textFieldValor1.setText(comprobarComa(textFieldValor1.getText()));
			} else {
				textFieldValor2.setText(comprobarComa(textFieldValor2.getText()));
			}

		}
	};

	ActionListener borrar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String simbolo = calc.recuperarSimboloOperacion(lblInfo1.getText());
			if (simbolo.equals("")) {
				System.out.println(borrarUnCaracter(textFieldValor1.getText()));
				textFieldValor1.setText(borrarUnCaracter(textFieldValor1.getText()));
			} else {
				textFieldValor2.setText(borrarUnCaracter(textFieldValor2.getText()));
			}
			
			lblInfo1.setText(borrarUnCaracter(lblInfo1.getText()));

		}
	};
	ActionListener calcular = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double resultado = calc.operar(textFieldValor1.getText(), textFieldValor2.getText(),
					lblOperacion.getText());

			if (resultado != Double.MIN_VALUE) {
				reseteoParcial();
				escribirReultado(resultado);
			} else {
				JOptionPane.showMessageDialog(rootPane, "A ocurrido un error inesperado");
			}

		}
	};

	public String borrarUnCaracter(String text) {
		String result = "";
		if (!"".equals(text)) {
			result = text.substring(0, text.length() - 1);
		}
		return result;
	}

	private void reseteoParcial() {
		textFieldValor1.setText("");
		textFieldValor2.setText("");
		lblOperacion.setText("");
		lblInfo1.setText("");
	}

	private void borrarResultado() {
		resultField.setText("");
	}

	private void modificarLabelOperacion(String text) {
		lblInfo1.setText(lblInfo1.getText() + text);
	}

	public String invertirPositivoNegativo(String valor) {
		double num = Double.parseDouble(valor) * -1;
		valor = Double.toString(num);
		return valor;
	}

	public String comprobarComa(String text) {
		if (!text.contains(",") && !text.contains(".") && !text.isEmpty()) {
			text = text + ".";
			modificarLabelOperacion(",");
		}
		return text;
	}

	private void escribirReultado(double resultado) {
		resultField.setText(String.valueOf(resultado));
		modificarLabelOperacion(" = " + Double.toString(resultado));
		lblHistorico.setText("<html>" + lblHistorico.getText() + lblInfo1.getText() + "<br><html>");
	}

}
