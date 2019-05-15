package remote.client;

import remote.robot.Mouse;
import remote.script.TargetType;

public class RemoteScreen {
    
    private Client client;
    private TargetType targetType;
    private String imagePath;
    
    /**
     *  create connection to remote server, with hostname or IP address
     * 
     * @param server
     */
    public RemoteScreen(String server){
	this.client = new Client(server);
    }
    
    /**
     * create connection to remote server, with hostname or IP address and port
     * 
     * 
     * @param server
     * @param port
     */
    public RemoteScreen(String server,int port){
	this.client = new Client(server, port);
    }
    
//    public void click(String path) throws JSONException, Exception{
//	client.call(new JSONObject().put("filePath", path).put("action", "click"));
//    }

    public Client getClient() {
        return client;
    }

    /**
     * 
     * according to local image file, find match element in remote screen, and return mouse object to do nest step
     *  
     * @param imagePath  local file path
     * @param targetType target type , now only support ImageTarget¡¢colorImageTarge and StyledRectangleTarget
     * @return 
     */
    public Mouse find(String imagePath,TargetType targetType){
	this.targetType = targetType;
	this.imagePath = imagePath;
	return new Mouse(this);
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public String getImagePath() {
        return imagePath;
    }
    
}
