/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.dao;

import org.hibernate.Session;
import una.ac.cr.consultoriobackend.model.Patient;

/**
 *
 * @author cristian
 */
public class PatientDAOHibernateImpl implements PatientDAO {
    
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Patient savePatient(Patient patient) {
        session.beginTransaction();
        session.save(patient);
        session.getTransaction().commit();

        return patient;
    }

}
