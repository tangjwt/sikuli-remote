package remote.robot;

import org.json.JSONException;
import org.json.JSONObject;

import remote.client.Relative;
import remote.client.RemoteScreen;

public class Mouse {
    private RemoteScreen remoteScreen;
    private JSONObject json ;

    public Mouse(RemoteScreen remoteScreen) {
	this.remoteScreen = remoteScreen;
	json = new JSONObject();
	try {
	    json.put("filePath", remoteScreen.getImagePath());
	    json.put("targetType", remoteScreen.getTargetType().toString());
	} catch (JSONException e) {
	    e.printStackTrace();
	}
	
    }

    public boolean drag(JSONObject relativeObjcet) throws JSONException {
	json.put("relative", relativeObjcet);
	json.put("mouse", "drag");
	return remoteScreen.getClient().call(json);
    }

    public boolean drop(JSONObject relativeObjcet) throws JSONException {
	json.put("relative", relativeObjcet);
	json.put("mouse", "drop");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Left-click on a given screen location
     * 
     * @param screenLoc
     *            the screen location to click on
     */
    public boolean click(JSONObject relativeObjcet) throws JSONException {
	json.put("relative", relativeObjcet);
	json.put("mouse", "click");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Right-click on a given screen location
     * 
     * @param screenLoc
     *            the screen location to click on
     */
    public boolean rightClick(JSONObject relativeObjcet) throws JSONException {
	json.put("relative", relativeObjcet);
	json.put("mouse", "rightClick");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Double-click on a given screen location
     * 
     * @param screenLoc
     *            the screen location to click on
     */
    public boolean doubleClick(JSONObject relativeObjcet) throws JSONException {
	json.put("relative", relativeObjcet);
	json.put("mouse", "doubleClick");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Hover the mouse cursor to a screen location. The movement is seen
     * smoothly by the user.
     * 
     * @param screenLoc
     *            the screen location for the mouse cursor to hover to
     */
    public boolean hover(JSONObject relativeObjcet) throws JSONException {
	json.put("relative", relativeObjcet);
	json.put("mouse", "hover");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Move the mouse cursor to a destination screen location immediately. The
     * user won't see any mouse movement.
     * 
     * @param screenLoc
     *            the screen location for the mouse cursor to move to
     */
    public boolean move(JSONObject relativeObjcet) throws JSONException {
	json.put("relative", relativeObjcet);
	json.put("mouse", "move");
	return remoteScreen.getClient().call(json);
    }

    public boolean drag(Relative relative) throws JSONException {
	json.put("relative",
		new JSONObject().put("location", relative.toString()));
	json.put("mouse", "drag");
	return remoteScreen.getClient().call(json);
    }

    public boolean drop(Relative relative) throws JSONException {
	json.put("relative",
		new JSONObject().put("location", relative.toString()));
	json.put("mouse", "drop");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Left-click on a given screen location
     * 
     * @param screenLoc
     *            the screen location to click on
     * @throws JSONException
     */
    public boolean click(Relative relative) throws JSONException {
	json.put("relative",
		new JSONObject().put("location", relative.toString()));
	json.put("mouse", "click");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Right-click on a given screen location
     * 
     * @param screenLoc
     *            the screen location to click on
     */
    public boolean rightClick(Relative relative) throws JSONException {
	json.put("relative",
		new JSONObject().put("location", relative.toString()));
	json.put("mouse", "rightClick");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Double-click on a given screen location
     * 
     * @param screenLoc
     *            the screen location to click on
     */
    public boolean doubleClick(Relative relative) throws JSONException {
	json.put("relative",
		new JSONObject().put("location", relative.toString()));
	json.put("mouse", "doubleClick");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Hover the mouse cursor to a screen location. The movement is seen
     * smoothly by the user.
     * 
     * @param screenLoc
     *            the screen location for the mouse cursor to hover to
     */
    public boolean hover(Relative relative) throws JSONException {
	json.put("relative",
		new JSONObject().put("location", relative.toString()));
	json.put("mouse", "hover");
	return remoteScreen.getClient().call(json);
    }

    /**
     * Move the mouse cursor to a destination screen location immediately. The
     * user won't see any mouse movement.
     * 
     * @param screenLoc
     *            the screen location for the mouse cursor to move to
     */
    public boolean move(Relative relative) throws JSONException {
	json.put("relative",
		new JSONObject().put("location", relative.toString()));
	json.put("mouse", "rightClick");
	return remoteScreen.getClient().call(json);
    }

    /**
     * 
     * TODO 
     * 
     * Press the left button
     */
    public boolean press() {
	return false;
    }

    /**
     *  TODO 
     * Press the right button
     */
    public boolean rightPress() {
	return false;
    }

    /**
     *  TODO 
     * Release the left button
     */
    public boolean release() {
	return false;
    }

    /**
     *  TODO 
     * Release the right button
     */
    public boolean rightRelease() {
	return false;
    }

    /**
     *  TODO 
     * Move the wheel at the current position
     * 
     * @param direction
     *            the direction applied
     * @param steps
     *            the number of step
     */
    public boolean wheel(int direction, int steps) {
	return false;
	// TODO
    }

    /**
     *  TODO 
     * @param buttons
     * @return
     */
    public boolean mouseDown(int buttons) {
	return false;

	// TODO
    }

    /**
     *  TODO 
     * @return
     */
    public boolean mouseUp() {
	return false;

	// TODO
    }

    /**
     *  TODO 
     * @param buttons
     * @return
     */
    public boolean mouseUp(int buttons) {
	return false;

	// TODO
    }
}
