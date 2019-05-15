package remote.server.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import remote.worker.SikuliWorder;
import remote.worker.Worker;

public class ScriptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	
	DiskFileItemFactory factory = new DiskFileItemFactory();
//	factory.setRepository(new File("D:\\temp"));
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	Boolean result=false;
	try {
	    List<FileItem> parseRequest = upload.parseRequest(req);
	    BufferedImage image = null;
	    JSONObject json = null;
	    for (FileItem fileItem : parseRequest) {
		if(fileItem.isFormField()==false){
		    image = ImageIO.read(fileItem.getInputStream());
//		    fileItem.write(new File("C:\\test.jpg"));
//		    ScreenRegion s = new DesktopScreenRegion();
//		    File f = new File("C:\\test.jpg");
//		    Target target = new ImageTarget(f);
//		    ScreenRegion find = s.find(target);
//		    Mouse mouse = new DesktopMouse();
//		    mouse.click(find.getCenter());
		}else{
		    json = new JSONObject(fileItem.getString());
		}
	    }
	    if(image !=null && json !=null){
		Worker work = new SikuliWorder();
		result=work.work(json, image);
	    }
	} catch (FileUploadException e1) {
	    e1.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	resp.reset();
	resp.setContentType("application/json");
	resp.setCharacterEncoding("UTF-8");
	resp.setStatus(HttpServletResponse.SC_OK);
	resp.getOutputStream().write(result.toString().getBytes());
	resp.flushBuffer();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	super.doGet(req, resp);
	doPost(req, resp);
    }
    
}