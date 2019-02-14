package org.springframework.samples.petclinic.persistence.dao;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.stereotype.Repository;
@Repository
public class PetDAO extends AbstractJpaDAO<Pet,Integer> implements IBaseDAO<Pet, Integer> {
	
	  public PetDAO() {
	        super();
	        setClazz(Pet.class);
	    }

}
