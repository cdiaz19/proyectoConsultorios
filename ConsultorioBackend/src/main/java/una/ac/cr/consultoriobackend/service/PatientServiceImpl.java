/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.service;

import una.ac.cr.consultoriobackend.dao.PatientDAO;
import una.ac.cr.consultoriobackend.model.Patient;

/**
 *
 * @author cristian
 */
public class PatientServiceImpl implements PatientService {

    private PatientDAO patientDAO;

    public PatientServiceImpl() {
    }

    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientDAO.savePatient(patient);
    }
    
}
