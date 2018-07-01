# SSM+Hessian+Redis

### ssmk_api -----定义接口
### ssmk_hessian_service-----hessian RPC服务端实现
### ssmk_dubbox_service-----dubbo RPC服务端实现

### ssmk_lib-----底层数据库
### ssmk_utils-----工具类
### ssmk_web-----hessian RPC 客户端调用


# 使用Hessian注意的地方
1、传输对象必须序列化
2、传输对象的包路径，名称必须一致
3、Hessian提供的接口放置的位置



# SOA项目运行时需要修改dubbox的配置以便于兼容spring4.X

更改
