package uniandes.cupi2.dogBook.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Imagen  extends JPanel
{
	public Imagen()
	{
		JLabel lbImagen= new JLabel();
		ImageIcon icono= new ImageIcon("./data/imagenes/titulo.jpg");
		lbImagen= new JLabel("");
		lbImagen.setIcon(icono);
		add(lbImagen);
		setPreferredSize(new Dimension(0,180));
		setBorder( new LineBorder( Color.BLACK ) );

	}
}
