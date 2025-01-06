// Code by nathaliarmolina
// https://github.com/nathaliarmolina

//packtage
package main;

//libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

// class
public class JavaCalculadoraIMC implements ActionListener{
	
	// elements
	
	JFrame frame;
	JPanel panel, panel2;
	JLabel title, heightLabel, weightLabel, resultLabel, statusLabel, alert;
	JTextField txtHeight, txtWeight;
	JButton calculate, clear;
	String result = "";
	double height, weight, imc;
	
	
	//constructor
	public JavaCalculadoraIMC () {
		
		// Font Settings (font, type, size)
		Font fontMax = new Font("Candara",Font.BOLD,26);
		Font fontMid = new Font("Candara",Font.BOLD,20);
		Font fontMin = new Font("Candara",Font.BOLD,15);
		
		// Frame Settings	
		frame = new JFrame("Java Calculadora de IMC"); // creating JFrame 
		frame.setSize(650, 450); // size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closing method
		frame.setLayout(null); // no layout type
		frame.setResizable(false); // disable frame resize
		frame.setLocationRelativeTo(null); // centralize program
		
		// Panel Settings
		panel = new JPanel();  // creating JPanel
		panel.setSize(650,450); // size
		panel.setBackground(Color.orange); // color background
		panel.setLayout(null); // no layout type
		frame.add(panel); // add panel to frame

		
		// Title Settings
		title = new JLabel("Java Calculadora de IMC"); // creating Title Label
		title.setBounds(185,20,400,45); // set coordinates and size
		title.setFont(fontMax); // set font
		panel.add(title); // add title to panel
		
		
		// Height Label Settings
		heightLabel = new JLabel("Altura:"); // creating Title Label
		heightLabel.setBounds(135,80,90,45); // set coordinates and size
		heightLabel.setFont(fontMid); // set font
		panel.add(heightLabel); // add heightLabel to panel
		
		// txtHeight Settings
		txtHeight = new JTextField(); // creating txtField
		txtHeight.setBounds(205, 85, 70,30); // set coordinates and size
		txtHeight.setFont(fontMid); // set font
		panel.add(txtHeight); // add txtField to panel
		
		// weight label Settings
		weightLabel = new JLabel("Peso:"); // creating Title Label
		weightLabel.setBounds(315,80,90,45); // set coordinates and size
		weightLabel.setFont(fontMid); // set font
		panel.add(weightLabel); // add heightLabel to panel
				
		// txtWeight Settings
		txtWeight = new JTextField(); // creating txtField
		txtWeight.setBounds(370, 85, 70,30); // set coordinates and size
		txtWeight.setFont(fontMid); // set font
		panel.add(txtWeight); // add txtField to panel
		
		
		//calculate Button Settings
		calculate = new JButton("Calcular!"); // creating calculate button
		calculate.setBounds(205, 130,235,35); // set coordinates and size
		calculate.setFont(fontMin); // set font
		calculate.addActionListener(this); // calculate button action listener
		panel.add(calculate); // add calculate button to panel
		

		//Result Label Settings
		resultLabel = new JLabel("Seu IMC é: "); // creating resultLabel
		resultLabel.setBounds(275,180,100,30); // set coordinates and size
		resultLabel.setFont(fontMid); // set font
		panel.add(resultLabel); // add resultLabel to panel
		
		//Result Label Settings
		statusLabel = new JLabel(""); // creating resultLabel
		statusLabel.setBounds(245,220,160,30); // set coordinates and size
		statusLabel.setFont(fontMid); // set font
		panel.add(statusLabel); // add resultLabel to panel
		
		
		//clear Button Settings
		clear = new JButton("Limpar"); // creating calculate button
		clear.setBounds(265,270,115,35); // set coordinates and size
		clear.setFont(fontMin); // set font
		clear.addActionListener(this); // calculate button action listener
		clear.setVisible(true);
		panel.add(clear); // add calculate button to panel
		
		
		
		//Result Label Settings
		alert = new JLabel(""); // creating resultLabel
		alert.setBounds(220,330,210,30); // set coordinates and size
		alert.setFont(fontMin); // set font
		alert.setForeground(Color.red);
		panel.add(alert); // add resultLabel to panel
		
		
		
		frame.setVisible(true); // visible true

	}
	// main method to start the program
	public static void main(String[] args) {
		
		JavaCalculadoraIMC calculadora = new JavaCalculadoraIMC();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Calculate Button event
		if(e.getSource() == calculate) {
			
			try {
				
				height = Double.parseDouble(txtHeight.getText()); // convert String into Double 
				weight = Double.parseDouble(txtWeight.getText()); // convert String into Double 
				imc = weight / (height * height); // do the math
				result = Double.toString(imc); // convert result into String
				statusLabel.setText(result);
				
				if (imc < 18.5) {
					alert.setText(""); // clear alert
					result = "Abaixo do peso"; 
					statusLabel.setBounds(255,220,140,30); // coordinates and size
					statusLabel.setText(result); // display result

				}
				
				else if (imc >= 18.5 && imc < 25) {
					alert.setText(""); // clear alert
					result = "Peso Normal";
					statusLabel.setBounds(265,220,160,30); // coordinates and size
					statusLabel.setText(result); // display result
				}
				
				else if (imc >= 25 && imc < 30) {
					alert.setText(""); // clear alert
					result = "Sobrepeso";
					statusLabel.setBounds(275,220,160,30); // coordinates and size
					statusLabel.setText(result); // display result
				}
				
				else if (imc >= 30 && imc < 35) {
					alert.setText(""); // clear alert
					result = "Obesidade Grau I";
					statusLabel.setBounds(242,220,160,30); // coordinates and size
					statusLabel.setText(result); // display result
					 
				}
				
				else if (imc >= 35 && imc < 40) {
					alert.setText(""); // clear alert
					result = "Obesidade Grau II";
					statusLabel.setBounds(245,220,160,30); // coordinates and size
					statusLabel.setText(result); // display result
					
				}
				
				else {
					alert.setText(""); // clear alert
					result = "Obesidade Grau III";
					statusLabel.setBounds(245,220,160,30); // coordinates and size
					statusLabel.setText(result); // display result
				}
				
			}
			
			catch (NumberFormatException ex) {
				
				alert.setText("Digite uma altura e peso válidos");
				
			}
		}
		
		// Clear Button Event
		
		if(e.getSource() == clear) { 
			
			// clear all status
			result = "";
			height = 0.0;
			weight = 0.0;
			alert.setText("");
			statusLabel.setText("");
			txtHeight.setText("");
			txtWeight.setText("");
			
		}
		
		
	}

}
