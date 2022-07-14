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
        } else if (query.contains("which of the following numbers is the largest")) {
            ArrayList<Integer> temp = toList(query);
            int number = temp.get(0);

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) > number) {
                    number = temp.get(i);
                }
            }
            return "" + number;
        } else if (query.contains("plus")) {
            ArrayList<Integer> temp = toList(query);
            int returnValue = 0;
            for (Integer integer : temp) {
                returnValue = returnValue + integer;
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
