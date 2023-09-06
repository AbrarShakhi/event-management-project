package ui;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public abstract class MainFrame extends JFrame {

    private final Dimension screenSize;
    public final int DEVICE_WIDTH;
    public final int DEVICE_HEIGHT;

    public void getFrame() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        DEVICE_HEIGHT = (int) (screenSize.getHeight());
        DEVICE_WIDTH = (int) (screenSize.getWidth());
    }
}
