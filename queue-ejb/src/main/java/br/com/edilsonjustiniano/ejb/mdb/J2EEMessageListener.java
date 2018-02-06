package br.com.edilsonjustiniano.ejb.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(name = "BookMessageHandler", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/exampleQueue") })
public class J2EEMessageListener implements MessageListener {

	@Resource
	private MessageDrivenContext mdctx;

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			ObjectMessage objMessage = (ObjectMessage) message;
			Object obj;
			try {
				obj = objMessage.getObject();
				if (obj instanceof br.com.edilsonjustiniano.j2ee.calculator.api.entity.Message) {
					br.com.edilsonjustiniano.j2ee.calculator.api.entity.Message receivedMessage = (br.com.edilsonjustiniano.j2ee.calculator.api.entity.Message) obj;
					System.out.println(receivedMessage.getName());
					System.out.println(receivedMessage.getDescription());
				}
			} catch (JMSException e) {
				//TODO: Create a custom Exception to handle it
			}
		}
	}

}