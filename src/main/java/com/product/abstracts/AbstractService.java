package com.product.abstracts;

import com.product.interfaces.IDataTransferObject;
import com.product.interfaces.IDomainMapper;
import com.product.interfaces.IRepository;
import com.product.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractService<D extends AbstractDataTransferObject, K extends Serializable>
        implements IService<D, K> {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    protected IRepository repository;
    protected final IDomainMapper mapper;

    protected AbstractService(final IRepository repository, final IDomainMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IDataTransferObject saveOrUpdate(D dto) {
        return (IDataTransferObject) this.mapper.toDTO(this.repository.save(this.mapper.toDomain(dto)));
    }

    @Override
    @SuppressWarnings("unchecked")
    public IDataTransferObject findById(K id) throws Exception {
        Optional<IDataTransferObject> optionalResource = this.repository.findById(id);
        return (IDataTransferObject) this.mapper.toDTO(optionalResource.orElseThrow(Exception::new));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Page<IDataTransferObject> findAll(Pageable pageable) {
        return this.repository
                .findAll(pageable).map(this.mapper::toDTO);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete(K id) throws Exception {
        Optional<IDataTransferObject> optionalResource = this.repository.findById(id);
        this.repository.delete(optionalResource.orElseThrow(Exception::new));
    }
}
