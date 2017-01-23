/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.dao;

import org.hibernate.Query;
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

    @Override
    public Office findByIdOffice(int id) {
        Office office = null;
        Query query = session.createQuery("from office where id = :id ");
        query.setParameter("id", id);

        if (query.list().size() > 0) {
            office = (Office) query.list().get(0);
        }

        return office;
    }

    @Override
    public void updateOffice(Office office) {
        session.beginTransaction();
        session.update(office);
        session.getTransaction().commit();
    }

    @Override
    public void deleteOffice(Office office) {
        session.beginTransaction();
        session.delete(office);
        session.getTransaction().commit();
    }

}
