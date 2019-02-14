package org.springframework.samples.petclinic.persistence.dao;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Repository;
@Repository
public class OwnerDAO extends AbstractJpaDAO<Owner,Integer> implements IBaseDAO<Owner, Integer> {
	public OwnerDAO() {
	        super();

	        setClazz(Owner.class);
	    }
}
