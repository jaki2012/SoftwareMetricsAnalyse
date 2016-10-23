# SoftwareMetricsAnalyse

## Overview
A project to compute all kinds of descriptors for those software products(e.g. LOC, McCabe, Halstead).

## Methodology
使用```Antlr4```和```JavaParser```进行语法树级别的分析  
能够的到较为准确且完备的信息  
同时由于拓展性较强，可以实现各种语言代码的相关Metrics计算  
目前实现的语言:```Java```  
计算的维度(参考NASA MDP数据集):
```
LOC_BLANK,
BRANCH_COUNT,
CALL_PAIRS,
LOC_CODE_AND_COMMENT,
LOC_COMMENTS,
CONDITION_COUNT,
CYCLOMATIC_COMPLEXITY,
CYCLOMATIC_DENSITY,
DECISION_COUNT,
DECISION_DENSITY,
DESIGN_COMPLEXITY,
DESIGN_DENSITY,
EDGE_COUNT,
ESSENTIAL_COMPLEXITY,
ESSENTIAL_DENSITY,
LOC_EXECUTABLE,
PARAMETER_COUNT,
GLOBAL_DATA_COMPLEXITY,
GLOBAL_DATA_DENSITY,
HALSTEAD_CONTENT,
HALSTEAD_DIFFICULTY,
HALSTEAD_EFFORT,
HALSTEAD_ERROR_SET,
HALSTEAD_LENGTH,
HALSTEAD_LEVEL,
HALSTEAD_PROGRAM_TIME,
HALSTEAD_VOLUME,
MAINTENANCE_SEVERITY,
MODIFIED_CONDITION_COUNT,
MULTIPLE_CONDITION_COUNT,
NODE_COUNT,
NORMALIZED_CYCLOMATIC_COMPLEXITY,
NUM_OPERANDS,
NUM_OPERATORS,
NUM_UNIQUE_OPERANDS,
NUM_UNIQUE_OPERATORS,
NUMBER_OF_LINES,
PERCENT_COMMENTS,
LOC_TOTAL
```
## Dependencies
 - com.github.javaparser
 - org.apache.commons.io
 - antlr-4.5.3-complete
 - commons-lang3-3.4.jar

Please use Maven to get all these dependencies(In idea, press: Project Structure->Modules->Dependencies)  


## Usage

```
File path:E:\MyCodes\Java\FileSys\src\simple.java
======================================
Module name:simpleIf
1-2+2
MULTIPLE_CONDITION_COUNT        6.0
DESIGN_DENSITY                  2.0
DESIGN_COMPLEXITY               1.0
MAINTENANCE_SEVERITY            0.5
NODE_COUNT                      5.0
EDGE_COUNT                      5.0
GLOBAL_DATA_COMPLEXITY          1.0
CYCLOMATIC_COMPLEXITY           2.0
BRANCH_COUNT                    2.0
GLOBAL_DATA_DENSITY             0.5
ESSENTIAL_COMPLEXITY            1.0
CONDITION_COUNT                 12.0
MODIFIED_CONDITION_COUNT        3.0
n1:								27.0
n2:								31.0
n(Program Vocabulary):			58.0
N1:								13.0
N2:								16.0
N(Program length):				29.0
Calculated program length:		281.96204818040684
Volume:							140.8814488586996
Difficulty:						6.967741935483871
Effort:							981.6255791444876
Time required to program:		54.53475439691598
Purity ratio:					9.722829247600236
======================================
Module name:CC
5-6+2
MULTIPLE_CONDITION_COUNT        4.0
DESIGN_DENSITY                  2.0
DESIGN_COMPLEXITY               1.0
MAINTENANCE_SEVERITY            1.0
NODE_COUNT                      6.0
EDGE_COUNT                      5.0
GLOBAL_DATA_COMPLEXITY          1.0
CYCLOMATIC_COMPLEXITY           1.0
BRANCH_COUNT                    4.0
GLOBAL_DATA_DENSITY             1.0
ESSENTIAL_COMPLEXITY            1.0
CONDITION_COUNT                 8.0
MODIFIED_CONDITION_COUNT        2.0
n1:								25.0
n2:								27.0
n(Program Vocabulary):			52.0
N1:								12.0
N2:								13.0
N(Program length):				25.0
Calculated program length:		244.4783673027818
Volume:							116.09640474436812
Difficulty:						6.018518518518518
Effort:							698.7283618874006
Time required to program:		38.81824232707781
Purity ratio:					9.779134692111272
======================================
Module name:theSleep
4-4+2
DESIGN_COMPLEXITY               2.0
MAINTENANCE_SEVERITY            0.5
NODE_COUNT                      4.0
CALL_PAIRS                      4.0
EDGE_COUNT                      4.0
GLOBAL_DATA_COMPLEXITY          1.0
CYCLOMATIC_COMPLEXITY           2.0
GLOBAL_DATA_DENSITY             0.5
ESSENTIAL_COMPLEXITY            1.0
PARAMETER_COUNT                 1.0
n1:								27.0
n2:								37.0
n(Program Vocabulary):			64.0
N1:								11.0
N2:								19.0
N(Program length):				30.0
Calculated program length:		321.13173708668484
Volume:							147.20671786825557
Difficulty:						6.9324324324324325
Effort:							1020.5006252218258
Time required to program:		56.69447917899032
Purity ratio:					10.704391236222827
======================================
Module name:case2
13-13+2
MULTIPLE_CONDITION_COUNT        10.0
DESIGN_DENSITY                  2.0
DESIGN_COMPLEXITY               2.0
MAINTENANCE_SEVERITY            1.0
NODE_COUNT                      13.0
EDGE_COUNT                      13.0
ESSENTIAL_DENSITY               1.0
GLOBAL_DATA_COMPLEXITY          2.0
CYCLOMATIC_COMPLEXITY           2.0
BRANCH_COUNT                    10.0
GLOBAL_DATA_DENSITY             1.0
ESSENTIAL_COMPLEXITY            2.0
PARAMETER_COUNT                 2.0
CONDITION_COUNT                 20.0
MODIFIED_CONDITION_COUNT        5.0
n1:								54.0
n2:								69.0
n(Program Vocabulary):			123.0
N1:								15.0
N2:								22.0
N(Program length):				37.0
Calculated program length:		732.2521126345212
Volume:							192.74977452827116
Difficulty:						8.608695652173912
Effort:							1659.32414593903
Time required to program:		92.18467477439054
Purity ratio:					19.79059763877084
======================================
Module name:CalculateScore
19-15+2
MULTIPLE_CONDITION_COUNT        8.0
DESIGN_DENSITY                  2.0
DESIGN_COMPLEXITY               6.0
MAINTENANCE_SEVERITY            0.14285714285714285
NODE_COUNT                      16.0
CALL_PAIRS                      1.0
EDGE_COUNT                      21.0
GLOBAL_DATA_COMPLEXITY          6.0
CYCLOMATIC_COMPLEXITY           7.0
BRANCH_COUNT                    12.0
GLOBAL_DATA_DENSITY             0.8571428571428571
ESSENTIAL_COMPLEXITY            1.0
PARAMETER_COUNT                 4.0
CONDITION_COUNT                 16.0
MODIFIED_CONDITION_COUNT        4.0
n1:								65.0
n2:								67.0
n(Program Vocabulary):			132.0
N1:								22.0
N2:								28.0
N(Program length):				50.0
Calculated program length:		797.8818836075202
Volume:							282.1928094887362
Difficulty:						13.582089552238806
Effort:							3832.76800947388
Time required to program:		212.9315560818822
Purity ratio:					15.957637672150405
======================================
Module name:nestSwitch
8-8+2
MULTIPLE_CONDITION_COUNT        4.0
DESIGN_DENSITY                  2.0
DESIGN_COMPLEXITY               2.0
MAINTENANCE_SEVERITY            0.25
NODE_COUNT                      11.0
EDGE_COUNT                      13.0
GLOBAL_DATA_COMPLEXITY          2.0
CYCLOMATIC_COMPLEXITY           4.0
BRANCH_COUNT                    6.0
GLOBAL_DATA_DENSITY             0.5
ESSENTIAL_COMPLEXITY            1.0
PARAMETER_COUNT                 1.0
CONDITION_COUNT                 8.0
MODIFIED_CONDITION_COUNT        2.0
n1:								40.0
n2:								35.0
n(Program Vocabulary):			75.0
N1:								14.0
N2:								14.0
N(Program length):				28.0
Calculated program length:		392.4020293885683
Volume:							134.6059378176129
Difficulty:						8.0
Effort:							1076.8475025409032
Time required to program:		59.8248612522724
Purity ratio:					14.014358192448867
======================================
Module name:main
4-4+2
MULTIPLE_CONDITION_COUNT        4.0
DESIGN_DENSITY                  2.0
DESIGN_COMPLEXITY               2.0
MAINTENANCE_SEVERITY            0.5
NODE_COUNT                      4.0
CALL_PAIRS                      2.0
EDGE_COUNT                      4.0
GLOBAL_DATA_COMPLEXITY          2.0
CYCLOMATIC_COMPLEXITY           2.0
BRANCH_COUNT                    2.0
GLOBAL_DATA_DENSITY             1.0
ESSENTIAL_COMPLEXITY            1.0
PARAMETER_COUNT                 2.0
CONDITION_COUNT                 8.0
MODIFIED_CONDITION_COUNT        1.0
n1:								41.0
n2:								54.0
n(Program Vocabulary):			95.0
N1:								16.0
N2:								32.0
N(Program length):				48.0
Calculated program length:		530.4235573061687
Volume:							268.0782000346155
Difficulty:						12.148148148148147
Effort:							3256.653689309403
Time required to program:		180.9252049616335
Purity ratio:					11.050490777211849

```
## License
```
好孩子协议——2016
                ——Published by Novemser

该软件禁止以下情况的使用：
  - 不听一哥的话
  - 见到一哥不打招呼
  - 把软件卖给别的组织/个人
  - 每天熬夜 不爱护身体

--END--
```
