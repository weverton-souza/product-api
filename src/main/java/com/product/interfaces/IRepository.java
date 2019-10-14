package com.product.interfaces;

import com.product.abstracts.AbstractDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository<E extends AbstractDomain, K> extends MongoRepository<E, K> {
}
