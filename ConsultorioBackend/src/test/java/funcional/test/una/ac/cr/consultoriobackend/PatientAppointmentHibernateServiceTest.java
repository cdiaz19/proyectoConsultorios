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
import una.ac.cr.consultoriobackend.model.Office;
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.model.Appointment;
import una.ac.cr.consultoriobackend.service.PatientService;
import una.ac.cr.consultoriobackend.service.PatientServiceImpl;

/**
 *
 * @author cristian
 */
public class PatientAppointmentHibernateServiceTest {

//    private PatientDAO patientDAO;
//    private PatientService patientService;
//    private Patient patient = null;
//
//    /**
//     *
//     */
//    @Test
//    public void testHibernateSavePatient() {
//        patientDAO = new PatientDAOHibernateImpl();
//        patientService = new PatientServiceImpl(patientDAO);
//
//        patient = new Patient();
//        Office office = new Office();
//        PatientAppointment patientAppointment = new PatientAppointment();
//
//        patient.setUser("Santiago");
//        patient.setPassword("1234");
//        patient.setName("Santiago Gonzalez");
//        patient.setPhone("22795352");
//        patient.setAddress("Alajuela");
//        patient.setBirthday("23-12-1985");
//        patient.setAssociatedDiseases("Neumonia");
//        patient.setObservation("Fuerte dolor en el pecho, cuesta respirar");
//
//        office.setName("Hospital CIMA");
//        office.setPhone("22795122");
//        office.setDays("Lunes y Martes");
//        office.setHourStart("8:00");
//        office.setHourEnd("5:00");
//
//        patientAppointment.setOffice(office);
//        patientAppointment.setPatient(patient);
//        patientAppointment.setDate("30-01-2017");
//        patientAppointment.setHour("4:30 pm");
//
//        patientAppointment = patientService.savePatientAppointment(patientAppointment);
//        assertNotNull(patientAppointment.getIdAppointment());
//    }
//    
//    /**
//     *
//     */
//    @Test
//    public void testHibernateFindByIdPatientAppointment() {
//        patientDAO = mock(PatientDAOHibernateImpl.class);
//        patientService = new PatientServiceImpl(patientDAO);
//
//        Patient patient = new Patient();
//        Office office = new Office();
//        PatientAppointment patientAppointment = new PatientAppointment();
//
//        patient.setUser("Santiago");
//        patient.setPassword("1234");
//        patient.setName("Santiago Gonzalez");
//        patient.setPhone("22795352");
//        patient.setAddress("Alajuela");
//        patient.setBirthday("23-12-1985");
//        patient.setAssociatedDiseases("Neumonia");
//        patient.setObservation("Fuerte dolor en el pecho, cuesta respirar");
//
//        office.setName("Hospital CIMA");
//        office.setPhone("22795122");
//        office.setDays("Lunes y Martes");
//        office.setHourStart("8:00");
//        office.setHourEnd("5:00");
//
//        patientAppointment.setOffice(office);
//        patientAppointment.setPatient(patient);
//        patientAppointment.setDate("30-01-2017");
//        patientAppointment.setHour("4:30 pm");
//
//        when(patientService.findByIdPatientAppointment(1)).thenReturn(patientAppointment);
//        assertThat(patientAppointment.getPatient().getName(), is("Santiago Gonzalez"));
//    }
//    
//    /**
//     *
//     */
//    @Test
//    public void testHibernateUpdatePatientAppointment() {
//        patientDAO = new PatientDAOHibernateImpl();
//        patientService = new PatientServiceImpl(patientDAO);
//
//        patient = new Patient();
//        Office office = new Office();
//        PatientAppointment patientAppointment = new PatientAppointment();
//
//        patient.setUser("Carlos");
//        patient.setPassword("1234");
//        patient.setName("Carlos Gonzalez");
//        patient.setPhone("22795352");
//        patient.setAddress("Alajuela");
//        patient.setBirthday("23-12-1985");
//        patient.setAssociatedDiseases("Neumonia");
//        patient.setObservation("Fuerte dolor en el pecho, cuesta respirar");
//        
//        office.setName("Hospital CIMA");
//        office.setPhone("22795122");
//        office.setDays("Lunes y Martes");
//        office.setHourStart("8:00");
//        office.setHourEnd("5:00");
//
//        patientAppointment.setOffice(office);
//        patientAppointment.setPatient(patient);
//        patientAppointment.setDate("30-01-2017");
//        patientAppointment.setHour("4:30 pm");
//
//        patientAppointment = patientService.savePatientAppointment(patientAppointment);
//        assertNotNull(patientAppointment.getIdAppointment());
//        
//        patientAppointment.setDate("01-02-2017");
//        patientService.updatePatientAppointment(patientAppointment);
//        assertThat(patientAppointment.getDate(), is("01-02-2017"));
//    }
//    
//    /**
//     *
//     */
//    @Test
//    public void testHibernateDeletePatientAppointment() {
//        patientDAO = new PatientDAOHibernateImpl();
//        patientService = new PatientServiceImpl(patientDAO);
//
//        patient = new Patient();
//        Office office = new Office();
//        PatientAppointment patientAppointment = new PatientAppointment();
//
//        patient.setUser("Carlos");
//        patient.setPassword("1234");
//        patient.setName("Carlos Gonzalez");
//        patient.setPhone("22795352");
//        patient.setAddress("Alajuela");
//        patient.setBirthday("23-12-1985");
//        patient.setAssociatedDiseases("Neumonia");
//        patient.setObservation("Fuerte dolor en el pecho, cuesta respirar");
//
//        office.setName("Hospital CIMA");
//        office.setPhone("22795122");
//        office.setDays("Lunes y Martes");
//        office.setHourStart("8:00");
//        office.setHourEnd("5:00");
//
//        patientAppointment.setOffice(office);
//        patientAppointment.setPatient(patient);
//        patientAppointment.setDate("30-01-2017");
//        patientAppointment.setHour("4:30 pm");
//
//        patientAppointment = patientService.savePatientAppointment(patientAppointment);
//        assertNotNull(patientAppointment.getIdAppointment());
//
//        patientService.deletePatientAppointment(patientAppointment.getIdAppointment());
//        assertThat(patientAppointment.getIdAppointment(), is(patientAppointment.getIdAppointment()));
//    }
}
