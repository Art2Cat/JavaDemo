package com.art2cat.dev.database.hibernate;

import com.art2cat.dev.database.Vendor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class HibernateRepository {
    
    private final SessionFactory sessionFactory;
    
    public HibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    public Integer count() {
        return findAll().size();
    }
    
    public Vendor save(Vendor vendor) {
        Serializable id = currentSession().save(vendor);
        
        return new Vendor((Long) id,
            vendor.getName(),
            vendor.getAddress(),
            vendor.getCity(),
            vendor.getState(),
            vendor.getZip(),
            vendor.getCountry());
    }
    
    public Vendor findOne(long id) {
        return (Vendor) currentSession().get(Vendor.class, id);
    }
    
    public Vendor findByName(String name) {
        return (Vendor) currentSession()
            .createQuery(name, Vendor.class)
            .list()
            .get(0);
    }
    
    private List<Vendor> findAll() {
        return (List<Vendor>) currentSession().createCriteria(Vendor.class).list();
    }
}
