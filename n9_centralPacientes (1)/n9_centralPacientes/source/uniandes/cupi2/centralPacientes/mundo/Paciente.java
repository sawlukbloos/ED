/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Paciente.java,v 1.7 2007/04/13 04:16:34 carl-veg Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_centralPacientes
 * Autor: Daniel Francisco Romero - 11-jul-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.centralPacientes.mundo;

/**
 * Esta clase representa un paciente del hospital <br>
 * <b>inv:</b> <br>
 * codigo >= 0 <br>
 * nombre != null && nombre != "" <br>
 * clinica != null && clinica != "" <br>
 * informacionMedica != null <br>
 * sexo == HOMBRE o sexo == MUJER
 */
public class Paciente
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para representar a un Hombre
     */
    public final static int HOMBRE = 1;
    
    /**
     * Constante para representar a una mujer
     */
    public final static int MUJER = 2;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El c�digo del paciente
     */
    private int codigo;

    /**
     * El nombre del paciente
     */
    private String nombre;

    /**
     * Cl�nica a la que asiste el paciente
     */
    private String clinica;

    /**
     * La informaci�n m�dica del paciente
     */
    private String informacionMedica;

    /**
     * Sexo del paciente
     */
    private int sexo;

    /**
     * El siguiente paciente de la lista
     */
    private Paciente siguiente;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un paciente
     * @param cod El c�digo del paciente - cod >= 0
     * @param nom El nombre del paciente - nom!=null y nom!=""
     * @param clin La cl�nica del paciente - clin!=null y clin!=""
     * @param infoMed la informaci�n m�dica del paciente - infoMed!=null
     * @param sex El sexo del paciente. sex pertenece a { HOMBRE, MUJER }
     */
    public Paciente( int cod, String nom, String clin, String infoMed, int sex )
    {
        codigo = cod;
        nombre = nom;
        clinica = clin;
        informacionMedica = infoMed;
        sexo = sex;
        siguiente = null;

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el c�digo del paciente
     * @return El c�digo del paciente
     */
    public int darCodigo( )
    {
        return codigo;
    }

    /**
     * Retorna el nombre del paciente
     * @return El nombre del paciente
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la cl�nica asignada al paciente
     * @return La cl�nica asignada al paciente
     */
    public String darClinica( )
    {
        return clinica;
    }

    /**
     * Retorna la informaci�n m�dica del paciente
     * @return La informaci�n m�dica del paciente
     */
    public String darInformacionMedica( )
    {
        return informacionMedica;
    }

    /**
     * Retorna el sexo del paciente
     * @return El sexo del paciente
     */
    public int darSexo( )
    {
        return sexo;
    }

    /**
     * Retorna el siguiente paciente de la lista
     * @return El siguiente paciente de la lista
     */
    public Paciente darSiguiente( )
    {
        return siguiente;
    }

    /**
     * Cambia el paciente que le sigue al actual
     * @param pac Paciente siguiente al actual
     */
    public void cambiarSiguiente( Paciente pac )
    {
        siguiente = pac;
    }

    /**
     * Desconecta el paciente que le sigue en la lista al paciente actual. <br>
     * <b>pre: </b> No es el �ltimo paciente de la lista <br>
     * <b>post: </b> El paciente siguiente al actual fue desconectado de la lista.
     */
    public void desconectarSiguiente( )
    {
        siguiente = siguiente.siguiente;
    }

    /**
     * Inserta el paciente despu�s del actual. <br>
     * <b>post: </b> Se insert� el paciente especificado despu�s del paciente actual. <br>
     * @param pac El paciente a insertar - elPaciente!=null
     */
    public void insertarDespues( Paciente pac )
    {
        pac.siguiente = siguiente;
        siguiente = pac;
    }

    /**
     * Retorna una cadena con la informaci�n del paciente
     * @return [ codigo ]: nombre
     */
    public String toString( )
    {
        return "[ " + codigo + " ]: " + nombre;
    }

    /**
     * Cambia la informaci�n m�dica del paciente
     * @param informacion Nueva informaci�n m�dica del paciente
     */
    public void cambiarInformacionMedica( String informacion )
    {
        informacionMedica = informacion;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertError. <br>
     * <b>inv: </b> <br>
     * codigo >= 0 nombre != null <br>
     * nombre != "" clinica != null <br>
     * clinica != "" <br>
     * informacionMedica != null <br>
     * sexo == HOMBRE o sexo == MUJER
     */
    private void verificarInvariante( )
    {
        assert codigo >= 0 : "C�digo inv�lido";
        assert nombre != null && !nombre.equals( "" ) : "Nombre inv�lido";
        assert clinica != null && !clinica.equals( "" ) : "Cl�nica inv�lida";
        assert informacionMedica != null : "Informaci�n m�dica inv�lida";
        assert sexo == HOMBRE || sexo == MUJER : "Valor inv�lido para el atributo sexo";
    }
}
