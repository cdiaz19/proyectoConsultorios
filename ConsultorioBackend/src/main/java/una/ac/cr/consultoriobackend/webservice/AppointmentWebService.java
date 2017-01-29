
package una.ac.cr.consultoriobackend.webservice;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import una.ac.cr.consultoriobackend.dao.PatientDAO;
import una.ac.cr.consultoriobackend.dao.PatientDAOHibernateImpl;
import una.ac.cr.consultoriobackend.model.Appointment;
import una.ac.cr.consultoriobackend.service.PatientService;
import una.ac.cr.consultoriobackend.service.PatientServiceImpl;

/**
 *
 * @author Yeni
 */

@Path("appointments")
public class AppointmentWebService {
    private PatientDAO appointmentDAO;
    private PatientService service;

    @Context
    private UriInfo context;

    public AppointmentWebService() {
    }
    
    /**
     * Retrieves All the Appointments
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public  List<Appointment> getAllPatientsAppointment() {
         List<Appointment> dateList = null;
        appointmentDAO = new PatientDAOHibernateImpl();
        service = new PatientServiceImpl(appointmentDAO);
        
        dateList = service.findAllPatientAppointment();

        return dateList;
    }
    
     /**
     *  Retrieves only one office
     * @param id_appointment
     * @return
     */
    @GET
    @Path("/{id_appointment}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getPatientsAppointmentId(@PathParam("id_appointment") int id_appointment) {
        Appointment app = null;
        appointmentDAO = new PatientDAOHibernateImpl();
        service = new PatientServiceImpl(appointmentDAO);
        app = service.findByIdPatientAppointment(id_appointment);

        return app;
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment createAppointment(Appointment appointment) {

        appointmentDAO = new PatientDAOHibernateImpl();
        service = new PatientServiceImpl(appointmentDAO);
        appointment = service.savePatientAppointment(appointment);

        return appointment;
    }
    
    @DELETE
    @Path("/{id_appointment}")
    public boolean deleteAppointment(@PathParam("id_appointment") int id_office) {
        boolean result;
        appointmentDAO = new PatientDAOHibernateImpl();
        service = new PatientServiceImpl(appointmentDAO);
        
        result = service.deletePatientAppointment(id_office);

        return result;
    }
    
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment updateOffice( Appointment appointment) {

        appointmentDAO = new PatientDAOHibernateImpl();
        service = new PatientServiceImpl(appointmentDAO);
        
        appointment = service.updatePatientAppointment(appointment);

        return appointment;
    }
}
