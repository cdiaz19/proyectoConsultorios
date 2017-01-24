/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.service;

import java.util.List;
import una.ac.cr.consultoriobackend.model.Patient;

/**
 *
 * @author cristian
 */
public interface PatientService {
    
    public Patient savePatient(Patient patient);
    
    public Patient findByIdPatient(int id);

    public Patient findByNamePatient(String name);

    public void updatePatient(Patient patient);

    public void deletePatient(Patient patient);

    public List<Patient> findAllPatient();
    
}
