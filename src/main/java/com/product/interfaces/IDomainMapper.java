package com.product.interfaces;

import java.util.List;

public interface IDomainMapper<E, D> {
    D toDTO(final E domain);
    E toDomain(final D dto);
    List<D> toPageDTO(final List<E> items);
}
