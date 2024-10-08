package com.webank.wsdaw.safebox.vo.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetMnemonicRequest extends CommonRequest {
    @NotBlank(message = "userId不能为空.")
    private String userId;
}
