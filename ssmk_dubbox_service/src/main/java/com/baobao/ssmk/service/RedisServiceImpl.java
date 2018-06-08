package com.baobao.ssmk.service;/**
 * Created by Administrator on 2018/5/23.
 */
import com.baobao.framework.utils.jedis.RedisUtil;
import com.baobao.ssmk.dao.TUserMapper;
import com.baobao.ssmk.dto.Result;
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
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Result get(String key) {
        return new Result(redisUtil.getString(key));
    }

    @Override
    public Result save(String key, String val) {
        return new Result(redisUtil.setString(key,val));
    }

    @Override
    public Result delete(String key) {
        return new Result(redisUtil.delKey(key));
    }
}
