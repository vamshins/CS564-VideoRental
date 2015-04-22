package edu.unm.cs564.movierental.dao;

// Generated Apr 20, 2015 4:55:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.unm.cs564.movierental.model.VknsSpriden;

/**
 * Home object for domain model class VknsSpriden.
 * @see .VknsSpriden
 * @author Hibernate Tools
 */
@Repository("vknsSpridenDao")
public class VknsSpridenDaoImpl extends AbstractDao implements VknsSpridenDao{

	/*private static final Log log = LogFactory.getLog(VknsSpridenDaoImpl.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(VknsSpriden transientInstance) {
		log.debug("persisting VknsSpriden instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VknsSpriden instance) {
		log.debug("attaching dirty VknsSpriden instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VknsSpriden instance) {
		log.debug("attaching clean VknsSpriden instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VknsSpriden persistentInstance) {
		log.debug("deleting VknsSpriden instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VknsSpriden merge(VknsSpriden detachedInstance) {
		log.debug("merging VknsSpriden instance");
		try {
			VknsSpriden result = (VknsSpriden) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VknsSpriden findById(java.lang.String id) {
		log.debug("getting VknsSpriden instance with id: " + id);
		try {
			VknsSpriden instance = (VknsSpriden) sessionFactory
					.getCurrentSession().get("VknsSpriden", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VknsSpriden instance) {
		log.debug("finding VknsSpriden instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("VknsSpriden")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}*/

	public void saveSpriden(VknsSpriden employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<VknsSpriden> findAllSpridens() {
		Criteria criteria = getSession().createCriteria(VknsSpriden.class);
		System.out.println(criteria.list());
		return (List<VknsSpriden>) criteria.list();
	}

	public void deleteSpridenbyId(String id) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :id");
		query.setString("ssn", id);
		query.executeUpdate();
	}
}
