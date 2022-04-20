package com.jeffryhermanto;

import com.jeffryhermanto.iterator.BrowseHistory;
import com.jeffryhermanto.iterator.Iterator;
import com.jeffryhermanto.state.Canvas;
import com.jeffryhermanto.state.SelectionTool;

public class Main {
    public static void main(String[] args) {
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
}

