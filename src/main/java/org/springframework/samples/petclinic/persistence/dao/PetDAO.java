package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;

import org.springframework.samples.petclinic.owner.Pet;

public class PetDAO extends AbstractJpaDAO<Pet,Integer> implements IBaseDAO<Pet, Integer> {

	@Override
	public Pet findOne(Integer id) {
		// TODO Auto-generated method stub
		return getEntityManager().find(Pet.class, id);
	}

	@Override
	public List<Pet> findAll() {
		// TODO Auto-generated method stub
		List<Pet> res = getEntityManager().createQuery("select * from pets").getResultList();
		return res;
	}

	@Override
	public void create(Pet entity) {
		// TODO Auto-generated method stub
		getEntityManager().createQuery("insert into pets("+entity.getName()+","+entity.getBirthDate()+","+entity.getType().getId()+","+entity.getOwner().getId()+")").executeUpdate();
	}

	@Override
	public Pet update(Pet entity) {
		// TODO Auto-generated method stub
		Integer idInteger = entity.getId();
		getEntityManager().createQuery("update Pet p where p.id= "+idInteger).executeUpdate();
		return entity;
	}

	@Override
	public void delete(Pet entity) {
		// TODO Auto-generated method stub
		getEntityManager().remove(entity);
	}

	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		getEntityManager().remove(getEntityManager().find(Pet.class, entityId));
	}

}
