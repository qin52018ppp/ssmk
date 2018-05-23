package com.baobao.ssmk.service;/**
 * Created by Administrator on 2018/1/26.
 */



import com.baobao.ssmk.dto.Result;
import com.baobao.ssmk.dto.TUserReq;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 12:24 2018/1/26
 * @Modified By:
 */
public interface ILoginService {
    /**
     * 登陆
     * @param userName
     * @param pwd
     * @return
     */
    Result login(String userName, String pwd);
}
