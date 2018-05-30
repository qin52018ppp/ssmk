package com.baobao.ssmk;/**
 * Created by Administrator on 2018/5/23.
 */

import com.baobao.framework.utils.Md5Utility;
import com.baobao.ssmk.dao.TUserMapper;
import com.baobao.ssmk.model.TUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 18:22 2018/5/23
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class MybatisDemoTest {
    @Autowired
    private TUserMapper tUserMapper;

    @Test
    public void testUser() {
        TUser user =tUserMapper.findUserByUsername("15921490998");
        Assert.assertEquals(user.getPasswd(), Md5Utility.md5SaltString("123456", "15921490998"));
    }
}
