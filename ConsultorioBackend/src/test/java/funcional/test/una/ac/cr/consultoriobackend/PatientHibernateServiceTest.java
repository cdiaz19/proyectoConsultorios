/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcional.test.una.ac.cr.consultoriobackend;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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

    @Test
    public void testHibernateFindByIdPatient() {
        patientDAO = mock(PatientDAOHibernateImpl.class);
        patientService = new PatientServiceImpl(patientDAO);

        Patient patient = new Patient();

        patient.setUser("Santiago");
        patient.setPassword("1234");
        patient.setName("Santiago Gonzalez");
        patient.setPhone("22795352");
        patient.setAddress("Alajuela");
        patient.setBirthday("23-12-1985");
        patient.setAssociatedDiseases("Neumonia");
        patient.setObservation("Fuerte dolor en el pecho, cuesta respirar");

        when(patientService.findByIdPatient(1)).thenReturn(patient);

        assertThat(patient.getName(), is("Santiago Gonzalez"));
    }

    @Test
    public void testHibernateUpdateOffice() {
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

        patient.setName("Santiago Gonzalez Solorzano");
        patientService.updatePatient(patient);
        assertThat(patient.getName(), is("Santiago Gonzalez Solorzano"));
    }

    @Test
    public void testHibernateDeletePatient() {
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

        patientService.deletePatient(patient);
        assertThat(patient.getIdPatient(), is(patient.getIdPatient()));
    }

    @Test
    public void testHibernateFindByNameffice() {
        patientDAO = mock(PatientDAOHibernateImpl.class);
        patientService = new PatientServiceImpl(patientDAO);

        Patient patient = new Patient();

        patient.setUser("Santiago");
        patient.setPassword("1234");
        patient.setName("Santiago Gonzalez");
        patient.setPhone("22795352");
        patient.setAddress("Alajuela");
        patient.setBirthday("23-12-1985");
        patient.setAssociatedDiseases("Neumonia");
        patient.setObservation("Fuerte dolor en el pecho, cuesta respirar");

        when(patientService.findByNamePatient("Santiago Gonzalez")).thenReturn(patient);

        assertThat(patient.getName(), is("Santiago Gonzalez"));
    }
}
