package com.baobao.ssmk.controller;/**
 * Created by Administrator on 2018/5/23.
 */

import com.baobao.framework.utils.jedis.RedisUtil;
import com.baobao.ssmk.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 16:45 2018/5/23
 * @Modified By:
 */
@Controller
@RequestMapping("/redis")
public class RedisTestController {
    public static final Logger LOGGER = LoggerFactory.getLogger(RedisTestController.class);
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping(value = "/get.json", method = RequestMethod.POST)
    @ResponseBody
    public Object get(String key) {
        return redisUtil.getString(key);
    }

    @RequestMapping(value = "/save.json", method = RequestMethod.POST)
    @ResponseBody
    public Object save(String key) {
        String[] keys=key.split(",");
        for (int i = 0; i < keys.length; i++) {
            redisUtil.setString(keys[i],keys[i]+i);
        }
        return keys;
    }

    @RequestMapping(value = "/saveSorted.json", method = RequestMethod.POST)
    @ResponseBody
    public Object saveSorted() {
        List<User> users = new ArrayList<User>();
        users.add(new User("12345", "常少鹏", 99.9));
        users.add(new User("12346", "王卓卓", 99.8));
        users.add(new User("12347", "邹雨欣", 96.8));
        users.add(new User("12348", "郑伟山", 98.8));
        users.add(new User("12349", "李超杰", 99.6));
        users.add(new User("12350", "董明明", 99.0));
        users.add(new User("12351", "陈国峰", 100.0));
        users.add(new User("12352", "楚晓丽", 99.6));
        for (User u:users) {
            redisUtil.addWithSortedSet("game", u.getScore(), u.getName());
        }
        return "success";
    }

    /**
     * redis 直接帮我排序
     * 获取排名
     * @return
     */
    @RequestMapping(value = "/getSorted.json", method = RequestMethod.POST)
    @ResponseBody
    public Object getSorted() {
        Set<String> set = redisUtil.revrangeByScoreWithSortedSet("game", 100, -1);
        if(set.size()==0){
            return "";
        }
        StringBuilder s = new StringBuilder();
        int i = 1;
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            s.append(String.format("姓名%s，名次%d。<br>", str, i));
            i++;
        }
        return s.toString();
    }
}