JVM 的参数类型：
* 标配参``数
* x 参数了解
* XX参数（主要）````

**XX参数**

Boolean 类型 ：

        公式 ： -XX:+或者-某个属性值
        + ： 表示开启
        - ： 表示关闭   
Case ：

是否打印GC收集细节：
-XX:+PrintGCDetails
-XX:-PrintGCDetails

是否使用串行垃圾回收器
-XX:-UseSerialGC
-XX:+UseSerialGC


KV设置类型 ： 
        
        公式 ： 
        -XX:属性key=属性值value
Case ：
        
        -XX:MetaspaceSise=128m          jdk8后是元空间，设置元空间大小
        -XX:MaxTenuringThreshold=15     幸存区最大的存活次数
jinfo 举例，如何查看当前运行程序的配置

        公式： 
        jinfo -flag 具体参数或配置项  java对应进程    ：是否开启或使用
        jinfo -flags                java对应进程    ：是否开启或使用

**jinfo -flag PrintGCDetails  3333**


```
-Xms ===> -XX:initialHeapSize
-Xmx ===> -XX:MaxHeapSize
```

查看jvm默认参数
printFlagsInitial : 主要查看初始默认

        公式： java -XX:+PrintFlagsInitial -version        
              java -XX:+PrintFlagsInitial 

printFlagsFinal : 主要查看修改更新

        公式： java -XX:+PrintFlagsFinal -version        
              java -XX:+PrintFlagsFinal -version      

第一个参数是查看修改，第二个是修改参数  
`java -XX:+PrintFlagsFinal -XX:MetaspaceSize=512m  T(java文件)`

查看垃圾回收器
```
java -XX:+PrintCommandLineFlags -version
```

### -Xms
初始大小内存，默认为物理内存的1/64
等价于 -XX:InitialHeapSize

### -Xmx
最大分配内存，默认为物理内存1/4
等价于-XX:MaxHeapSize

### -Xss
设置单个线程栈的大小，一般默认为512k~1024k
等价于 -XX:ThreadStackSize

### -Xmn 
设置年轻代大小

### -XX:MetaspaceSize
设置元空间大小

### -XX:+PrintGCDetails
打印GC详细信息

### -XX:NewRatio 
配置年轻代与老年代在堆结构的占比

默认  -XX:NewRatio=2 新生代占1，老年代2 ，年轻代占整个堆的1/3

假如-XX:NewRatio=4 新生代占1，老年代4 ，年轻代占整个堆的1/5

newRatio值就是设置老年代的占比，剩下的1给新生代

### -XX:SurvivorRatio
设置新生代中eden和S0、S1空间的比例

默认 -XX:SurvivorRatio=8, Eden:S0:S1 = 8:1:1

假如-XX:SurvivorRatio=4, Eden:S0:S1 = 4:1:1
SurvivorRatio 值就是设置eden区的比例占多少，S0/S1相同

### jinfo -flag MaxTenuringThreshold 
查看默认进入老年代的年龄

-XX:MaxTenuringThreshold=0 : 设置垃圾最大年龄。如果设置为0的话，则年轻代对象不经过Survivor区，直接进入老年代。
对于老年代较多的应用，可以提高效率。如果将比值设置为一个较大值，则年轻代对象会在Survivor区进行多次复制，
这样可以增加对象在年轻代的存活时间，增加在年轻代即被回收的概念



