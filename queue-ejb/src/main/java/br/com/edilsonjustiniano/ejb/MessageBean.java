package br.com.edilsonjustiniano.ejb;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.edilsonjustiniano.ejb.service.MessageEJBServiceLocal;
import br.com.edilsonjustiniano.ejb.service.MessageEJBServiceRemote;
import br.com.edilsonjustiniano.j2ee.calculator.api.entity.Message;

@Stateless
@Local(MessageEJBServiceLocal.class)
@Remote(MessageEJBServiceRemote.class)
public class MessageBean implements MessageEJBServiceLocal, MessageEJBServiceRemote {

	@EJB
	private MessageSender messageSender;

	@Override
	public void redirectMessage(Message message) {
		System.out.println("session bean...");
		System.out.println("Message name: " + message.getName() + " message description: " + message.getDescription());
		messageSender.sendMessage(message);
	}
}
