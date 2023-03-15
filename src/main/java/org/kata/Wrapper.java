package org.kata;

public class Wrapper {

    public static String wrap(String line, Integer columnNumber) throws Exception {

        if(columnNumber < 1){
            throw new Exception("Column Number must be greater than 0");
        }
        
        if(line.isBlank()){
            return "";
        }

        String[] stringList = line.trim().split(" ");
        if(stringList.length <= columnNumber){
            return line;
        }
        
        String response = "";

        for (int index = 0; index < stringList.length; index++) {
            if(index > 0 && index % columnNumber == 0){
                response += "\n ";
            }

            response += stringList[index] + " ";
        }
        return response;
    }
}
