package com.baobao.ssmk.service.impl;/**
 * Created by Administrator on 2018/5/23.
 */


import com.baobao.framework.utils.Md5Utility;
import com.baobao.ssmk.dao.TUserMapper;
import com.baobao.ssmk.dto.Result;
import com.baobao.ssmk.exception.BusinessExceptionEnum;
import com.baobao.ssmk.model.TUser;
import com.baobao.ssmk.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 11:42 2018/5/23
 * @Modified By:
 */
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private TUserMapper tUserMapper;
    /**
     * 登陆
     *
     * @param userName
     * @param pwd
     * @return
     */
    @Override
    public Result login(String userName, String pwd) {
        Result result = new Result();
        TUser tUser = tUserMapper.findUserByUsername(userName);
        if (Md5Utility.md5SaltString(pwd, userName).equals(tUser.getPasswd())) {
            result.setObject(tUser);
            result.setCode(BusinessExceptionEnum.SUCCESS_EXCEPTION.getCode());
            result.setMessage(BusinessExceptionEnum.SUCCESS_EXCEPTION.getMessage());
        }else{
            result.setCode(BusinessExceptionEnum.LOGIN_ERROR.getCode());
            result.setMessage(BusinessExceptionEnum.LOGIN_ERROR.getMessage());
        }
        return result;
    }
}
