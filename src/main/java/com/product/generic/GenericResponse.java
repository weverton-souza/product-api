package com.product.generic;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public class GenericResponse<E> {
    private E content;
    private Integer code;
    private HttpStatus status;
    private String description;

    public GenericResponse() {
    }

    public GenericResponse(@Nullable final E content, final Integer code, final HttpStatus status,
                           final String Description) {
        this.content = content;
        this.code = code;
        this.status = status;
        this.description = Description;
    }

    public E getContent() {
        return content;
    }


    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status.name();
    }


    public String getDescription() {
        return description;
    }


    public GenericResponseBuilder Builder() {
        return new GenericResponseBuilder<E>();
    }


    public static final class GenericResponseBuilder<E> {
        private E content;
        private Integer code;
        private HttpStatus status;
        private String description;

        private GenericResponseBuilder() {
        }

        public GenericResponseBuilder content(E content) {
            this.content = content;
            return this;
        }

        public GenericResponseBuilder code(Integer code) {
            this.code = code;
            return this;
        }

        public GenericResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public GenericResponseBuilder Description(String Description) {
            this.description = Description;
            return this;
        }

        public GenericResponse build() {
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.content = (content);
            genericResponse.code = (code);
            genericResponse.status = (status);
            genericResponse.description = (description);
            return genericResponse;
        }
    }
}
