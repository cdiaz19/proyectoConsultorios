/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.service;

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
    
}
