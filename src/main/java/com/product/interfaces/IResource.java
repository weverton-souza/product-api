package com.product.interfaces;

import com.product.abstracts.AbstractDataTransferObject;
import com.product.generic.GenericResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface IResource<D extends AbstractDataTransferObject, K extends Serializable> {
        GenericResponse save(final D resource);
        GenericResponse update(final D resource);
        GenericResponse findById(final K id) throws Exception;
        Page<IDataTransferObject> findAll(final Pageable pageable);
        void delete(K id) throws Exception;
}
