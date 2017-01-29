/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.model.PatientAppointment;

/**
 *
 * @author cristian
 */
public class PatientDAOHibernateImpl implements PatientDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @param patient
     * @return
     */
    @Override
    public Patient savePatient(Patient patient) {
        session.beginTransaction();
        session.save(patient);
        session.getTransaction().commit();

        return patient;
    }

    /**
     *
     * @param id_patient
     * @return
     */
    @Override
    public Patient findByIdPatient(int id_patient) {
        Patient patient = null;
        Query query = session.createQuery("from Patient where id_patient = :id_patient ");
        query.setParameter("id_patient", id_patient);

        if (query.list().size() > 0) {
            patient = (Patient) query.list().get(0);
        }

        return patient;
    }


    /**
     *
     * @param patient
     * @return
     */
    @Override
    public Patient updatePatient(Patient patient) {
        session.beginTransaction();
        session.update(patient);
        session.getTransaction().commit();
        
        return patient;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean deletePatient(int id) {
        boolean isDeleted = false;
        Patient patient = null;

        session.beginTransaction();
        patient = (Patient) session.get(Patient.class, id);
        session.delete(patient);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Patient> findAllPatient() {
        List<Patient> patient = new ArrayList<>();
        patient = session.createCriteria(Patient.class).list();

        return patient;
    }

    /**
     *
     * @param patientAppointment
     * @return
     */
    @Override
    public PatientAppointment savePatientAppointment(PatientAppointment patientAppointment) {
        session.beginTransaction();
        session.save(patientAppointment);
        session.getTransaction().commit();

        return patientAppointment;
    }

    /**
     *
     * @param id_appointment
     * @return
     */
    @Override
    public PatientAppointment findByIdPatientAppointment(int id_appointment) {
        PatientAppointment patientAppointment = null;
        Query query = session.createQuery("from appointment where id_appointment = :id_appointment ");
        query.setParameter("id_appointment", id_appointment);

        if (query.list().size() > 0) {
            patientAppointment = (PatientAppointment) query.list().get(0);
        }

        return patientAppointment;
    }

    /**
     *
     * @param patientAppointment
     * @return
     */
    @Override
    public PatientAppointment updatePatientAppointment(PatientAppointment patientAppointment) {
        session.beginTransaction();
        session.update(patientAppointment);
        session.getTransaction().commit();
        return patientAppointment;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean deletePatientAppointment(int id) {
        boolean isDeleted = false;
        PatientAppointment appointment = null;

        session.beginTransaction();
        appointment = (PatientAppointment) session.get(PatientAppointment.class, id);
        session.delete(appointment);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }

    /**
     *
     * @return
     */
    @Override
    public List<PatientAppointment> findAllPatientAppointment() {
        List<PatientAppointment> patientAppointment = new ArrayList<>();
        patientAppointment = session.createCriteria(PatientAppointment.class).list();

        return patientAppointment;
    }
}
