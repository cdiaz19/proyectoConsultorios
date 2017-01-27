/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.service;

import java.util.List;
import una.ac.cr.consultoriobackend.model.Office;

/**
 *
 * @author cristian
 */
public interface OfficeService {

    public Office saveOffice(Office office);

    public Office findByIdOffice(int id);

    public Office findByNameOffice(String name);

    public Office updateOffice(Office office);

    public boolean deleteOffice(int id);

    public List<Office> findAllOffice();

}
