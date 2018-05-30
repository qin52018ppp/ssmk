package com.baobao.ssmk;/**
 * Created by Administrator on 2018/5/23.
 */

import com.baobao.framework.utils.jedis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Set;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 18:22 2018/5/23
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/applicationContext.xml"})
public class MybatisDemoTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testUser() {
        Set<String> set = redisUtil.revrangeByScoreWithSortedSet("game", 100, -1);
        StringBuilder s = new StringBuilder();
        int i = 1;
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            s.append(String.format("\n姓名%s，名次%d。<br>\n", str, i));
            i++;
        }
        System.out.println(s.toString());
    }
}
