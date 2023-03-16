package org.kata;

public class Wrapper {

    public static String wrap(String line, Integer columnWidth) throws Exception {

        checkForColumnWidthBiggerThan0(columnWidth);

        if(checkForEmptyOrNullString(line)){
            return "";
        }

        String[] stringList = line.trim().split(" ");
        if(stringList.length <= columnWidth){
            return line;
        }
        
        String response = "";

        for (int index = 0; index < stringList.length; index++) {
            if(index > 0 && index % columnWidth == 0){
                response += "\n ";
            }

            response += stringList[index] + " ";
        }
        return response;
    }

    public static void checkForColumnWidthBiggerThan0(int columnWidth) throws Exception {
        if(columnWidth < 1){
            throw new Exception("Column Number must be greater than 0");
        }
    }

    public static boolean checkForEmptyOrNullString(String line){
        return line.isBlank() || line == null;
    }
}
