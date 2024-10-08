package com.webank.wsdaw.safebox.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author grayson
 * @description TODO
 * @date 2023-11-09 23:16
 */
@AllArgsConstructor
@Getter
public enum CodeEnum {
    // 0-request success
    TRANSACTION_SUCCESS(0, "操作成功"),

    // 1000-1999: params validate error

    // 2000-2999: config

    // 3000-3999: kyc

    USER_MNEM_EXIST(3000, "用户助记词已存在"),

    USER_MNEM_NOT_EXIST(3001, "用户助记词不存在"),

    // 6000-6999: db error

    // 7000-7999: third service error
    // other error

    // 9000-9998: system error
    // 9999-unknown error
    UNKNOWN_ERROR(9999, "系统错误");

    private final int code;
    private final String msg;

    public static CodeEnum getCodeEnum(int code) {
        for (CodeEnum type : CodeEnum.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return UNKNOWN_ERROR;
    }
}
