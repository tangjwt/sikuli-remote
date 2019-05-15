package remote.client;

import org.json.JSONException;
import org.json.JSONObject;

public enum Relative {
    center, topLeft, topRight, bottomRight, bottomLeft;

    public JSONObject right(int amount) throws JSONException {
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("location", this.toString());
	jsonObject.put("relativeType", "right");
	jsonObject.put("relativeValue", amount);
	return jsonObject;
    }

    public JSONObject left(int amount) throws JSONException {
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("location", this.toString());
	jsonObject.put("relativeType", "left");
	jsonObject.put("relativeValue", amount);
	return jsonObject;
    }

    public JSONObject above(int amount) throws JSONException {
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("location", this.toString());
	jsonObject.put("relativeType", "above");
	jsonObject.put("relativeValue", amount);
	return jsonObject;
    }

    public JSONObject below(int amount) throws JSONException {
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("location", this.toString());
	jsonObject.put("relativeType", "below");
	jsonObject.put("relativeValue", amount);
	return jsonObject;
    }

    public static void main(String[] args) {
	
    }
    
}
