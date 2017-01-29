
package una.ac.cr.consultoriobackend.webservice;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import una.ac.cr.consultoriobackend.dao.PatientDAO;
import una.ac.cr.consultoriobackend.dao.PatientDAOHibernateImpl;
import una.ac.cr.consultoriobackend.model.Office;
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.service.OfficeServiceImpl;
import una.ac.cr.consultoriobackend.service.PatientService;
import una.ac.cr.consultoriobackend.service.PatientServiceImpl;


/**
 *
 * @author Kimberly
 */

@Path("patients")
public class PatientWebService {
    private PatientDAO patientDAO;
    private PatientService patientService;

    @Context
    private UriInfo context;

    public PatientWebService() {
    }

    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        List<Patient> patientList = null;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);
        
        patientList = patientService.findAllPatient();

        return patientList;
    }

    /**
     *  Retrieves only one office
     * @param id_patient
     * @return
     */
    @GET
    @Path("/{id_patient}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientId(@PathParam("id_patient") int id_patient) {
        Patient patient = null;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);
        
        patient = patientService.findByIdPatient(id_patient);

        return patient;
    }



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


    @DELETE
    @Path("/{id_patient}")
    public boolean deleteOffice(@PathParam("id_patient") int id_patient) {
        boolean result;
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);
        
        result = patientService.deletePatient(id_patient);

        return result;
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Patient updateOffice(Patient patient) {

        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);
        
        patient = patientService.updatePatient(patient);

        return patient;
    }
}
