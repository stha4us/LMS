package com.librarybooks.daos;

import com.librarybooks.models.UserInformation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class DeleteUserDataDaoImpl implements DeleteUserDataDao  {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public String deleteUserData(UserInformation userInformation){
        try{
            session=sessionFactory.openSession();
            session.delete(userInformation);
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
