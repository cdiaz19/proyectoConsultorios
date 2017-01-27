/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java;

/**
 *
 * @author cristian
 */
public class Constants {

    /**
     *
     */
    public static final String FILENAME = "src/main/java/ac/cr/una/proyecto/resources/officesList.json";

    /**
     *
     */
    public static final String FILENAME_PATIENT = "src/main/java/ac/cr/una/proyecto/resources/patientsList.json";

    /**
     *
     */
    public static final String FILENAME_APPOINTMENT = "src/main/java/ac/cr/una/proyecto/resources/appointmentsList.json";

    /**
     *
     */
    public static String ACTUAL = "";

    /**
     *
     */
    public static final Object[] TABLE_HEADER = {"Nombre Consultorio", "Contacto", "Días Consulta",
        "Horario Apertura", "Horario Cierre"};

    /**
     *
     */
    public static final Object[] TABLE_HEADER_PATIENT = {"Usuario", "Contraseña", "Nombre Paciente",
        "Contacto", "Domicilio", "Fecha Nacimiento", "Enfermedades Asociadas", "Observaciones"};

    /**
     *
     */
    public static final Object[] TABLE_HEADER_APPOINTMENT = {"Nombre Paciente", "Nombre Consultorio", "Fecha", "Hora"};
}
