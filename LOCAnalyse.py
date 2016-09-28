#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 16/9/28 下午1:10
# @Author  : Jiechu Li
# @File    : LOCAnalyse.py
# @Software: PyCharm

def blank_row(s):
    s = s.strip("\n\r\t   ")
    if len(s) == 0:
        return True
    else:
        return False

def define_row(row):
    row = row.strip("\n\r\t   ")
    if len(row) == 1:
        return "Code";
    elif len(row) >= 2 and row[0] == '/' and row[1] == '/':
        return "Comment";
    elif len(row) >= 2 and row[0] == '/' and row[1] == '*':
        if row.rfind("*/") == -1:
            return "CommentNotEnd";
        elif row.rfind("*/") == len(row) - 2:
            return "CommentEnd";
        elif row.rfind("*/") < len(row) - 2:
            return "Comment_" + define_row(row[row.rfind("*/")+2:len(row)]);
    elif row.rfind(';') == len(row) - 1 and row.count(';') == 1:
        return "Code";
    elif row.rfind(';') == len(row) - 1 and row.count(';') > 1:
        return "Code_"+define_row(row[row.find(';')+1:len(row)])
    elif row.rfind(";")!= -1 and row.rfind(";") < len(row) - 1:
        return "Code_" + define_row(row[row.rfind(";")+1:len(row)]);
    elif row.rfind(';') == -1:
        if row.rfind("/*") == -1:
            return "Code";
        else:
            return "Code_" + define_row(row[row.rfind("/*")+2:len(row)]);
    elif row[0] == '*':
            return "Comment";
    else:
        return "Unknown";

def last_status(status):
    if '_' in status:
        pos = status.rfind('_');
        return status[pos+1:];
    else:
        return status;

def loc_metrics_analyse(list_of_codes):
    l = len(list_of_codes)
    i = 1
    list_of_status = []

    # analyze the very 1st line
    if blank_row(list_of_codes[0]):
        list_of_status.append("Blank")
    else:
        list_of_status.append(define_row(list_of_codes[0]))

    while i < l:
        lastStatus = last_status(list_of_status[i-1]);
        if lastStatus=="Code" or lastStatus=="Comment" or lastStatus=="Blank" or lastStatus=="CommentEnd":
            if blank_row(list_of_codes[i]):
                list_of_status.append("Blank")
            else:
                list_of_status.append(define_row(list_of_codes[i]))
            i += 1
            continue
        elif lastStatus=="CommentNotEnd":
            if blank_row(list_of_codes[i]):
                list_of_status.append("Blank")
            else:
                pos = list_of_codes[i].rfind("*/")
                if pos == -1:
                    i += 1
                    list_of_status.append("CommentNotEnd")
                    continue
                else:
                    if blank_row(list_of_codes[i][pos + 2:len(list_of_codes[i]) - 1]):
                        list_of_status.append("CommentEnd")
                    else:
                        list_of_status.append(define_row(list_of_codes[i][pos + 2:len(list_of_codes[i]) - 1]))
                    i += 1;

    return list_of_status;

if __name__ == "__main__":
    file = open("/Users/lijiechu/Documents/test.java", 'r')
    try:
        list_of_rows = file.readlines()
    finally:
        file.close()

    LOC_TOTAL = len(list_of_rows)
    LOC_BLANK = 0
    LOC_COMMENTS = 0
    LOC_CODE_AND_COMMENT = 0
    LOC_EXECUTABLE = 0

    # print total_row
    analyze_result = loc_metrics_analyse(list_of_rows)

    for i in range(len(analyze_result)):
        print ("row ", i + 1, "~~~~", "~~~~", analyze_result[i], list_of_rows[i])

    for x in analyze_result:
        if x == "Blank":
            LOC_BLANK += 1
        elif "Code" in x:
            if "Comment" in x:
                LOC_CODE_AND_COMMENT += 1
            else:
                LOC_EXECUTABLE += 1
        elif "Comment" in x:
            LOC_COMMENTS += 1

    print ("LOC_TOTAL: ", LOC_TOTAL, "\nLOC_BLANK: ", LOC_BLANK, "\nLOC_COMMENTS: ", LOC_COMMENTS,\
        "\nLOC_CODE_AND_COMMENT: ", LOC_CODE_AND_COMMENT, "\nLOC_EXECUTABLE: ", LOC_EXECUTABLE)