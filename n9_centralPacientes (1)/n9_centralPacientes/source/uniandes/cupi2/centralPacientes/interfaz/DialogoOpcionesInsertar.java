/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: DialogoOpcionesInsertar.java,v 1.7 2009/03/04 13:48:48 ju-cort1 Exp $ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 
 * Ejercicio: n9_centralPacientes
 * Autor: Daniel Romero- Julio 7/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.centralPacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Di�logo con las opciones para realizar la inserci�n de un paciente
 */
public class DialogoOpcionesInsertar extends JDialog
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la ventana principal de la aplicaci�n
     */
    private InterfazCentralPacientes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las opciones
     */
    private PanelOpcionesInsertar panelOpciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del di�logo
     * @param ventana Referencia a la ventana principal de la aplicaci�n - ventana!=null
     */
    public DialogoOpcionesInsertar( InterfazCentralPacientes ventana )
    {
        super( ventana, true );
        principal = ventana;
        setLayout( new BorderLayout( ) );
        setResizable( false );
        setTitle( "Central de Pacientes" );
        setPreferredSize( new Dimension( 339, 197 ) );

        // Panel con las opciones
        panelOpciones = new PanelOpcionesInsertar( this );
        add( panelOpciones, BorderLayout.NORTH );

        pack( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Cancela la adici�n del paciente cerrando el di�logo
     */
    public void cancelar( )
    {
        dispose( );
    }

    /**
     * Muestra el di�logo para proseguir con la adici�n del paciente
     */
    public void continuarAdicionPaciente( )
    {
        try
        {
            int forma = panelOpciones.darFormaInsercion( );
            int codigo = panelOpciones.darCodigoPaciente( );
            dispose( );
            principal.mostrarDialogoInsertarPaciente( forma, codigo );
        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "El c�digo del paciente con relaci�n al cual se va a realizar la adici�n debe ser un valor num�rico", "Adici�n Pacientes", JOptionPane.ERROR_MESSAGE );
        }
    }

}
