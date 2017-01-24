/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.service;

import java.util.List;
import una.ac.cr.consultoriobackend.dao.OfficeDAO;
import una.ac.cr.consultoriobackend.model.Office;

/**
 *
 * @author cristian
 */
public class OfficeServiceImpl implements OfficeService {

    private OfficeDAO officeDAO;

    public OfficeServiceImpl() {
    }

    public OfficeServiceImpl(OfficeDAO officeDAO) {
        this.officeDAO = officeDAO;
    }

    @Override
    public Office saveOffice(Office office) {
        return officeDAO.saveOffice(office);
    }

    @Override
    public Office findByIdOffice(int id) {
        return officeDAO.findByIdOffice(id);
    }

    @Override
    public void updateOffice(Office office) {
        officeDAO.updateOffice(office);
    }

    @Override
    public void deleteOffice(Office office) {
        officeDAO.deleteOffice(office);
    }

    @Override
    public Office findByNameOffice(String name) {
        return officeDAO.findByNameOffice(name);
    }

    @Override
    public List<Office> findAllOffice() {
        return officeDAO.findAllOffice();
    }
}
