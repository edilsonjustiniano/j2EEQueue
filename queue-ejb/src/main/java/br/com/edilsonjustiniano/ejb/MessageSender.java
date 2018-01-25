package br.com.edilsonjustiniano.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import br.com.edilsonjustiniano.j2ee.calculator.api.entity.Message;

@Stateless
public class MessageSender {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/queue/exampleQueue")
	private Queue queue;

	@Resource(lookup = "java:/jms/topic/exampleTopic")
	private Topic topic;

	public void sendMessage(Message message) {
		try (Connection connection = connectionFactory.createConnection();
				Session session = connection.createSession();
				MessageProducer producer = session.createProducer(queue);) {
			ObjectMessage objectMessage = session.createObjectMessage(message);
			producer.send(objectMessage);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
