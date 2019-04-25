package team.pantsugroups.AM_Bot.main;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import com.google.gson.Gson;

import team.pantsugroups.AM_Bot.Message.GMessage;
import team.pantsugroups.AM_Bot.Message.PMessage;

public class Bot extends WebSocketClient{
	
	SimpleDateFormat dfa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat dfs = new SimpleDateFormat("HH:mm:ss");

	public Bot(URI serverUri, Draft draft) {
		
		super(serverUri, draft);
		
	}
	
	public void onOpen(ServerHandshake arg0){
		
		System.out.println("Bot Server Start at: "+dfa.format(new Date()));
		
	}

	public void onClose(int arg0, String arg1, boolean arg2) {
		
		System.out.println("Bot Stop at: "+dfa.format(new Date()));
		
	}

	public void onError(Exception arg0) {
		
		System.out.println("Bot Server Get Error at: "+dfa.format(new Date()));
		
	}

	public void onMessage(String json) {
		
		QQMessage receiveMessage = (QQMessage) new Gson().fromJson(json, QQMessage.class);
		
		String qID = receiveMessage.getFromQQ();
		String groupid = receiveMessage.getFromGroup();
		String msg = receiveMessage.getMsg();
		
		PMessage p = new PMessage();
		GMessage g = new GMessage();
		
		if(groupid != null) {
			g.setAct("101");
			g.setGID(groupid);
			g.setMsg("收到群信息来自:"+qID+"信息为："+"\n"
			+msg);
			
			String ms = new Gson().toJson(g);
			send(ms);
		}
		else {
			p.setAct("106");
			p.setQQID(qID);
			p.setMsg("收到信息"+"信息为："+"\n"
					+msg);
			
			String ms = new Gson().toJson(p);
			send(ms);
		}
	}
}