package ga.servu.mousemover;

import java.awt.*;

/**
 * Created by Pisek on 08.03.2017.
 */
public class Mover {

    public static void main(String[] args) {

        int moveBy = 1;

        while (true) {
            try {
                Point l = MouseInfo.getPointerInfo().getLocation();
                Robot r = new Robot();
                r.mouseMove(l.x + moveBy, l.y);
                moveBy = -moveBy;
                Thread.sleep(60000);
            } catch (Exception e) {
            }
        }

    }

}
