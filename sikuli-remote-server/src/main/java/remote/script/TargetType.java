package remote.script;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import org.sikuli.api.Target;

public enum TargetType {
    
    ImageTarget("org.sikuli.api.ImageTarget"),
    ColorImageTarget("org.sikuli.api.ColorImageTarget"),
    StyledRectangleTarget("org.sikuli.api.StyledRectangleTarget");
//    TextTarget("org.sikuli.api.TextTarget"),
//    MultiStateTarget("org.sikuli.api.MultiStateTarget"),
//    ForegroundTarget("ForegroundTarget");
    
    private String className;
    
    private TargetType(String className){
	this.className = className;
    }
    
    public Target getTarget(BufferedImage bufferedImage) throws Exception {
	return (Target) Class.forName(className).getConstructor(BufferedImage.class).newInstance(bufferedImage);
    }
    
    public Target getTarget(File file) throws Exception {
	return (Target) Class.forName(className).getConstructor(File.class).newInstance(file);
    }
    
    public Target getTarget(URL url) throws Exception {
	return (Target) Class.forName(className).getConstructor(URL.class).newInstance(url);
    }
    
    public static void main(String[] args) throws Exception {
	Target target = TargetType.ImageTarget.getTarget(new File("test.jpg"));
    }
}
