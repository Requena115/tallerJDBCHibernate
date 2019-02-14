package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;

import org.springframework.samples.petclinic.visit.Visit;

public class VisitDAO extends AbstractJpaDAO<Visit,Integer> implements IBaseDAO<Visit, Integer> {

	@Override
	public Visit findOne(Integer id) {
		// TODO Auto-generated method stub
		return getEntityManager().find(Visit.class, id);
	}

	@Override
	public List<Visit> findAll() {
		// TODO Auto-generated method stub
		List<Visit> res = getEntityManager().createQuery("select * from visits").getResultList();
		return res;
	}

	@Override
	public void create(Visit entity) {
		// TODO Auto-generated method stub
		getEntityManager().createQuery("insert into visits("+entity.getPetId()+","+entity.getDate()+","+entity.getDescription()+","+entity.getBill().getId()+")").executeUpdate();
	}

	@Override
	public Visit update(Visit entity) {
		// TODO Auto-generated method stub
		Integer idInteger = entity.getId();
		getEntityManager().createQuery("update Visit v where v.id= "+idInteger).executeUpdate();
		return entity;
	}

	@Override
	public void delete(Visit entity) {
		// TODO Auto-generated method stub
		getEntityManager().remove(entity);
	}

	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		getEntityManager().remove(getEntityManager().find(Visit.class, entityId));
	}

}
