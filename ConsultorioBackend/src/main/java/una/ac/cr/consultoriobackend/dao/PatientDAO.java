/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.dao;

import java.util.List;
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.model.PatientAppointment;

/**
 *
 * @author cristian
 */
public interface PatientDAO {

    /**
     *
     * @param patient
     * @return
     */
    public Patient savePatient(Patient patient);

    /**
     *
     * @param patientAppointment
     * @return
     */
    public PatientAppointment savePatientAppointment(PatientAppointment patientAppointment);

    /**
     *
     * @param id
     * @return
     */
    public Patient findByIdPatient(int id);

    /**
     *
     * @param id
     * @return
     */
    public PatientAppointment findByIdPatientAppointment(int id);

    /**
     *
     * @param name
     * @return
     */
    public Patient findByNamePatient(String name);

    /**
     *
     * @param patient
     * @return
     */
    public Patient updatePatient(Patient patient);

    /**
     *
     * @param patientAppointment
     * @return
     */
    public PatientAppointment updatePatientAppointment(PatientAppointment patientAppointment);

    /**
     *
     * @param id
     * @return
     */
    public boolean deletePatient(int id);

    /**
     *
     * @param id
     * @return
     */
    public boolean deletePatientAppointment(int id);

    /**
     *
     * @return
     */
    public List<Patient> findAllPatient();

    /**
     *
     * @return
     */
    public List<PatientAppointment> findAllPatientAppointment();

}
