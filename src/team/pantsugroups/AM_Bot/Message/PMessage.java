package team.pantsugroups.AM_Bot.Message;

public class PMessage {
    private String act;
    private String QQID;
    private String msg;
    public String getAct() {
        return act;
    }
    public void setAct(String act) {
        this.act = act;
    }
    public String getQQID() {
    	return QQID;
    }
    public void setQQID(String QQID) {
    	this.QQID = QQID;
    }
    public String getMsg() {
    	return msg;
    }
    public void setMsg(String msg) {
    	this.msg = msg;
    }
}