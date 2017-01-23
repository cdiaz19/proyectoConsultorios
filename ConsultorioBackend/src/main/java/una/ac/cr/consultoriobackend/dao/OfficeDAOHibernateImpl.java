/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.dao;

import org.hibernate.Session;
import una.ac.cr.consultoriobackend.model.Office;

/**
 *
 * @author cristian
 */
public class OfficeDAOHibernateImpl implements OfficeDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Office saveOffice(Office office) {
        session.beginTransaction();
        session.save(office);
        session.getTransaction().commit();

        return office;
    }

}
