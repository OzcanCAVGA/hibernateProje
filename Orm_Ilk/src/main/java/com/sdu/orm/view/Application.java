package com.sdu.orm.view;

import com.sdu.orm.entity.Student;
import com.sdu.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Application {

    public static void main(String[] args) {

        Student std1 = new Student("Ali", "Al", "a@b.com");
        Student std2 = new Student("Veli", "Git", "c@d.com");

        Transaction transaction = null;
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.persist(std1);
            session.persist(std2);
            transaction.commit();
            
        }
        catch(Exception ex){
            if(transaction!=null){
                transaction.rollback();
                ex.printStackTrace();
            }
            
            
        }
    }

}
