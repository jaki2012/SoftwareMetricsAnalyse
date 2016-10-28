概述
---
- ### 简单算法  
  使用了```JavaParser```进行语法分析  
  对操作符和操作数进行了大致的统计  
  已经计入的如
   - if else/else if
   - while/do while
   - switch case defaule  
   - continue/break
   - return
   - Unary expression
   - Class/Interface
   - Package
   - Primitive type
   - Identifier/Reserved words  
   ......

  注：目前还没有对赋值语句，```if```、```for```、```while```、```do```等中的条件语句进行分析  
  关于操作符和操作数的定义是参考https://zh.scribd.com/doc/99533/Halstead-s-Operators-and-Operands-in-C-C-JAVA-by-Indranil-Nandy 注意和维基百科有些出入

- ### 完备算法  
  使用```Antlr4```进行语法树级别的分析  
  能够的到较为准确且完备的信息  
  同时由于拓展性较强，可以轻易的实现各种语言的Halstead Metrics计算  
  目前实现的语言标准有```Java 8``` ```C``` ```C++ 14```


依赖包
----
 - com.github.javaparser
 - org.apache.commons.io
 - antlr-4.5.3-complete

请使用Maven搜索相关包名进行下载(Project Structure->Modules->Dependencies)  


用法
---
在```Main.java```中更改测试文件的路径  
之后编译并运行```Main.java```

栗子~
---
简单算法：
```
File path:E:\MyCodes\Java\JavaCodeParser\src\simple.java
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
```
完备算法：
```
File path:E:\MyCodes\Java\JavaCodeParser\src\simple.java
========================================================
n1:								132.0
n2:								133.0
n(Program Vocabulary):			265.0
N1:								35.0
N2:								54.0
N(Program length):				89.0
Calculated program length:		1868.2125876769742
Volume:							576.3402753560094
Difficulty:						26.796992481203006
Effort:							15444.186025329454
Time required to program:		858.0103347405252
Purity ratio:					20.9911526705278
```
更新日志
---
- 2016.10.06 实现了简单算法  
- 2016.10.07 实现了完备算法
