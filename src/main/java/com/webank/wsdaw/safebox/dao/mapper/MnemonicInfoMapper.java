package com.webank.wsdaw.safebox.dao.mapper;

import com.webank.wsdaw.safebox.dao.entity.MnemonicEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface MnemonicInfoMapper {

    @Insert(
            "INSERT INTO t_mnemonic_info (user_id,key_type,encrypt_mn) "
                    + "VALUES (#{userId},#{keyType},#{encryptMn})")
    @Options(useGeneratedKeys = true, keyProperty = "pkId", keyColumn = "pk_id")
    void insertMnemonicInfo(MnemonicEntity mnemonicEntity);

    @Delete("DELETE FROM t_mnemonic_info WHERE pk_id = #{pkId}")
    void deleteByUserId(long pkId);

    @Select("SELECT * FROM t_mnemonic_info WHERE user_id = #{userId}")
    MnemonicEntity getMnemonicByUserId(MnemonicEntity entity);
}
