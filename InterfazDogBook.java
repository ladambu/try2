package uniandes.cupi2.dogBook.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.dogBook.mundo.DogBook;
import uniandes.cupi2.dogBook.mundo.Perro;
import uniandes.cupi2.dogBook.mundo.Reaccion;

public class InterfazDogBook extends JFrame{

	private DogBook dogBook;
	private Imagen panelImagen;
	private Navegacion panelNavegacion;
	private InfoPerro panelInfoPerro;
	
	public InterfazDogBook()
	{
		try{
			dogBook = new DogBook();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog( this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
		}
		
		setLayout(new BorderLayout());
		setSize( 789, 750 );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("                                                                                                         DogBook");
		setResizable(false);


		panelImagen= new Imagen();
		add(panelImagen,BorderLayout.NORTH);
		
		panelInfoPerro = new InfoPerro(this);
		add(panelInfoPerro,BorderLayout.CENTER);
		
		panelNavegacion = new Navegacion(this);
		add(panelNavegacion,BorderLayout.SOUTH);

	}
	
	
	public void perroMasPopular()
	{

		try {
			dogBook.darPerroMasPopular();
			JOptionPane.showMessageDialog( this, "El perro más popular es "+dogBook.darPerroMasPopular().darNombre() ,"Perro más popular",JOptionPane.INFORMATION_MESSAGE );
			//TODO reparar
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog( this,  e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
		}
	}
	/**
	 * Llamado para realizar el método de extensión 1 </br>
	 */
	public void opcion1()
	{

		JOptionPane.showMessageDialog( this, dogBook.metodo1() ,"Respuesta",JOptionPane.INFORMATION_MESSAGE );
	}
	/**
	 * Llamado para realizar el método de extensión 2 </br>
	 */
	public void opcion2()
	{
		JOptionPane.showMessageDialog( this, dogBook.metodo2() ,"Respuesta",JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Cambia el perro actual por el que se introduce </br>
	 */
	public void buscarperro(){
		
			String name = JOptionPane.showInputDialog( this, "Ingrese el nombre del perro: ", "Buscar perro", JOptionPane.PLAIN_MESSAGE );
			//Se asegura de que la primera letra del nombre sea Capital
			if(name.equals("")||name==null)
			{
				JOptionPane.showMessageDialog( this, "Ingrese un nombre valido","Error",JOptionPane.ERROR_MESSAGE );

			}
			else
			{
				String s1 = name.substring(0, 1).toUpperCase();

				name =s1 + name.substring(1);


				try {
					dogBook.buscarPerroPorNombre(name);
					refrescardatosperro();
					refrescarReacciones();
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog( this,  e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
				}
			}
	}

		/**
		 * Retorna el perro actual </br>
		 * @return pero actual o un mensaje de error indicando si no existe
		 */
		public Perro darPerroActual(){
			Perro a=null;
			try {
				a =  dogBook.darPerroActual();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog( this,  e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
			return a;
		}

		/**
		 * Refrezca la interfaz </br>
		 */
		private void refrescardatosperro()
		{
		panelInfoPerro.refrescaDatosPerro( darPerroActual().darNombre(),darPerroActual().darEdad(),darPerroActual().darSexo(),darPerroActual().darMeGusta(),darPerroActual().darNoMeGusta(),darPerroActual().darRaza(), darPerroActual().darFoto(),darPerroActual().buscoPareja());
		}






		/**
		 * Cambia el perro actual a el siguiente o muestra un mensaje de error si se encuentra en el ultimo perro </br>
		 */
		public void siguiente()
		{
			try {
				dogBook.darPerroSiguiente();
				refrescardatosperro();
				refrescarReacciones();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog( this,  e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}

		/**
		 * Cambia el perro actual a el anterior o muestra un mensaje de error si se encuentra en el primer perro </br>
		 */

		public void anterior()
		{
			try {
				dogBook.darPerroAnterior();
				refrescardatosperro();
				refrescarReacciones();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog( this,  e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}

		/**
		 * Cambia el perro actual a el primero o muestra un mensaje de error si se encuentra en el primer perro </br>
		 */
		public void primero(){

			try {
				dogBook.darPrimerPerro();
				refrescardatosperro();
				refrescarReacciones();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog( this,  e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		/**
		 * Cambia el perro actual a el ultimo o muestra un mensaje de error si se encuentra en el ultimo perro </br>
		 */
		public void ultimo(){
			try {
				dogBook.darUltimoPerro();
				refrescardatosperro();
				refrescarReacciones();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog( this,  e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}







		/**
		 * Refrezca las reacciones </br>
		 */

		public void refrescarReacciones()
		{
			try {
				int likes = darPerroActual().darReaccion(Reaccion.ME_GUSTA).darCantidad();
				int coras = darPerroActual().darReaccion(Reaccion.CORAZON).darCantidad();
				int smiles =darPerroActual().darReaccion(Reaccion.CARA_FELIZ).darCantidad();

				panelInfoPerro.refrescarReacciones(likes, coras, smiles);
			} 

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}




	
	public static void main(String[] args) {
		
		InterfazDogBook interfaz= new InterfazDogBook();
		interfaz.setVisible(true);
//	}

}}
