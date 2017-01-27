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
import una.ac.cr.consultoriobackend.model.PatientAppointment;
import una.ac.cr.consultoriobackend.service.PatientService;
import una.ac.cr.consultoriobackend.service.PatientServiceImpl;

/**
 *
 * @author Yeni
 */

@Path("citas")
public class PatientAppointmentWebService {

    private PatientDAO patientDAO;
    private PatientService patientService;

    @Context
    private UriInfo context;

    /**
     *
     */
    public PatientAppointmentWebService() {
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PatientAppointment> getAllAppointments() {
        List<PatientAppointment> officeList = null;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        officeList = patientService.findAllPatientAppointment();

        return officeList;
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PatientAppointment getAppointmentID(@PathParam("id") int id) {
        PatientAppointment office = null;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        office = patientService.findByIdPatientAppointment(id);

        return office;
    }

    /**
     *
     * @param patient
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PatientAppointment createAppointment(PatientAppointment patient) {

        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        patient = patientService.savePatientAppointment(patient);

        return patient;
    }

    /**
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    public boolean deleteAppointment(@PathParam("id") int id) {
        boolean result;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        result = patientService.deletePatientAppointment(id);

        return result;
    }

    /**
     *
     * @param patient
     * @return
     */
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PatientAppointment updateAppointment(PatientAppointment patient) {

        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);
        patient = patientService.updatePatientAppointment(patient);

        return patient;
    }
}
