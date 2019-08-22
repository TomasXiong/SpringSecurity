

Spring Boot 集成Mybatis:
---------------------------------------
1、新建一个新的Maven Project;
2、需要在pom.xml文件添加相应的依赖，
       比如：mysql驱动；
       PageHelper分页插件，需要版本号；
3、编写启动类，大部分和之前的代码是一样的，需要的注意的是：
    需要添加一个注解@MapperScan --指定MyBatis持久类的位置；
4、编写一个测试的实体类Demo;
5、编写一个DemoMapper,使用@Select和@Save进行数据库操作；
   使用@Options配置返回的主键信息；
6、编写DemoService;
7、编写DemoController;
8、添加分页配置信息，需要添加一个MyBatisConfiguration;
9、使用PageHelper.startPage(pageNum,pageSize)进行分页；


   