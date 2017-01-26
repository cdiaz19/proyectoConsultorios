/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.service;

import java.util.List;
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.model.PatientAppointment;

/**
 *
 * @author cristian
 */
public interface PatientService {
    
    public Patient savePatient(Patient patient);
    
    public PatientAppointment savePatientAppointment(PatientAppointment patientAppointment);
    
    public Patient findByIdPatient(int id);
    
    public PatientAppointment findByIdPatientAppointment(int id);

    public Patient findByNamePatient(String name);

    public void updatePatient(Patient patient);
    
    public void updatePatientAppointment(PatientAppointment patientAppointment);

    public void deletePatient(Patient patient);
    
    public void deletePatientAppointment(PatientAppointment patientAppointment);

    public List<Patient> findAllPatient();
    
    public List<PatientAppointment> findAllPatientAppointment();
    
}