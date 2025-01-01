package com.yildiz.dao;

import com.yildiz.model.Agent;
import com.yildiz.util.HibernateUtil;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AgentDAO {
    // JPA--Hibernate ---> Save    Get    Update    Delete
    // DB CRUD     ------> Creat   Read   Update    Delete
    // DB SQL      ------> Insert  Select Update    Delete
/*
    public void saveAgent(Agent agent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(agent);


            tx.commit();
        }catch (HibernateError e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("HibernateError" + e.getMessage());
        }finally {
            session.close();
        }
    }

    public void updateAgnet(Agent agent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(agent);


            tx.commit();
        }catch (HibernateError e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("HibernateError" + e.getMessage());
        }finally {
            session.close();
        }
    }
 */
    // yukarda ayrı ayrı yaptığımız metodalrı tek bir metodda birleştirebilirsin

    public void saveOrUpdateAgent(Agent agent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(agent);


            tx.commit();
        }catch (HibernateError e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("HibernateError" + e.getMessage());
        }finally {
            session.close();
        }
    }

    public Agent getAgentFindById(Long id){

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return  session.get(Agent.class, id);
        } catch (HibernateError e) {
            System.out.println("HibernateError : " + e.getMessage());
            return null;
        } finally {
            session.close();
        }

    }

    public List<Agent> getAgentFindAll(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return  session.createQuery("from Agent").list();

        } catch (HibernateError e) {
            System.out.println("HibernateError : " + e.getMessage());
            return null;
        } finally {
            session.close();
        }

    }

    public boolean deleteAgentFindById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Agent agent = session.get(Agent.class, id);

            if (agent != null) {
                session.delete(agent);
                System.out.println("Agent deleted");
                transaction.commit();
                return true;
            } else {
                System.out.println("Agent not found");
                return false;
            }

        } catch (HibernateError e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println("HibernateError : " + e.getMessage());
            return false;
        } finally {
            session.close();
        }


    }

}
