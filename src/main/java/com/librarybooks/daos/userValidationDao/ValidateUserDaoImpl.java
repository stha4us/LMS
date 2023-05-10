package com.librarybooks.daos.userValidationDao;

import com.librarybooks.models.LoginCredentialsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ValidateUserDaoImpl implements ValidateUserDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List validateUser (LoginCredentialsEntity loginCredentialsEntity){

        try{
            session=sessionFactory.openSession();
            System.out.println("Inside dao");
            System.out.println(loginCredentialsEntity.getUsername());
            System.out.println(loginCredentialsEntity.getPassword());
            String sql="SELECT * FROM login_credentials lc WHERE lc.username=:userName and lc.password=:passWord";
            NativeQuery query=session.createNativeQuery(sql);
            query.setParameter("userName",loginCredentialsEntity.getUsername());
            query.setParameter("passWord",loginCredentialsEntity.getPassword());
            query.addScalar("username", StringType.INSTANCE);
            query.addScalar("password", StringType.INSTANCE);
            return query.list();
        }
        catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    }
}

