package com.product.abstracts;

import com.product.interfaces.IDataTransferObject;
import java.util.Objects;

public abstract class AbstractDataTransferObject implements IDataTransferObject {
    protected String id;

    public String getId() {
        return id;
    }

    public IDataTransferObject setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IDataTransferObject that = (IDataTransferObject) o;
        return Objects.equals(id, that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}