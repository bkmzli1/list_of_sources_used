package ru.bkmz.list.util;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import static ru.bkmz.list.controller.MainController.error;

public class URL {

    public static String UrlProcessing(String url, int numerUrl) {

        System.out.println("обработка " + url + " #" + (numerUrl + 1));
        url = url.replace("https://","");
        url = url.replace("http://","");
        url = "http://"+url;
        try {
            Document doc = Jsoup.connect(url).get();
            Element element = doc.select("head title").first();
            return element == null ? null : element.text();
        } catch (HttpStatusException e) {
            error++;
            e.printStackTrace();
            return "error(Message:" + e.getMessage() + ", Status:" + e.getStatusCode() + ")";
        } catch (Exception e) {
            error++;
            e.printStackTrace();
            return "error(" + e.getMessage() + ")";
        }

    }
}
