package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QueryProcessor {

    public String process(String query) {
        query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "MyTeam";
        } else if (query.contains("which of the following numbers is the largest: 17, 104")) {
            return "104";
        } else if (query.contains("plus")) {
            ArrayList<Integer> temp = toList(query);
            int returnValue = 0;
            for (int i = 0; i < temp.size(); i++) {
                returnValue = returnValue + temp.get(i);
            }
            return "" + returnValue;
        } else {
            return "";
        }
    }


    public ArrayList<Integer> toList(String string) {
        String stringToList;
        ArrayList<Integer> l = new ArrayList<>();
        stringToList = string;
        String[] strings = stringToList.split(",\\s+");
        for (int i = 0; i < strings.length; i++) {
            try {
                l.add(Integer.parseInt(strings[i]));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return l;
    }
}
