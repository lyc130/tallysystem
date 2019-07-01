# tallysystem
1.解压后用JBuilder或eclipse打开工程
2.要运行工程，请附加数据库文件。
3.数据库文件在DataBase文件夹里面，请在SQL Server里附加数据库。
4.然后，需要配置JDBC-ODBC数据库连接桥。
5.控制面板--管理工具--ODBC数据源--系统DNS ，点添加，找到SQL Server
完成，数据源名称：test(因为程序里连接数据库时用的这个名称)
服务器localhost或者local
接下来将test设为默认数据库.这样数据源就配置完了。

Display:用来将所有学生信息显示在一个文本域
ConDB：toconnection：创建数据库连接
toClose：关闭数据库连接
Mainapplicantion:调用以上类和方法，进行总体执行
TallyDao:  
     Insert:实现插入功能
     Update:实现修改功能
     Search:实现查找功能
     Delete:实现删除功能
TallyBean:各变量的声明和get方法



