package Controller;

import java.io.IOException;

public interface GraphicInterfaceRelay {
    void generateGraphics(DataAccessInterfaceRelay i);

    void generateImage(DataAccessInterfaceRelay i) throws IOException;
}
