# spring-boot-assembly-example CHANGELOG

### 1.0.1-RELEASE 2019-01-10
1. 增加.gitignore文件，添加忽略提交target目录下和IntelliJ IDEA中的文件
    ### 目录 ###
        /target/

    ### IntelliJ IDEA ###
        .idea *.iws *.iml *.ipr
2. 修改pom.xml中url的地址错误，改为
    https://github.com/lksoulman/spring-boot-assembly-example
	
### 1.0.0-RELEASE  2019-01-09
1. 完成spring boot项目使用maven-assembly-plugin等插件整合
2. 将项目打包成tar.zip
3. 抽取项目配置文件到conf目录
4. 抽取项目第三方依赖到lib目录
5. 启动停止重启服务命令在bin目录
6. 项目启动jar包在main目录
7. 项目启动及运行日志文件保存在logs目录
8. maven不同环境打包时,application.yml中profiles.active为对应环境
> application.yml
```
profiles:
    active: @profileActive@
```
9. mvn-package.bat和mvn-package.sh快速打包脚本
> 默认指定dev环境,可指定不同环境打包

> window
```bash
mvn-package.bat dev
```

> linux/mac
```bash
sh mvn-package.sh dev
```
10. assembly.xml文件,同时打包成tar.gz和zip
> assembly.xml

    <formats>
        <format>tar.gz</format>
        <format>zip</format>
    </formats>
11.assembly.xml和pom.xml文件的打包时包含*.yml文件,如有其它文件可自行设置
> assembly.xml

    <!-- 指定输出target/classes中的配置文件到conf目录中 -->
    <fileSet>
        <directory>${basedir}/target/classes</directory>
        <outputDirectory>conf</outputDirectory>
        <fileMode>0644</fileMode>
        <includes>
            <include>application.yml</include>
            <include>application-${profileActive}.yml</include>
        </includes>
    </fileSet>


> pom.xml

    <resources>
        <!-- 资源文件配置 -->
        <resource>
            <directory>src/main/resources</directory>
            <filtering>true</filtering>
            <includes>
                <include>application.yml</include>
                <include>application-${profileActive}.yml</include>
            </includes>
        </resource>
    </resources>