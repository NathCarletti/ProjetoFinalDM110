package br.inatel.dm110.hello.beans;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import br.inatel.dm110.hello.dao.InfoipDAO;
import br.inatel.dm110.hello.entities.Infoip;
import br.inatel.dm110.hello.interfaces.InfoipdbLocal;
import br.inatel.dm110.hello.interfaces.InfoipdbRemote;

@Stateless
@Remote(InfoipdbRemote.class)
@Local(InfoipdbLocal.class)
public class InfoipbdBeans implements InfoipdbRemote, InfoipdbLocal {
	@EJB
	private InfoipDAO infoipDAO;

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory ConnectionFactory;

	@Resource(lookup = "java:/jsm/queue/DM110Projeto")
	private Queue queue;
	
	

	@Override
	public boolean showStatusIp(String ip) {
		System.out.println("Status");
		List<Infoip> list = infoipDAO.listAll();
		for(Infoip i:list) {
			if(i.getIp().equals(ip)) return i.getStatus();
		}
		return false;
	}

	@Override
	public void showInfoIp(String[] ips) {
		/*Infoip info = new Infoip();
		info.setIp(ip);
		info.setStatus(status);
		infoipDAO.insert(info);*/
		
		try (
				Connection connection = ConnectionFactory.createConnection();
				Session session = connection.createSession();
				MessageProducer producer = session.createProducer(queue);
		) {
			for(String ip:ips) {
			TextMessage textMessage = session.createTextMessage(ip);
			producer.send(textMessage);
			}
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	
	}
	
}