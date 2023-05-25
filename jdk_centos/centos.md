怎么查看centos版本是6还是7？
 1. lsb_release -a
 2. cat /etc/centos-release
 3. cat /etc/issue
 
centos 安装jdk
    查看java版本：java -version
    查询包含java的源:rpm -qa | grep java
    删除java得有关文件: rpm -e --nodeps java...
    重新安装 1.记录好jdk得路径
            2.解压
            3.vim etc/profile
                JAVA_HOME=你的路径export 
                JRE_HOME=你的路径/jre
                export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH
                export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH
            4.执行下面命令生效:source /etc/profile