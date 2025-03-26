package com.webank.wsdaw.safebox.service;

import com.webank.wsdaw.safebox.vo.request.GetMnemonicRequest;
import com.webank.wsdaw.safebox.vo.request.SaveMnemonicInfoRequest;
import com.webank.wsdaw.safebox.vo.response.CommonResponse;
import com.webank.wsdaw.safebox.vo.response.GetMnemonicResponse;

public interface MnemonicService {

    public CommonResponse<String> saveMnemonicInfo(SaveMnemonicInfoRequest request);

    public CommonResponse<GetMnemonicResponse> getMnemonicByUserId(GetMnemonicRequest request);
}
