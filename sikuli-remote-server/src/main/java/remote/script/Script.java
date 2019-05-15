package remote.script;

public class Script {

    private String name;
    private ScriptStatus status;
    private String commands;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ScriptStatus getStatus() {
        return status;
    }
    public void setStatus(ScriptStatus status) {
        this.status = status;
    }
    public String getCommands() {
        return commands;
    }
    public void setCommands(String commands) {
        this.commands = commands;
    }
    
}
