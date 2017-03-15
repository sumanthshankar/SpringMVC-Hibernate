package springmvc.model.dao.jpa;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.*;
import springmvc.model.dao.*;

@Repository
public class ApplicationDaoImpl implements ApplicationDao{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Applications getApplicationByID(int id)
	{
		return entityManager.find(Applications.class, id);
	}
	
	@Override
	public List<Applications> getApplicationsPerDepartment(String department) {
		
		return entityManager.createQuery("select a from Applications a"
				+ " where a.program = (select p from Programs p where p.department.name='"+department+"') and a.term='Fall 2016')",Applications.class ).getResultList();
		
	}

	
	@Override
	public List<Applications> getApplicationsForStudent(String studentEmail) {
		
		return entityManager.createQuery("select a from Applications a"
				+ " where a.studentInfomration.email = '"+studentEmail+"')",Applications.class ).getResultList();
		
	}


	@Transactional
	@Override
	public Applications saveApplication(Applications application) {
		// TODO Auto-generated method stub
		return entityManager.merge(application);
	}
	

}
