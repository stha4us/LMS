package com.librarybooks.daos;

import com.librarybooks.models.UserInformation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InsertUserInfoDaoImpl implements InsertUserInfoDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;


    public String insertUserInfo (UserInformation userInfo){

        try{
            session=sessionFactory.openSession();
            session.save(userInfo);
            session.beginTransaction().commit();
            return "1";
        }

        catch (HibernateException e){
            return "0";
        }

        finally {
            session.close();
        }

    }

}
