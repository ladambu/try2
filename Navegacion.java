package uniandes.cupi2.dogBook.interfaz;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.PanelUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uniandes.cupi2.dogBook.mundo.*;



public class Navegacion extends JPanel implements ActionListener
{
	public static String PRIMER= "Ver primer perro";
	public static String ANTERIOR= "Ver perro anterior";
	public static String BUSCAR= "Buscar perro";
	public static String SIGUIENTE= "Ver siguiente perro";
	public static String ULTIMO="Ver último perro";
	public static String POPULAR= "Ver perro más popular";
	public static String OPCION1= "Respuesta 1";
	public static String OPCION2= "Respuesta 2";

	private JButton primerPerro;
	private JButton anterior;
	private JButton buscar;
	private JButton siguiente;
	private JButton ultimoPerro;

	private JButton perroPopular;
	private JButton opcion1;
	private JButton opcion2;



	private InterfazDogBook principal;


	public Navegacion(InterfazDogBook i)
	{
		principal=i;
		setPreferredSize(new Dimension(0,125));
		TitledBorder border= BorderFactory.createTitledBorder("Navegación");
		setLayout(new GridLayout (2,1));

		JPanel navegacion1= new JPanel();
		add(navegacion1);
		navegacion1.setBorder(border);


		navegacion1.setLayout(new GridLayout (1,5));
		primerPerro= new JButton("Ver primer perro");
		primerPerro.setActionCommand(PRIMER);
		primerPerro.addActionListener(this);
		anterior= new JButton("<<");
		anterior.setActionCommand(ANTERIOR);
		anterior.addActionListener(this);
		buscar= new JButton("Buscar");
		buscar.setActionCommand(BUSCAR);
		buscar.addActionListener(this);
		siguiente= new JButton(">>");
		siguiente.setActionCommand(SIGUIENTE);
		siguiente.addActionListener(this);
		ultimoPerro= new JButton("Ver último perro");
		ultimoPerro.setActionCommand(ULTIMO);
		ultimoPerro.addActionListener(this);

		navegacion1.add(primerPerro);
		navegacion1.add(anterior);
		navegacion1.add(buscar);
		navegacion1.add(siguiente);
		navegacion1.add(ultimoPerro);



		JPanel opciones= new JPanel();
		TitledBorder border1= BorderFactory.createTitledBorder("Opciones");
		opciones.setBorder(border1);
		add(opciones);

		opciones.setLayout(new GridLayout(1,3));
		perroPopular= new JButton("Perro más popular");
		perroPopular.setActionCommand(POPULAR);
		perroPopular.addActionListener(this);

		opcion1= new JButton("Opción 1");
		opcion1.setActionCommand(OPCION1);
		opcion1.addActionListener(this);

		opcion2= new JButton("Opción 2");
		opcion2.setActionCommand(OPCION2);
		opcion2.addActionListener(this);

		opciones.add(perroPopular);
		opciones.add(opcion1);
		opciones.add(opcion2);


		setPreferredSize(new Dimension(780,115));
	}

	public void actionPerformed(ActionEvent evento) 
	{
		String comando= evento.getActionCommand();

		if(comando.equals(OPCION1))
		{
			principal.opcion1();	
		}
		else if(comando.equals(OPCION2))
		{
			principal.opcion2();
		}
		else if (comando.equals(POPULAR))
		{
			principal.perroMasPopular();
		}
		else if(comando.equals(SIGUIENTE))
		{
			principal.siguiente();
		}
		else if(comando.equals(ANTERIOR))
		{
			principal.anterior();
		}
		else if(comando.equals(ULTIMO)){
			principal.ultimo();
		}
		else if(comando.equals(PRIMER))
		{
			principal.primero();}

		else if(comando.equals(BUSCAR))
		{
			principal.buscarperro();
		}
	}


}




