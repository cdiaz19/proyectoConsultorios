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

    public PatientServiceImpl() {
    }

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
    public void updatePatient(Patient patient) {
        patientDAO.updatePatient(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientDAO.deletePatient(patient);
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
    public void updatePatientAppointment(PatientAppointment patientAppointment) {
        patientDAO.updatePatientAppointment(patientAppointment);
    }

    @Override
    public void deletePatientAppointment(PatientAppointment patientAppointment) {
        patientDAO.deletePatientAppointment(patientAppointment);
    }

    @Override
    public List<PatientAppointment> findAllPatientAppointment() {
        return patientDAO.findAllPatientAppointment();
    }
}
