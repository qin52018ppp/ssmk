package com.baobao.ssmk.dto;/**
 * Created by Administrator on 2018/5/30.
 */

import java.io.Serializable;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 12:25 2018/5/30
 * @Modified By:
 */
public class TUserRes implements Serializable {
    private Long id;

    private String username;

    private String passwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
