package remote.server;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import remote.server.servlet.ScriptServlet;

public class SikuliServer {
    private Server server;
    private ServletContextHandler root;
    private static Logger logger = LogManager.getLogger(SikuliServer.class);

    public void servletRegister(int port) {
	server = new Server();
	SocketConnector socketListener = new SocketConnector();
	socketListener.setMaxIdleTime(60000);
	socketListener.setPort(port);
	server.addConnector(socketListener);
	root = new ServletContextHandler(ServletContextHandler.SESSIONS);
	root.setContextPath("/");
	server.setHandler(root);
	root.addServlet(new ServletHolder(new ScriptServlet()), "/script.do");
    }

    private void boot() throws Exception {
	server.start();
	server.join();
    }

    public void startup(int port) throws Exception {
	servletRegister(port);
	logger.info("Server start at port :"+port);
	boot();
    }

    public Server getServer() {
	return server;
    }

    public void stop() throws Exception {
	server.stop();
    }

    public static void main(String[] args) throws Exception {
	int port = 9000;
	if (args.length > 1) {
	    if ("-port".equals(args[0].trim())) {
		try {
		    port = Integer.valueOf(args[1]);
		} catch (Exception e) {
		    port = 9000;
		}
	    }
	}
	if(port<0 || port>65536)
	    port=9000;
	SikuliServer server = new SikuliServer();
	server.startup(port);
    }
}
