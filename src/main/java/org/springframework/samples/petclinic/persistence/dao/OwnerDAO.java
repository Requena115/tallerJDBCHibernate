package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;

import org.springframework.samples.petclinic.owner.Owner;

public class OwnerDAO extends AbstractJpaDAO<Owner,Integer> implements IBaseDAO<Owner, Integer> {

	@Override
	public Owner findOne(Integer id) {
		// TODO Auto-generated method stub
		return getEntityManager().find(Owner.class, id);
	}

	@Override
	public List<Owner> findAll() {
		// TODO Auto-generated method stub
		List<Owner> res = getEntityManager().createQuery("select * from owners").getResultList();
		return res;
	}

	@Override
	public void create(Owner entity) {
		// TODO Auto-generated method stub
		getEntityManager().createQuery("insert into owners("+entity.getFirstName()+","+entity.getLastName()+","+entity.getAddress()+","+entity.getCity()+","+entity.getTelephone()+","+entity.getAccount()+")").executeUpdate();
	}

	@Override
	public Owner update(Owner entity) {
		// TODO Auto-generated method stub
		Integer idInteger = entity.getId();
		getEntityManager().createQuery("update Owner o where o.id= "+idInteger).executeUpdate();
		return entity;
	}

	@Override
	public void delete(Owner entity) {
		// TODO Auto-generated method stub
		getEntityManager().remove(entity);
	}

	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		getEntityManager().remove(getEntityManager().find(Owner.class, entityId));
	}

}
