package remote.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

public class Client {
    private HttpHost host;
    private HttpPost post;

    public Client(String server, int port) {
	host = new HttpHost(server, port);
	post = new HttpPost("/script.do");
    }

    public Client(String server) {
	this(server, 9000);
    }

    /**
     * send request and image to remote server; if execute success then , return true, otherwise return false
     * 
     * @param args
     * @return 
     */
    public boolean call(JSONObject args) {
	// post.setEntity(new FileEntity(new File(args.getString("filePath")),
	// ContentType.APPLICATION_OCTET_STREAM));
	// post.addHeader("Content-Type", "application/json; charset=utf-8");
	// post.setParams(new BasicHttpParams().setParameter("args",
	// args.toString()));
	try {
	    MultipartEntity entity = new MultipartEntity();
	    FileBody file = new FileBody(new File(args.getString("filePath")));
	    StringBody param = new StringBody(args.toString());
	    entity.addPart("file", file);
	    entity.addPart("param", param);

	    post.setEntity(entity);

	    HttpClient client = new DefaultHttpClient();
	    HttpResponse execute = client.execute(host, post);

	    BufferedReader bufferedReader = new BufferedReader(
		    new InputStreamReader(execute.getEntity().getContent()));
	    return Boolean.parseBoolean(bufferedReader.readLine());
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return false;
    }
}