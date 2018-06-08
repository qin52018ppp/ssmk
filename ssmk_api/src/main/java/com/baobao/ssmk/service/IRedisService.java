package com.baobao.ssmk.service;/**
 * Created by Administrator on 2018/1/26.
 */

import com.baobao.ssmk.dto.Result;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 12:24 2018/1/26
 * @Modified By:
 */
public interface IRedisService {
    Result get(String key);

    Result save(String key, String val);

    Result delete(String key);
}
