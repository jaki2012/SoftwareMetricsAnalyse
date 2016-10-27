package metrics;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by lijiechu on 16/10/23.
 */

public class LOCAnalyser {

    public static void run(InputStream stream, MetricsEvaluator evaluator) {
        ArrayList<String> listOfLines = new ArrayList<String>();

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(stream));
            String temp;
            do{
                temp = bufferedReader.readLine();
                if(temp != null){
                    listOfLines.add(temp);
                }
            }while (temp!=null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        init(listOfLines, evaluator);
    }

    private static void init(ArrayList<String> listOfLines, MetricsEvaluator e) {
        int NUMBER_OF_LINES = listOfLines.size();
        int LOC_BLANK = 0;
        int LOC_COMMENTS = 0;
        int LOC_EXECUTABLE = 0;

        LOCAnalyser mAnalyser = new LOCAnalyser();

        // print analyze_result
        ArrayList<String> analyze_result = mAnalyser.LOCMetricsAnalyse(listOfLines);

//        for(int i=0; i<analyze_result.size(); i++){
//            System.out.println("row " + (i + 1) + "~~~~" + "~~~~" + analyze_result.get(i) + listOfLines.get(i));
//        }

        // run loc metrics
        for(int i=0; i<analyze_result.size(); i++){
            String curResult = analyze_result.get(i);
            if("Blank".equals(curResult)){
                LOC_BLANK += 1;
            } else if (curResult.contains("Code")) {
                if (curResult.contains("Comment")) {
                } else {
                    LOC_EXECUTABLE += 1;
                }
            } else if(curResult.contains("Comment")){
                LOC_COMMENTS += 1;
            }
        }

        calculate(e, NUMBER_OF_LINES, LOC_BLANK, LOC_COMMENTS, LOC_EXECUTABLE);
    }

    public static void calculate(MetricsEvaluator e, double NUMBER_OF_LINES, double LOC_BLANK, double LOC_COMMENTS, double LOC_EXECUTABLE) {
        double LOC_CODE_AND_COMMENT;
        double PERCENT_COMMENTS;
        double LOC_TOTAL;
        LOC_CODE_AND_COMMENT = (int)(double)e.getDimension(Dimension.LOC_CODE_AND_COMMENT);
        PERCENT_COMMENTS = (float)(LOC_COMMENTS + LOC_CODE_AND_COMMENT) / (float)(LOC_COMMENTS + LOC_CODE_AND_COMMENT + LOC_EXECUTABLE);
        LOC_TOTAL = LOC_EXECUTABLE + LOC_CODE_AND_COMMENT;
        e.putDimension(Dimension.NUMBER_OF_LINES, NUMBER_OF_LINES);
        e.putDimension(Dimension.LOC_BLANK, LOC_BLANK);
        e.putDimension(Dimension.LOC_COMMENTS, LOC_COMMENTS);
        e.putDimension(Dimension.LOC_EXECUTABLE, LOC_EXECUTABLE);
        e.putDimension(Dimension.LOC_TOTAL, LOC_TOTAL);
        e.putDimension(Dimension.PERCENT_COMMENTS, PERCENT_COMMENTS);
    }

    public boolean isBlankRow(String line){
        line = line.trim();
        return "//BlankLine!!".equals(line);
//        if(0 == line.length()){
//            return true;
//        } else{
//            return false;
//        }
    }

    public String defineRow(String line){
        line = line.trim();
        int length = line.length();
        if(1 == length){
            return "Code";
        } else if(length >= 2 && ('/') == line.charAt(0) && ('/') == line.charAt(1)){
            return "Comment";
        } else if(length >= 2 && ('/') == line.charAt(0) && ('*') == line.charAt(1)){
            if(-1 == line.lastIndexOf("*/")){
                return "CommentNotEnd";
            } else if((length - 2) == line.lastIndexOf("*/")){
                return "CommentEnd";
            } else if((length - 2) > line.lastIndexOf("*/")){
                return "Comment_" + defineRow(line.substring(line.lastIndexOf("*/")+2,length));
            }
        } else if((length -1 ) == line.lastIndexOf(';') && 1 == subStrCount(line,";")){
            return "Code";
        } else if((length -1 ) == line.lastIndexOf(';') && 1 < subStrCount(line,";")){
            return "Code_" + defineRow(line.substring(line.indexOf(';')+1,length));
        } else if(line.lastIndexOf(';') != -1 && line.lastIndexOf(";") < length - 1){
            return "Code_" + defineRow(line.substring(line.lastIndexOf(';')+1,length));
        } else if(-1 == line.lastIndexOf(';')){
            if(-1 == line.lastIndexOf("/*")){
                return "Code";
            } else {
                return "Code_" + defineRow(line.substring(line.lastIndexOf("/*")+2,length));
            }
        } else if('*' == line.charAt(0)){
            return "Comment";
        }
        // else
        return "Unknown";
    }

    public String lastStatus(String status){
        if(status.contains("_")){
            int pos = status.lastIndexOf('_');
            return status.substring(pos+1,status.length());
        }else {
            return status;
        }
    }

    public ArrayList<String> LOCMetricsAnalyse(ArrayList<String> listOfLines){
        int l = listOfLines.size();
        int i = 1;
        ArrayList<String> listOfStatus = new ArrayList<String>();

        // analyze the very 1st line
        if(isBlankRow(listOfLines.get(0))){
            listOfStatus.add("Blank");
        } else{
            listOfStatus.add(defineRow(listOfLines.get(0)));
        }

        while(i < l){
            String lastStatus = lastStatus(listOfStatus.get(i-1));
            if(lastStatus.equals("Code") || lastStatus.equals("Comment")|| lastStatus.equals("Blank") || lastStatus.equals("CommentEnd")){
                if(isBlankRow(listOfLines.get(i))){
                    listOfStatus.add("Blank");
                } else{
                    listOfStatus.add(defineRow(listOfLines.get(i)));
                }
                i++;
                continue;
            } else if(lastStatus.equals("CommentNotEnd")){
                if(isBlankRow(listOfLines.get(i))) {
                    listOfStatus.add("Blank");
                } else {
                    int pos = listOfLines.get(i).lastIndexOf("*/");
                    if(-1 == pos){
                        i++;
                        listOfStatus.add("CommentNotEnd");
                        continue;
                    } else {
                        if(listOfLines.get(i).length()<= pos+2){
                            listOfStatus.add("CommentEnd");
                        } else{
                            listOfStatus.add(defineRow(listOfLines.get(i).substring(pos+2,listOfLines.get(i).length()-1)));
                        }
                    }
                }
                i++;
            }
        }
        return listOfStatus;
    }

    public int subStrCount(String parentStr, String subStr){
        int count = 0;
        int index = 0;
        while (true) {
            index = parentStr.indexOf(subStr, index + 1);
            if (index > 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }


}
