package remote.worker;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import org.json.JSONObject;


public interface Worker {
    boolean work(JSONObject json,BufferedImage image);
    

    boolean work(JSONObject json,File imageFile);
    

    boolean work(JSONObject json,URL imageUrl);
}
