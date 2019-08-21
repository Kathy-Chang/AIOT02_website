package mqtt;

// sudo systemctl enable mosquitto.service
//sudo systemctl stop mosquitto
// service mosquitto status
//
// mosquitto_sub -h 192.168.1.128 -t ceiling/test
// 


//import org.eclipse.paho.String;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class mqtt {

    private String topic        = "test_04";
    private String content      = "go";
    private int qos             = 2;
    //private String broker       = "tcp://192.168.137.11:1883";
    private String broker       = "tcp://192.168.21.73:1883";
    private String clientId     = "";
    private MemoryPersistence persistence = new MemoryPersistence();
    
    public mqtt() {}
    
    
    public mqtt(String broker,String topic, String content){
	this.broker = broker;
	this.topic = topic;
	this.content = content;
	}
    
    public void publish() {
    	try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            //sampleClient.disconnect();
            //System.out.println("Disconnected");
            //System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
        
    }
    
}
