概述
---
实现了McCabe Complexity计算在Java语言中的实现

依赖包
----
 - antlr-4.5.3-complete

请使用Maven搜索相关包名进行下载(Project Structure->Modules->Dependencies)  


用法
---
在```Main.java```中更改测试文件的路径  
之后编译并运行```Main.java```

栗子~
---
```
[valueChanged         method] - CC: 1
[valueChanged         method] - CC: 1
[actionPerformed      method] - CC: 1
[actionPerformed      method] - CC: 1
[actionPerformed      method] - CC: 1
[actionPerformed      method] - CC: 1
[actionPerformed      method] - CC: 1
[actionPerformed      method] - CC: 1
[actionPerformed      method] - CC: 1
[getGui               method] - CC: 16
[showRootFile         method] - CC: 1
[findTreePath         method] - CC: 3
[renameFile           method] - CC: 5
[deleteFile           method] - CC: 5
[newFile              method] - CC: 8
[showErrorMessage     method] - CC: 1
[showThrowable        method] - CC: 1
[run                  method] - CC: 3
[setTableData         method] - CC: 4
[setColumnWidth       method] - CC: 2
[doInBackground       method] - CC: 5
[process              method] - CC: 2
[done                 method] - CC: 1
[showChildren         method] - CC: 9
[setFileDetails       method] - CC: 2
[copyFile             method] - CC: 4
[run                  method] - CC: 1
[main                 method] - CC: 2
Summary:
Overall methods count: 14
[FileManager          class] - avg CC: 4.57
==============================
[getValueAt           method] - CC: 2
[getColumnCount       method] - CC: 1
[getColumnClass       method] - CC: 2
[getColumnName        method] - CC: 1
[getRowCount          method] - CC: 1
[getFile              method] - CC: 1
[setFiles             method] - CC: 1
Summary:
Overall methods count: 9
[FileTableModel       class] - avg CC: 1.33
==============================
[getTreeCellRendererComponent method] - CC: 2
Summary:
Overall methods count: 2
[FileTreeCellRenderer class] - avg CC: 2.00
==============================
```
更新日志
---
- 2016.10.11 完成了Java代码的统计
