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
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.service.PatientService;
import una.ac.cr.consultoriobackend.service.PatientServiceImpl;

/**
 * REST Web Service
 *
 * @author Yeni
 */
@Path("patients")
public class PatientWebService {

    private PatientDAO patientDAO;
    private PatientService patientService;

    @Context
    private UriInfo context;

    /**
     *
     */
    public PatientWebService() {
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        List<Patient> officeList = null;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        officeList = patientService.findAllPatient();

        return officeList;
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id_patient}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientID(@PathParam("id_patient") int id) {
        Patient office = null;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        office = patientService.findByIdPatient(id);

        return office;
    }

    /**
     *
     * @param name
     * @return
     */
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientName(@PathParam("name") String name) {
        Patient office = null;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        office = patientService.findByNamePatient(name);

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
    public Patient createPatient(Patient patient) {

        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        patient = patientService.savePatient(patient);

        return patient;
    }

    /**
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id_patient}")
    public boolean deletePatient(@PathParam("id_patient") int id) {
        boolean result;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        result = patientService.deletePatient(id);

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
    public Patient updatePatient(Patient patient) {

        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);
        patient = patientService.updatePatient(patient);

        return patient;
    }
}
