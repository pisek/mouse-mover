package ga.servu.mousemover;

import java.awt.*;
import java.io.Closeable;

/**
 * Created by Pisek on 08.03.2017.
 */
public class MouseMover implements Runnable, AutoCloseable {

    private boolean run = true;

    public void run() {

        int moveBy = 1;

        while (run) {
            try {
                System.out.println("Go");
                Point l = MouseInfo.getPointerInfo().getLocation();
                Robot r = new Robot();
                r.mouseMove(l.x + moveBy, l.y);
                moveBy = -moveBy;
                Thread.sleep(60000);
            } catch (Exception e) {
            }
        }

    }

    public void close() {
        this.run = false;
    }
}
