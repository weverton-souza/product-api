package com.product.interfaces;

import java.io.Serializable;

public interface IDataTransferObject extends Serializable {
    Object setId(final String id);
    String getId();
}
