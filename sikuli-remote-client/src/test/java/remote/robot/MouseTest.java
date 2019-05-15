package remote.robot;

import org.json.JSONException;
import org.testng.annotations.Test;

import remote.client.Relative;
import remote.client.RemoteScreen;
import remote.script.TargetType;

public class MouseTest {
  @Test
  public void click() throws JSONException {
      RemoteScreen remoteScreen = new RemoteScreen("localhost");
      Mouse find = remoteScreen.find("test.jpg", TargetType.ImageTarget);
      find.click(Relative.center);
  }
}
