package remote.worker;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import org.json.JSONObject;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.Relative;
import org.sikuli.api.Relative.RelativeScreenLocationBuilder;
import org.sikuli.api.Relative.RelativeScreenRegionBuilder;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;

import remote.script.TargetType;

public class SikuliWorder implements Worker {

    @Override
    public boolean work(JSONObject json, BufferedImage image) {

	ScreenRegion region = new DesktopScreenRegion();
	try {
	    Target target = TargetType.valueOf(json.getString("targetType"))
		    .getTarget(image);
	    ScreenRegion find = region.find(target);
	    JSONObject relative = (JSONObject) json.get("relative");
	    RelativeScreenRegionBuilder locationPoint = Relative.to(find);
	    //Relative.to(r).bottomLeft().getScreenLocation();执行类化的方法过程
	    ScreenLocation location = ((RelativeScreenLocationBuilder) locationPoint
		    .getClass().getMethod(relative.getString("location"))
		    .invoke(locationPoint)).getScreenLocation();
	    if (relative.has("relativeType")) {
		//Relative.to(location).left(100).getScreenLocation();执行类化的方法过程，以上面获取的点为基准
		RelativeScreenLocationBuilder relativeScreenLocation = Relative
			.to(location);
		location = ((RelativeScreenLocationBuilder) relativeScreenLocation
			.getClass()
			.getMethod(relative.getString("relativeType"),
				Integer.TYPE)
			.invoke(relativeScreenLocation,
				relative.getInt("relativeValue")))
			.getScreenLocation();
	    }
	    Mouse mouse = new DesktopMouse();
	    mouse.getClass()
		    .getMethod(json.getString("mouse"),
			    ScreenLocation.class).invoke(mouse, location);
	    return true;

	}catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}

    }

    @Override
    public boolean work(JSONObject json, File imageFile) {

	    return false;
    }

    @Override
    public boolean work(JSONObject json, URL imageUrl) {

	    return false;
    }

}
