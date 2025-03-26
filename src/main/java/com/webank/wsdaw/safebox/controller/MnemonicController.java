package com.webank.wsdaw.safebox.controller;

import com.webank.wsdaw.safebox.service.MnemonicService;
import com.webank.wsdaw.safebox.vo.request.GetMnemonicRequest;
import com.webank.wsdaw.safebox.vo.request.SaveMnemonicInfoRequest;
import com.webank.wsdaw.safebox.vo.response.CommonResponse;
import com.webank.wsdaw.safebox.vo.response.GetMnemonicResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class MnemonicController {
    @Autowired private MnemonicService accountService;

    @PostMapping("getMnemonicByUserId")
    public CommonResponse<GetMnemonicResponse> getMnemonicByUserId(
            @RequestBody @Valid GetMnemonicRequest request) {
        return accountService.getMnemonicByUserId(request);
    }

    @PostMapping("saveMnemonicInfo")
    public CommonResponse<String> saveMnemonicInfo(
            @RequestBody @Valid SaveMnemonicInfoRequest request) {
        return accountService.saveMnemonicInfo(request);
    }
}
