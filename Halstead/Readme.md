概述
---
使用了```JavaParser```进行语法分析  
对操作符和操作数进行了大致的统计  
注：目前还没有对赋值语句，```if```、```for```、```while```、```do```等中的条件语句进行分析

依赖包
----
 - com.github.javaparser

请使用Maven搜索相关包名进行下载(Project Structure->Modules->Dependencies)  


用法
---
在```Main.java```中更改测试文件的路径  
之后编译并运行```Main.java```

栗子~
---
    File path:E:\MyCodes\Java\JavaCodeParser\src\Simple.java
    ========================================================
    n1:24
    n2:38
    n:62
    N1:30
    N2:55
    N:85
    CPL:309.460345528164
    V:506.1066863828844
    D:17.0
    E:8603.813668509034
