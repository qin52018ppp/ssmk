package com.baobao.framework.security;

import java.io.Serializable;

public class AuthRole implements Serializable {

    private static final long serialVersionUID = 2903748234792879l;

    // 系统编号
    private String systemId;
    // 空间ID
    private String spaceId;
    // 角色CODE
    private String roleCode;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
