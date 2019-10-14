package com.product.interfaces;

import com.product.abstracts.AbstractDataTransferObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface IService<D extends AbstractDataTransferObject, K extends Serializable> {
    IDataTransferObject saveOrUpdate(final D resource);
    IDataTransferObject findById(final K id) throws Exception;
    Page<IDataTransferObject> findAll(final Pageable pageable);
    void delete(K id) throws Exception;
}
