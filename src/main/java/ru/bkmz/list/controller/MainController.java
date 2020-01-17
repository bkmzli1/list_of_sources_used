package ru.bkmz.list.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import ru.bkmz.list.util.GetItem;
import ru.bkmz.list.util.URL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MainController {

    public ProgressBar progressBar;
    public Label progressPercent;
    public TextArea in;
    public TextArea out;
    public Button button;

    GetItem getItem;

    ArrayList<String> dataURL;
    String list;
     public static int error;

    public void initialize() {
        getItem = new GetItem(progressBar, progressPercent, in, out);

    }

    public void button(ActionEvent actionEvent) {
        error=0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                button.setDisable(true);
                proc(0,true);
                list = "";
                dataURL = new ArrayList<>();
                Collections.addAll(dataURL, in.getText().split("\n"));
                for (int i = 0; i < dataURL.size(); i++) {
                    out.setText("обработка #" + (i + 1) + "/" + dataURL.size()+"\nошибок:"+error);
                    double proc = (i * 100) / dataURL.size();

                    proc(proc,true);
                    getList(dataURL.get(i), i);
                }
                proc(100,true);
                out.setText(list);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        progressPercent.setText("ожидание");
                    }
                });
                for (int i = 100; i >= 0; i--) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    proc(i,false);
                }

                button.setDisable(false);
            }
        }).start();


    }

    void getList(String url, int number) {
        String dateS;
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("дата обращения dd.MM.yyyy");
        dateS = "(" + formatForDateNow.format(date) + ")";
        list += (number + 1) + ". " + URL.UrlProcessing(url, number) +
                " [Электронный ресурс] – Режим доступа: " + url + " " + dateS + "\n";

    }

    void proc(double proc,boolean b) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (b) {
                    progressPercent.setText((int) proc + "%");
                }
                progressBar.setProgress(proc / 100);
            }
        });

    }
}
