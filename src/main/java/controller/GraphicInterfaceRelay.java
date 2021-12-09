package controller;

import java.io.IOException;

public interface GraphicInterfaceRelay {
    void generateGraphics(DataAccessInterfaceControllerRelay i);

    void generateImage(DataAccessInterfaceControllerRelay i) throws IOException;
}
