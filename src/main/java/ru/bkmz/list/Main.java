package ru.bkmz.list;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.bkmz.list.util.stage.StageStandart;

public class Main extends Application {

    public static Stage stage;

    public static void main(String[] args) throws Exception {
        for (String arg :
                args) {
            System.out.println(arg + ":true");
        }
    }


    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        double w = 860, h = 442;
        Main.stage.setMinWidth(w);
        Main.stage.setMinHeight(h);
        Main.stage.setWidth(w);
        Main.stage.setHeight(h);
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        new StageStandart("main", false, true,
                stage, "list of sources used");

    }
}