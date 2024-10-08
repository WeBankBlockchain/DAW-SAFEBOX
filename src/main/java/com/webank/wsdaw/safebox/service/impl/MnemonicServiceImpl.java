package com.webank.wsdaw.safebox.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.webank.wsdaw.safebox.dao.entity.MnemonicEntity;
import com.webank.wsdaw.safebox.dao.mapper.MnemonicInfoMapper;
import com.webank.wsdaw.safebox.enums.CodeEnum;
import com.webank.wsdaw.safebox.service.MnemonicService;
import com.webank.wsdaw.safebox.vo.request.GetMnemonicRequest;
import com.webank.wsdaw.safebox.vo.request.SaveMnemonicInfoRequest;
import com.webank.wsdaw.safebox.vo.response.CommonResponse;
import com.webank.wsdaw.safebox.vo.response.GetMnemonicResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MnemonicServiceImpl implements MnemonicService {

    @Autowired private MnemonicInfoMapper mnemonicInfoMapper;

    @Override
    public CommonResponse<String> saveMnemonicInfo(SaveMnemonicInfoRequest request) {
        MnemonicEntity entity = new MnemonicEntity();
        entity.setUserId(request.getUserId());
        MnemonicEntity mnEntity = mnemonicInfoMapper.getMnemonicByUserId(entity);
        if (mnEntity != null) {
            return CommonResponse.error(CodeEnum.USER_MNEM_EXIST);
        }

        MnemonicEntity mnemonicEntity = new MnemonicEntity();
        BeanUtil.copyProperties(request, mnemonicEntity);
        mnemonicInfoMapper.insertMnemonicInfo(mnemonicEntity);
        return CommonResponse.success();
    }

    @Override
    public CommonResponse<GetMnemonicResponse> getMnemonicByUserId(GetMnemonicRequest request) {
        MnemonicEntity entity = new MnemonicEntity();
        entity.setUserId(request.getUserId());
        MnemonicEntity mnemonicEntity = mnemonicInfoMapper.getMnemonicByUserId(entity);
        if (mnemonicEntity == null) {
            return CommonResponse.error(CodeEnum.USER_MNEM_NOT_EXIST);
        }

        GetMnemonicResponse response = new GetMnemonicResponse();
        BeanUtil.copyProperties(mnemonicEntity, response, false);

        return CommonResponse.success(response);
    }
}
