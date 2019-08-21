
package mqtt;
 
 
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;  
import org.eclipse.paho.client.mqttv3.MqttMessage;  
  

public class PushCallback implements MqttCallback {  
	public static String msg = "";
    public void connectionLost(Throwable cause) {  

        System.out.println("connection lost");  
    }  
    
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete---------" + token.isComplete());  
    }
 
    public void messageArrived(String topic, MqttMessage message) throws Exception {
  
//        System.out.println("topic : " + topic);  
//        System.out.println("message.getQos: " + message.getQos());  
//        System.out.println("message.getPayload: " + new String(message.getPayload()));  
        msg = new String(message.getPayload());
        
    }
   
    public static String getmsg() {
    	return msg;
    }

}

