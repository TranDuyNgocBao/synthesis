/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19_vaccine_management;

import data_structure.Hospital;
import data_structure.Injection;

/**
 *
 * @author ADMIN
 */
public interface I_operation_list {
    void addin();
    void updatenew();
    void showAll();
    void deleteold();
    void searchfor();
    void readInject();
    void writeInject();
    void infoEncrypt();
}
