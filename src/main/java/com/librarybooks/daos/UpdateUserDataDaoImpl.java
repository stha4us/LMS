package com.librarybooks.daos;

import com.librarybooks.models.UserInformation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateUserDataDaoImpl implements UpdateUserDataDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override

    public String updateUserDataDao(UserInformation userInformation){

        try{
            session=sessionFactory.openSession();
            session.update(userInformation);
            session.beginTransaction().commit();
            return "1";
        }

        catch (HibernateException e){
            e.printStackTrace();
            return "0";
        }

        finally {
            session.close();
        }

    }
}
