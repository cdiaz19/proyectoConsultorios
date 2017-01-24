/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcional.test.una.ac.cr.consultoriobackend;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import una.ac.cr.consultoriobackend.dao.PatientDAO;
import una.ac.cr.consultoriobackend.dao.PatientDAOHibernateImpl;
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.service.PatientService;
import una.ac.cr.consultoriobackend.service.PatientServiceImpl;

/**
 *
 * @author cristian
 */
public class PatientHibernateServiceTest {

    private PatientDAO patientDAO;
    private PatientService patientService;
    private Patient patient = null;

    public PatientHibernateServiceTest() {
    }

    @Test
    public void testHibernateSavePatient() {
        patientDAO = new PatientDAOHibernateImpl();
        patientService = new PatientServiceImpl(patientDAO);

        patient = new Patient();

        patient.setUser("Santiago");
        patient.setPassword("1234");
        patient.setName("Santiago Gonzalez");
        patient.setPhone("22795352");
        patient.setAddress("Alajuela");
        patient.setBirthday("23-12-1985");
        patient.setAssociatedDiseases("Neumonia");
        patient.setObservation("Fuerte dolor en el pecho, cuesta respirar");

        patient = patientService.savePatient(patient);
        assertNotNull(patient.getIdPatient());
    }
}
