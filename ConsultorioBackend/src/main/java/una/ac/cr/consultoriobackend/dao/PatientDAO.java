/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.dao;

import java.util.List;
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.model.Appointment;

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
    public Appointment savePatientAppointment(Appointment patientAppointment);

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
    public Appointment findByIdPatientAppointment(int id);

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
    public Appointment updatePatientAppointment(Appointment patientAppointment);

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
    public  List<Appointment> findAllPatientAppointment();
}
