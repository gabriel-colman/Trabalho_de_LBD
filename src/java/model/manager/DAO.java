package model.manager;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Gabriel
 */
public class DAO {

    private final SessionFactory conexao;

    private static DAO factory;

    private DAO() {
        Configuration configuration = new Configuration().configure();          // carrega mapeamentos e propriedades especificadas no hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() // define um Standard Service Registry, aplica as configurações do hibernate.cfg.xml
                .applySettings(configuration.getProperties()).build();
        conexao = configuration.buildSessionFactory(serviceRegistry);           // constrói uma session factory
    }

    public static DAO getFactory() {
        if (factory == null) {
            factory = new DAO();
        }
        return factory;
    }

    public Serializable salvar(Object objeto) {
        Serializable save = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = conexao.openSession();                    //Realiza abertura da seção criada pela conexao
            tx = session.beginTransaction();                    //Inicializa uma transação
            save = session.save(objeto.getClass().cast(objeto)); //Persisti a instância objeto
            tx.commit();                                        //Descarrega a sessão associada e termine a unidade de trabalho
        } catch (HibernateException e) {                       //Indica que ocorreu uma exceção durante uma chamada JDBC
            if (tx != null) {
                tx.rollback();                                  //Força a transação a reverter
            }
        } finally {
            try {
                session.close();                                //Destrói a sessão e libera recursos
            } catch (HibernateException e) {
                throw e;
            }
        }
        return save;
    }

    public boolean editar(Object objeto) {
        boolean sucess = true;
        Session session = null;
        Transaction tx = null;

        try {
            session = conexao.openSession();
            tx = session.beginTransaction();
            session.update(objeto.getClass().cast(objeto));     //Atualize a instância objeto persistente
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            sucess = false;
        } finally {
            try {
                session.close();
            } catch (HibernateException e) {
                throw e;
            }
        }
        return sucess;
    }

    public boolean deletar(Object objeto) {
        boolean sucess = true;
        Session session = null;
        Transaction tx = null;

        try {
            session = conexao.openSession();
            tx = session.beginTransaction();
            session.delete(objeto.getClass().cast(objeto));     //Remove a instância objeto persistente do armazenamento de dados
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            sucess = false;
        } finally {
            try {
                session.close();
            } catch (HibernateException e) {
                throw e;
            }
        }
        return sucess;
    }

    public Object buscar(Object objeto, Integer id) {
        Object retorno = null;
        Session session = null;

        try {
            session = conexao.openSession();
            retorno = session.get(objeto.getClass(), id);    //Atualiza a instância objeto persistente no armazenamento de dados
        } catch (HibernateException e) {
            throw e;
        } finally {
            try {
                session.close();
            } catch (HibernateException e) {
                throw e;
            }
        }
        return retorno;
    }

    public List listar(Object objeto) {
        List retorno = null;
        Session session = null;

        try {
            session = conexao.openSession();
            retorno = session.createQuery("from " + objeto.getClass().getName()).list();   //Cria uma instância de Query de consulta do objeto persistente no armazenamento de dados
        } catch (HibernateException e) {
            throw e;
        } finally {
            try {
                session.close();
            } catch (HibernateException e) {
                throw e;
            }
        }
        return retorno;
    }

}
