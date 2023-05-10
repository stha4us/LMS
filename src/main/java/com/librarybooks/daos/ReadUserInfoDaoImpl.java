package com.librarybooks.daos;

import com.librarybooks.models.UserInformation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ReadUserInfoDaoImpl implements ReadUserInfoDao {

    @Autowired
    SessionFactory sessionFactory;
    Session session;
    @Override
    public List<UserInformation> getUserInfo() {
        try {
            session=sessionFactory.openSession();

            CriteriaBuilder builder=session.getCriteriaBuilder();
            CriteriaQuery <UserInformation> criteria=builder.createQuery(UserInformation.class);
            criteria.from(UserInformation.class);

            List <UserInformation> results=session.createQuery(criteria).list();

            return results;
        }

        catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
        finally {
            session.close();
        }
    }
}
