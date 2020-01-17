package ru.bkmz.list.util;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class GetItem {
    public ProgressBar progressBar;
    public Label progressPercent;
    public TextArea in;
    public TextArea out;

    public GetItem(ProgressBar progressBar, Label progressPercent, TextArea in, TextArea out) {
        this.progressBar = progressBar;
        this.progressPercent = progressPercent;
        this.in = in;
        this.out = out;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public Label getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(Label progressPercent) {
        this.progressPercent = progressPercent;
    }

    public TextArea getIn() {
        return in;
    }

    public void setIn(TextArea in) {
        this.in = in;
    }

    public TextArea getOut() {
        return out;
    }

    public void setOut(TextArea out) {
        this.out = out;
    }
}
