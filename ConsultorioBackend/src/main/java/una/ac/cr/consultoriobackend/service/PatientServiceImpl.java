/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.service;

import java.util.List;
import una.ac.cr.consultoriobackend.dao.PatientDAO;
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.model.PatientAppointment;

/**
 *
 * @author cristian
 */
public class PatientServiceImpl implements PatientService {

    private PatientDAO patientDAO;

    /**
     *
     */
    public PatientServiceImpl() {
    }

    /**
     *
     * @param patientDAO
     */
    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientDAO.savePatient(patient);
    }

    @Override
    public Patient findByIdPatient(int id) {
        return patientDAO.findByIdPatient(id);
    }

    @Override
    public Patient findByNamePatient(String name) {
        return patientDAO.findByNamePatient(name);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientDAO.updatePatient(patient);
    }

    @Override
    public boolean deletePatient(int id) {
        return patientDAO.deletePatient(id);
    }

    @Override
    public List<Patient> findAllPatient() {
        return patientDAO.findAllPatient();
    }

    @Override
    public PatientAppointment savePatientAppointment(PatientAppointment patientAppointment) {
        return patientDAO.savePatientAppointment(patientAppointment);
    }

    @Override
    public PatientAppointment findByIdPatientAppointment(int id) {
        return patientDAO.findByIdPatientAppointment(id);
    }

    @Override
    public PatientAppointment updatePatientAppointment(PatientAppointment patientAppointment) {
        return patientDAO.updatePatientAppointment(patientAppointment);
    }

    @Override
    public boolean deletePatientAppointment(int id) {
        return patientDAO.deletePatientAppointment(id);
    }

    @Override
    public List<PatientAppointment> findAllPatientAppointment() {
        return patientDAO.findAllPatientAppointment();
    }
}
