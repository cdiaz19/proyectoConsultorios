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
import una.ac.cr.consultoriobackend.model.Office;

/**
 *
 * @author cristian
 */
public class OfficeDAOHibernateImpl implements OfficeDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @param office
     * @return
     */
    @Override
    public Office saveOffice(Office office) {
        session.beginTransaction();
        session.save(office);
        session.getTransaction().commit();

        return office;
    }

    /**
     *
     * @param id_office
     * @return
     */
    @Override
    public Office findByIdOffice(int id_office) {
        Office office = null;
        Query query = session.createQuery("from Office where id_office = :id_office ");
        query.setParameter("id_office", id_office);

        if (query.list().size() > 0) {
            office = (Office) query.list().get(0);
        }

        return office;
    }

    /**
     *
     * @param office
     * @return
     */
    @Override
    public Office updateOffice(Office office) {
        session.beginTransaction();
        session.update(office);
        session.getTransaction().commit();
        return office;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteOffice(int id) {
        boolean isDeleted = false;
        Office office = null;

        session.beginTransaction();
        office = (Office) session.get(Office.class, id);
        session.delete(office);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Office> findAllOffice() {
        List<Office> office = new ArrayList<>();
        office = session.createCriteria(Office.class).list();

        return office;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Office findByNameOffice(String name) {
        Office office = null;
        Query query = session.createQuery("from office where name :name ");
        query.setParameter("name", name);

        if (query.list().size() > 0) {
            office = (Office) query.list().get(0);
        }

        return office;
    }
}
