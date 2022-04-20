package com.jeffryhermanto;

import com.jeffryhermanto.state.Canvas;
import com.jeffryhermanto.state.SelectionTool;

public class Main {
    public static void main(String[] args) {
        var canvas = new Canvas();
        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}

