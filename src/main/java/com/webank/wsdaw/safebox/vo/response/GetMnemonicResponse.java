package com.webank.wsdaw.safebox.vo.response;

import java.util.Date;
import lombok.Data;

@Data
public class GetMnemonicResponse {
    private String encryptMn;
    private Date createTime;
    private Date updateTime;
}
