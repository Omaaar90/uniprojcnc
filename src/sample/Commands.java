package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Commands {
    private Map<String,String> commandMap = new TreeMap<>();


    public Map getCommandMap() {
        return commandMap;
    }

    public void setCommandMap(Map commandMap) {
        this.commandMap = commandMap;
    }

    public void addCommandToList(String commandStr) {
        if (!(commandStr == null) && commandStr.length()>0) {
            String[] splittedCommand = commandStr.split(" ", 2);
            if (!commandStr.startsWith("N")) {
                int lastLine=getNewLinenumber();
                lastLine+=1;
                commandMap.put("N"+lastLine, commandStr);

            }
            else if (splittedCommand.length == 2) {
                commandMap.put(splittedCommand[0], splittedCommand[1]);
            }
        }
    }

    public List<String> toList() {
        List<String> list=new ArrayList<>();
        Set<Map.Entry<String, String>> entrySet = commandMap.entrySet();
        for (Map.Entry<String,String> entry: entrySet
             ) {
            String line = entry.getKey() + " " + entry.getValue();
            list.add(line);
        }
        return list;
    }

    public int getNewLinenumber() {
        String lastKey="";
        for (String key: commandMap.keySet()) {
            if (lastKey.compareTo(key)<0) {
                lastKey=key;
            }
        }

        int lastNumber=0;
        if (lastKey.startsWith("N")) {
            try {
                lastNumber = Integer.parseInt(lastKey.substring(1));
            }
            catch (NumberFormatException e) {
                // nothing to do
            }
        }
        return lastNumber;
    }

}
