package com.webank.wsdaw.safebox.dao.entity;

import com.webank.wsdaw.safebox.aspect.Encrypt;
import com.webank.wsdaw.safebox.aspect.Encrypted;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MnemonicEntity implements Encrypted {

    private Long pkId;
    @Encrypt private String userId;
    private int keyType;
    private String encryptMn;
    private Date createTime;
    private Date updateTime;
}
