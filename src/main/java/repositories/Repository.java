/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author sonpt_ph19600
 */

public abstract class Repository {
    
    public static Session session;
    public static Transaction trans;   

    public void openTranSaction() {
        session = HibernateUtil.getFACTORY().openSession();
        trans = session.beginTransaction();
    }


    public void commitTranSaction() {
        trans.commit();
        session.close();
    }

}
