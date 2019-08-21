package mqtt;
import java.util.concurrent.ScheduledExecutorService;

//import org.eclipse.paho.Exception;
import mqtt.PushCallback;
//import org.eclipse.paho.String;
import org.eclipse.paho.client.mqttv3.MqttClient;  
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;  
import org.eclipse.paho.client.mqttv3.MqttException;  
import org.eclipse.paho.client.mqttv3.MqttTopic;  
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class subMsg {
	
    public String HOST = "tcp://192.168.21.73:1883";  
    public String TOPIC = "test_03";  
    private String clientid = "client124";  
    private MqttClient client;  
    private MqttConnectOptions options;  
    private String userName = "admin";
    private String passWord = "password";
  
    private ScheduledExecutorService scheduler;  
    
    public subMsg(){}
    
    public subMsg(String host, String topic, String clientid){
		this.HOST = host;
		this.TOPIC = topic;
		this.clientid = clientid;
	}
    
    public void start() {  
        try {  
            client = new MqttClient(HOST, clientid, new MemoryPersistence());  
            options = new MqttConnectOptions();  
            options.setCleanSession(true);  
            options.setUserName(userName);  
            options.setPassword(passWord.toCharArray());  
            options.setConnectionTimeout(10);  
            options.setKeepAliveInterval(20);  
            client.setCallback(new PushCallback());  
            MqttTopic topic = client.getTopic(TOPIC);  
            // options.setWill(topic, "close".getBytes(), 2, true);  
              
            client.connect(options);  
            int[] Qos  = {2};  
            String[] topic1 = {TOPIC};  
            client.subscribe(topic1, Qos); 
            //System.out.print(PushCallback.msg);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    public String messageshow() {
    	return PushCallback.getmsg();
    }
}
