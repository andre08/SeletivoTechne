package com.seletivotechne.dao;

import com.seletivotechne.model.Pessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andre ulisses
 */
public class PessoaDao {

    public boolean save(Pessoa pessoa) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.getTransaction().begin();
        s.saveOrUpdate(pessoa);
        s.getTransaction().commit();
        s.close();
        return true;
    }

    public List<Pessoa> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Query query = session.createQuery("FROM Pessoa");
        List<Pessoa> lista = query.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    public Pessoa getById(Integer id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.getTransaction().begin();
        Pessoa curso = (Pessoa) s.get(Pessoa.class, id);
        s.getTransaction().commit();
        s.close();
        return curso;
    }

    public boolean delete(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(pessoa);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
