/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ArchivoJugadoresException.java,v 1.2 2006/12/01 21:18:19 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License versi�n 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_mundial
 * Autor: Milena Vela - 25-ago-2006
 * Autor: Daniel Romero - 30-nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.mundial.mundo;

/**
 * Esta excepci�n sirve para indicar que hubo un problema procesando el archivo con la informaci�n de los jugadores a modificar
 */
public class ArchivoJugadoresException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye la excepci�n con una causa del error
     * @param causa El mensaje que describe el problema que se present�
     */
    public ArchivoJugadoresException( String causa )
    {
        super( causa );
    }

}
