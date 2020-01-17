package ru.bkmz.list.back;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

import static ru.bkmz.list.back.GUI.*;

class URL extends Thread {

    static String UrlProcessing(String url, int numerUrl) {
        System.out.println("обработка " + url + " #" + numerUrl + 1);
        output.setText("обработка url #" + (numerUrl + 1));
        try {
            Document doc = Jsoup.connect(url).get();
            Element element = doc.select("head title").first();
            return element == null ? null : element.text();
        } catch (Exception e) {
            System.out.println("\u001B[31m"+e+"\u001B[0m");
        }
        return "null";
    }
}
