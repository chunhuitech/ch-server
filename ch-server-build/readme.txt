编译
mvn clean install

运行：
右键 ch-api-xf下的Application Run


日志文件查看：
/tmp/logs/ch/api-xf/api-xf.log


发布
java -jar ch-api-admin.jar --spring.profiles.active=dev
java -jar ch-api-admin.jar --spring.profiles.active=prod

//访问swagger
http://localhost:8880/api/admin/swagger-ui.html#/
http://www.chunhuitech.cn:8880/api/admin/swagger-ui.html

//数据库连接相关修改文件
ch-server-build/ch-cores/ch-core-admin/src/main/resources/mybatis/mybatis-generator.xml
ch-server-build/ch-cores/ch-core-xf/src/main/resources/mybatis/mybatis-generator.xml
上面是那两个工程用于更新数据库字段变更后，自动生成代码的
然后在右侧Maven下的对应工程如ch-core-admin下的mybatis-generator下的右键mybatis-generator:generate运行