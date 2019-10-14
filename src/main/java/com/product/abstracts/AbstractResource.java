package com.product.abstracts;


import com.product.generic.GenericResponse;
import com.product.interfaces.IDataTransferObject;
import com.product.interfaces.IResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

public abstract class AbstractResource<T extends AbstractDataTransferObject, K extends Serializable>
        implements IResource<T, K> {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    protected final AbstractService<T, K> service;

    protected AbstractResource(AbstractService<T, K> service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public GenericResponse<?> save(@Valid @RequestBody T resource) {
        IDataTransferObject dataTransferObject = service.saveOrUpdate(resource);

        return  new GenericResponse<>(
                dataTransferObject,
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                HttpStatus.CREATED.getReasonPhrase());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse update(@Valid @RequestBody T resource) {
        IDataTransferObject dataTransferObject = this.service.saveOrUpdate(resource);

        return new GenericResponse<>(
                dataTransferObject,
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                HttpStatus.CREATED.getReasonPhrase());
    }

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse findById(@PathVariable K id) throws Exception {
        IDataTransferObject dataTransferObject = this.service.findById(id);

        return new GenericResponse<>(
                dataTransferObject,
                HttpStatus.OK.value(),
                HttpStatus.OK,
                HttpStatus.OK.getReasonPhrase());
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<IDataTransferObject> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable K id) throws Exception {
        this.service.delete(id);
    }
}
