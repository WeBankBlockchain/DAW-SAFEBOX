package com.webank.wsdaw.safebox.vo.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SaveMnemonicInfoRequest extends CommonRequest {

    @NotBlank(message = "userId不能为空.")
    private String userId;

    private int keyType;

    @NotBlank(message = "encryptMn.")
    private String encryptMn;
}
