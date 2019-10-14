package com.product.interfaces;

import java.io.Serializable;
import java.util.UUID;

public interface IDomain extends Serializable {
    Object setId(final String id);
    String getId();
}

