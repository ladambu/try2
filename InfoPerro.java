package uniandes.cupi2.dogBook.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javafx.scene.layout.Border;
import uniandes.cupi2.dogBook.mundo.Reaccion;

public class InfoPerro extends JPanel implements ActionListener{

	
	private InterfazDogBook ventana;

	private JCheckBox cbBuscaP;
	private JLabel labEdad;
	private JTextField txtEdad;
	private JLabel labNombre;
	private JLabel labRaza;
	private JTextField txtRaza;
	private JLabel labSexo;
	private JTextField txtSexo;
	private JLabel labGusta;
	private JTextField txtGusta;
	private JLabel labNoGusta;
	private JTextField txtNogusta;

	private JLabel lblImagen; 

	private JButton btnlike;
	private JButton btncora;
	private JButton btnsmile;
	private JLabel labLikes;
	private JLabel labcoras;
	private JLabel labsmiles;
	private JLabel labBuscaPareja;


	private final static String GUSTA="gusta";
	private final static String ENCANTA= "encanta";
	private final static String FELIZ="feliz";
	
	
	public InfoPerro(InterfazDogBook principal){
		TitledBorder border = BorderFactory.createTitledBorder( "Informacion Perro" );
		border.setTitleColor( Color.BLUE );
		setBorder( border );
		ventana =  principal;

		labNombre = new JLabel(ventana.darPerroActual().darNombre());
		labEdad = new JLabel("Edad: ");
		txtEdad  = new JTextField(""+ventana.darPerroActual().darEdad());
		txtEdad.setEditable(false);
		labRaza = new JLabel("Raza:");
		txtRaza = new JTextField(ventana.darPerroActual().darRaza());
		txtRaza.setEditable(false);
		labSexo = new JLabel("Sexo: ");
		txtSexo = new JTextField(ventana.darPerroActual().darSexo());
		txtSexo.setEditable(false);
		labGusta = new JLabel("Me gusta: ");
		txtGusta = new JTextField(ventana.darPerroActual().darMeGusta());
		txtGusta.setEditable(false);
		labNoGusta = new JLabel("No me gusta: ");
		txtNogusta = new JTextField(ventana.darPerroActual().darNoMeGusta());
		txtNogusta.setEditable(false);
		cbBuscaP= new JCheckBox();
		labBuscaPareja = new JLabel("Busca pareja");
		cbBuscaP.setSelected(ventana.darPerroActual().buscoPareja());
		cbBuscaP.setEnabled(false);
		lblImagen = new JLabel( );
		
		
		
		// panel izquierda 
		
		JPanel auxZurdo = new JPanel(new BorderLayout());
		
		ImageIcon icono = new ImageIcon(ventana.darPerroActual().darFoto());
		lblImagen.setIcon( icono );
		
		
		

		JPanel panelReacciones = new JPanel(new GridLayout(2, 5));
		panelReacciones.setBorder( new EmptyBorder( 4, 4, 4, 4 ) );


		labLikes=new JLabel(""+ventana.darPerroActual().darReaccion(Reaccion.ME_GUSTA).darCantidad(),SwingConstants.CENTER);
		labcoras=new JLabel(""+ventana.darPerroActual().darReaccion(Reaccion.ME_GUSTA).darCantidad(),SwingConstants.CENTER);
		labsmiles =new JLabel(""+ventana.darPerroActual().darReaccion(Reaccion.ME_GUSTA).darCantidad(),SwingConstants.CENTER);

		ImageIcon likesico = new ImageIcon("./data/imagenes/me_gusta.png");
		ImageIcon smileico = new ImageIcon("./data/imagenes//cara_feliz.png");
		ImageIcon coraico = new ImageIcon("./data/imagenes//corazon.png");

		btnlike = new JButton();
		btnlike.setActionCommand(GUSTA);
		btnlike.setIcon(likesico);
		btnlike.addActionListener(this);

		btncora = new JButton();
		btncora.setActionCommand(ENCANTA);
		btncora.addActionListener(this);
		btncora.setIcon(coraico);

		btnsmile= new JButton();
		btnsmile.setIcon(smileico);
		btnsmile.setActionCommand(FELIZ);
		btnsmile.addActionListener(this);
		
		panelReacciones.add( new JLabel(""));
		panelReacciones.add(btnlike);
		panelReacciones.add(btncora);
		panelReacciones.add(btnsmile);
		panelReacciones.add(new JLabel(""));
		panelReacciones.add(new JLabel(""));
		panelReacciones.add(labLikes);
		panelReacciones.add(labcoras);
		panelReacciones.add(labsmiles);
		panelReacciones.add(new JLabel(""));
		auxZurdo.add(lblImagen,BorderLayout.NORTH);
		auxZurdo.add(panelReacciones,BorderLayout.SOUTH);
		
		
		//panel derecha
		JPanel panelAuzDerecha = new JPanel(new BorderLayout());
		
		JPanel nombreperro= new JPanel(new BorderLayout());
	
		labNombre.setFont( new Font( "Cooper Black", Font.BOLD , 36 ) );


		nombreperro.add(labNombre);
		labNombre.setHorizontalAlignment(JLabel.CENTER);
		labNombre.setVerticalAlignment(JLabel.CENTER);
		
		
		JPanel panelDatosPerro = new JPanel(new GridLayout(7, 2));

		panelDatosPerro.setBorder( new EmptyBorder( 2, 2, 2, 2 ) );

		panelDatosPerro.add(labEdad);
		panelDatosPerro.add(txtEdad);
		panelDatosPerro.add(labRaza);
		panelDatosPerro.add(txtRaza);
		panelDatosPerro.add(labSexo);
		panelDatosPerro.add(txtSexo);
		panelDatosPerro.add(labGusta);
		panelDatosPerro.add(txtGusta);
		panelDatosPerro.add(labNoGusta);
		panelDatosPerro.add(txtNogusta);
		panelDatosPerro.add(labBuscaPareja);
		panelDatosPerro.add(cbBuscaP);
		panelDatosPerro.add(new JLabel(""));
		panelDatosPerro.add(new JLabel(""));
		
		panelAuzDerecha.add(nombreperro,BorderLayout.NORTH);
		panelAuzDerecha.add(panelDatosPerro,BorderLayout.CENTER);
		add(auxZurdo,BorderLayout.WEST);
		add(panelAuzDerecha,BorderLayout.CENTER);
	
		nombreperro.setPreferredSize(new Dimension(440,100));
		auxZurdo.setPreferredSize(new Dimension(300,400));
		panelAuzDerecha.setPreferredSize(new Dimension(450,400));
		
	}
	
	//metodos
	
	public void refrescarReacciones(int pLikes, int pCoras, int pSmiles)
	{
		labLikes.setText(""+pLikes);
		labcoras.setText(""+pCoras);
		labsmiles.setText(""+pSmiles);
	}
	
	/**
	 * Actualiza los datos del perro de la interfaz con los que entran por parametro
	  * @param pNombre Nombre del perro. pNombre != null && pNombre != "".
     * @param pEdad La edad del perro. pEdad >= 0.
     * @param pSexo Sexo del perro. pSexo != null && pSexo != "".
     * @param pMeGusta Lo que le gusta al perro. pMeGusta != null && pMeGusta != "".
     * @param pNoGuta Lo que no le gusta al perro. pNoMeGusta != null && pNoMeGusta != "".
     * @param raza Raza del perro. pRaza != null && pRaza != "".
     * @param pFoto Foto del perro. pFoto != null && pFoto != "".
     * @param busca Si el el perro está buscando pareja o no. pBusco== {true, false}.
	 */
	public void refrescaDatosPerro(String pNoombre,int pEdad,String pSexo,String pGusta,String pNoguta , String raza,String pFoto,Boolean busca){
		txtEdad.setText(""+pEdad);
		txtRaza.setText(raza);
		txtGusta.setText(pGusta);
		txtNogusta.setText(pNoguta);

		txtSexo.setText(pSexo);
		labNombre.setText(pNoombre);
		cbBuscaP.setSelected(busca);

		ImageIcon icono = new ImageIcon(pFoto);
		lblImagen.setIcon( icono );

	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String comando = arg0.getActionCommand( );

		if (comando.equals(GUSTA))
		{
			ventana.darPerroActual().reaccionar(Reaccion.ME_GUSTA);
			ventana.refrescarReacciones();
		}
		else if(comando.equals(ENCANTA))
		{
			ventana.darPerroActual().reaccionar(Reaccion.CORAZON);
			ventana.refrescarReacciones();
		}
		else if(comando.equals(FELIZ))
		{
			ventana.darPerroActual().reaccionar(Reaccion.CARA_FELIZ);
			ventana.refrescarReacciones();
		}

	}

}
