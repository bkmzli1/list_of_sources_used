package ru.bkmz.list.back;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static ru.bkmz.list.back.GUI.*;

public class List extends Thread {
    @Override
    public void run() {
        Out();
    }

    private static void Out() {
        try {
            output.setText("Обработка");
            OUT = "";
            try {
                collection = List.sert(input.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean i = true;
            for (Object o : collection) {
                OUT = OUT + o + "\n";
            }
            output.setText(OUT);
        } catch (Exception e) {
            output.setText(e + "\n" + "error url");
        }
    }

    static Collection<String> sert(String url) throws Exception {
        Collection<String> collection = new ArrayList<>();
        String[] s;
        s = url.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s.length);
            collection.add(List(s[i], i));
        }
        return collection;
    }

    private static String dateS, OUT;

        static String List(String url, int numerUrl) {
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("дата обращения dd.MM.yyyy");
        dateS = "(" + formatForDateNow.format(date) + ")";
        OUT = URL.UrlProcessing(url, numerUrl) + "URL: " + url + dateS+"\n";
        System.out.println(OUT);
        return OUT;
    }
}
