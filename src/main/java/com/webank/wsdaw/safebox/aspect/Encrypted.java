package com.webank.wsdaw.safebox.aspect;

public interface Encrypted {
    default String[] getEncryptFields() {
        return new String[0];
    }
}
