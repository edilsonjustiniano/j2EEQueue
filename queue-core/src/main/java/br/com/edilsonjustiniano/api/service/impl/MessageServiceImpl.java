package br.com.edilsonjustiniano.api.service.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.com.edilsonjustiniano.api.service.MessageService;
import br.com.edilsonjustiniano.ejb.service.MessageEJBServiceRemote;
import br.com.edilsonjustiniano.j2ee.calculator.api.entity.Message;

@RequestScoped
public class MessageServiceImpl implements MessageService {

	@EJB(lookup = "java:app/queue-ejb-1.0.0-SNAPSHOT/MessageBean!br.com.edilsonjustiniano.ejb.service.MessageEJBServiceRemote")
	private MessageEJBServiceRemote messageRemoteBean;

	@Override
	public void sendMessage(Message msg) {
		System.out.println("Message name: " + msg.getName() + " message description: " + msg.getDescription());
		messageRemoteBean.redirectMessage(msg);
	}

}
