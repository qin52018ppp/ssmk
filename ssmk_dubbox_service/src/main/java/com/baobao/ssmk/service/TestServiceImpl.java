package com.baobao.ssmk.service;/**
 * Created by Administrator on 2018/5/23.
 */
import com.baobao.ssmk.dao.TUserMapper;
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
    public Object test(Long n) {
        return tUserMapper.selectByPrimaryKey(n);
    }

    @Override
    public Object test2(String n) {
        return tUserMapper.findUserByUsername(n);
    }
}
