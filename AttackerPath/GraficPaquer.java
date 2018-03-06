package malwarePack;
import java.awt.event.*;

import javax.swing.*;
public class GraficPaquer extends JFrame {
	public static void main(String args[]) {
		Frame frame = new Frame();		
	}
}
class Frame extends JFrame{
	public Frame(){
		setVisible(true);
		setSize(310,210);
		setTitle("MP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel panel = new Panel();
		add(panel);
	}
}
class Panel extends JPanel implements ActionListener{
	JLabel imagen = new JLabel("Imagen:");
	JTextField direccionCode = new JTextField();
	JTextField direccionImg = new JTextField();
	JButton boton = new JButton("empezar");
	JTextField escribir = new JTextField();
	JLabel codigo = new JLabel("Codigo:");
	JLabel direccion = new JLabel("Direccion:");
	JTextField direccionFin = new JTextField();
	
	public Panel() {
		setLayout(null);
		imagen.setBounds(0,-10, 100,60);
		add(imagen);
		
		direccionImg.setBounds(100,10,200,20);
		add(direccionImg);
		
		codigo.setBounds(0,20,100,60);
		add(codigo);
		
		direccionCode.setBounds(100,40,200,20);
		add(direccionCode);
		
		direccion.setBounds(0,50,100,60);
		add(direccion);
		
		direccionFin.setBounds(100, 70, 200, 20);
		add(direccionFin);
		
		boton.setBounds(100,95,100,50);
		boton.addActionListener(this);
		add(boton);
		
		escribir.setBounds(0,150,300,20);
		add(escribir);
	}

	public void actionPerformed(ActionEvent e) {
		String imagen = direccionImg.getText();
		String codigo = direccionCode.getText();
		String direccion = direccionFin.getText();
		Paquer paquer = new Paquer(imagen, codigo, direccion);
		escribir.setText("Creado");
		System.exit(0);
	}
	
}
