package ui;

import javax.swing.*;
import java.awt.*;

public abstract class MainFrame extends JFrame {

    private final Dimension screenSize;
    public final int DEVICE_WIDTH;
    public final int DEVICE_HEIGHT;

    // #Contructor...
    public MainFrame() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        DEVICE_HEIGHT = (int) (screenSize.getHeight());
        DEVICE_WIDTH = (int) (screenSize.getWidth());
    }
}