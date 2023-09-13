/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ElementoExisteException.java,v 1.1 2006/08/28 20:25:13 f-vela Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_mundial
 * Autor: Milena Vela - 25-ago-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.mundial.mundo;

/**
 * Esta excepci�n se lanza cuando se intenta agregar al mundial un elemento repetido. <br>
 * El mensaje asociado con la excepci�n debe indicar el equipo o el jugador que caus� el error.
 */
public class ElementoExisteException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye la excepci�n indicando el equipo o el jugador que caus� el error
     * @param nomElem nombre del elemento repetido
     */
    public ElementoExisteException( String nomElem )
    {
        super( nomElem );
    }
}
