编译
mvn clean install

运行：
右键 ch-api-xf下的Application Run


日志文件查看：
/tmp/logs/ch/api-xf/api-xf.log


发布
java -jar ch-api-admin.jar --spring.profiles.active=dev


//访问swagger
http://localhost:8880/api/admin/swagger-ui.html#/