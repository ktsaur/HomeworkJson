package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;


public class FileJson {

    //метод для считывания файла
    public static String parser(String FileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = null;
        String s = null;

        object = (JSONObject) parser.parse(new FileReader(FileName));
        if (object == null) throw new FileNotFoundException(); //если строка пустая, выбрасывается исключение

        s = (String) object.get("String");
        return s;
    }

    private static boolean isBracket(char symbol) {
        return String.valueOf(symbol).matches("^[\\{\\}\\[\\]]$");
    }

    private static boolean isTextSymbol(char symbol) {
        return String.valueOf(symbol).matches("^[A-Za-zА-Яа-яЁё0-9\\{\\}\\[\\].,:;\"\\r\\n ]$");
    }

    public static int isValidBrackets(String FileName) throws Exception {
        if (Objects.equals(FileName, "")) throw new NullPointerException();
        String str = parser(FileName);
        int count = 0;

        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('}', '{');
        brackets.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for(Character c : str.toCharArray()) {
            if (!isTextSymbol(c)) throw new Exception("Файл не текстовый");
            count++;
            if (brackets.containsValue(c)) { //открывающая скобка
                stack.push(c);
            } else if( brackets.containsKey(c)) {
                if(stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return count;
                }
            }
        }
        if (!stack.isEmpty()) return count;
        return 0;
    }
}
