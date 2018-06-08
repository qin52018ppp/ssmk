package com.baobao.ssmk.service;/**
 * Created by Administrator on 2018/5/23.
 */

import com.baobao.ssmk.dao.TUserMapper;
import com.baobao.ssmk.dto.TUserRes;
import com.baobao.ssmk.model.TUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 11:42 2018/5/23
 * @Modified By:
 */
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public Object getUserById(Long n) {
        TUser tUser = tUserMapper.selectByPrimaryKey(n);
        TUserRes tUserRes = new TUserRes();
        BeanUtils.copyProperties(tUser, tUserRes);
        return tUserRes;
    }

    @Override
    public Object getUserByName(String n) {
        TUser tUser = tUserMapper.findUserByUsername(n);
        TUserRes tUserRes = new TUserRes();
        BeanUtils.copyProperties(tUser, tUserRes);
        return tUserRes;
    }
}
