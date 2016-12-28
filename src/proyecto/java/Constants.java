/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java;

/**
 *
 * @author cristian
 */
public class Constants {
    
     /**
     *
     */
    public static final String FILENAME = "src/proyecto/resources/officesList.json";
    public static final String FILENAME_USER = "src/proyecto/resources/patientsList.json";

    /**
     *
     */
    public static final Object[] 
            TABLE_HEADER = {"Nombre Consultorio", "Contacto", "Días Consulta", "Horario Apertura", "Horario Cierre"};
    
    /**
     *
     */
    public static final Object[] 
            TABLE_HEADER_PATIENT = {"Nombre Paciente", "Contacto", "Domicilio",
                "Fecha Nacimiento", "Enfermedades Asociadas", "Observaciones"};
}
