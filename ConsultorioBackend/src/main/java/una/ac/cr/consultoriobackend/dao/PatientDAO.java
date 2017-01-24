/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.dao;

import una.ac.cr.consultoriobackend.model.Patient;

/**
 *
 * @author cristian
 */
public interface PatientDAO {
    
    public Patient savePatient(Patient patient);
    
}
