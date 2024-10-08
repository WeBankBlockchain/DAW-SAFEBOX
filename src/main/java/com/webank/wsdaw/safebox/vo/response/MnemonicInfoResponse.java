package com.webank.wsdaw.safebox.vo.response;

import java.util.Date;
import lombok.Data;

@Data
public class MnemonicInfoResponse {

    private String userId;
    private int keyType;
    private String encryptMn;
    private Date createTime;
}
