
- 关于 图片资源的动态获取 
1、可以在proto 中定义 类似这样的

``` protobuf
message Image {
String url=1 
String resID=2
}
```

2、客户端，得到Image对象时，先根据resID在本获取文件。
 - 获取到，加载。
   - 获取不到，url获取，并保存本地。 

3、过期文件的清理
 客户端在每次应用初始化时，需要和服务端同步资源管理系统。

- 关于Particle状态的本地持久化
