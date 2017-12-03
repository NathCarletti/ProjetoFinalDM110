package br.inatel.dm110.hello.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.inatel.dm110.hello.dao.InfoipDAO;
import br.inatel.dm110.hello.entities.Infoip;

@MessageDriven(activationConfig = {
	@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/DM110Projeto"),
	@ActivationConfigProperty(propertyName = "maxSession", propertyValue = "10")

})
public class IpMDB implements MessageListener {

	@EJB
	private InfoipDAO infoDao;
	
	
	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMes = (TextMessage) message;
				String ip = textMes.getText();
				TestRuntime textr = new TestRuntime();
				boolean stat = textr.execPing(ip);
				saveInfoip(ip, stat);
			} else {
				System.out.println("!!!!!!!!!! ERRO !!!!!!!!!!");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	
		
	}
	
	private void saveInfoip(String ip, boolean status) {
		System.out.println("#### Salvando ip...");
		Infoip infoip = new Infoip();
		infoip.setIp(ip);
		infoip.setStatus(status);
		infoDao.insert(infoip);
	}

}
