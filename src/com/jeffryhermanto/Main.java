package com.jeffryhermanto;

import com.jeffryhermanto.iterator.BrowseHistory;
import com.jeffryhermanto.iterator.Iterator;
import com.jeffryhermanto.memento.Editor;
import com.jeffryhermanto.memento.History;
import com.jeffryhermanto.state.Canvas;
import com.jeffryhermanto.state.SelectionTool;
import com.jeffryhermanto.strategy.BlackAndWhiteFilter;
import com.jeffryhermanto.strategy.ImageStorage;
import com.jeffryhermanto.strategy.JpegCompressor;
import com.jeffryhermanto.strategy.PngCompressor;
import com.jeffryhermanto.template.AuditTrail;
import com.jeffryhermanto.template.Task;
import com.jeffryhermanto.template.TransferMoneyTask;

public class Main {
    public static void main(String[] args) {
        runMementoPattern();
        runStatePattern();
        runIteratorPattern();
        runStrategyPattern();
        runTemplatePattern();
    }

    private static void runMementoPattern() {
        var editor = new Editor();
        var history = new History();

        editor.setContent("Content A");
        history.push(editor.createState());

        editor.setContent("Content B");
        history.push(editor.createState());

        editor.setContent("Content C");
        editor.restore(history.pop());

        System.out.println(editor.getContent());
    }

    private static void runStatePattern() {
        var editor = new Editor();
        var history = new History();

        editor.setContent("State A");
        history.push(editor.createState());

        editor.setContent("State B");
        history.push(editor.createState());

        editor.setContent("State C");
        editor.restore(history.pop());

        System.out.println(editor.getContent());
        var canvas = new Canvas();
        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }

    private static void runIteratorPattern() {
        var history = new BrowseHistory();
        history.push("https://google.com");
        history.push("https://instagram.com");
        history.push("https://twitter.com");

        var iterator = history.createIterator();
        while (iterator.hasNext()) {
            var url = iterator.current();
            System.out.println(url);
            iterator.next();
        }
    }

    private static void runStrategyPattern() {
        var imageStorage = new ImageStorage();
        imageStorage.store("myImageFile", new JpegCompressor(), new BlackAndWhiteFilter());
        imageStorage.store("myImageFile", new PngCompressor(), new BlackAndWhiteFilter());
    }

    private static void runTemplatePattern() {
        var task = new TransferMoneyTask();
        task.execute();
    }
}

