package com.inho.security.domain.common;

public enum Status {
    SUCCESS(true),
    FAIL(false);

    private boolean status;

    Status(boolean status) {
        this.status = status;
    }

    public boolean value() {
        return this.status;
    }
}
