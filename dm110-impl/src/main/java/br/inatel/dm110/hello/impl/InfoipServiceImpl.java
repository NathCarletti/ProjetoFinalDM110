package br.inatel.dm110.hello.impl;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.control.InfoipDBService;
import br.inatel.dm110.hello.interfaces.InfoipdbRemote;

@RequestScoped
public class InfoipServiceImpl implements InfoipDBService{
	
	@EJB(lookup = "java:app/dm110-ejb-0.1-SNAPSHOT/InfoipbdBeans!br.inatel.dm110.hello.interfaces.InfoipdbRemote")
	private InfoipdbRemote infoipdbBean;

	@Override
	public boolean showStatusIp(String ip) {
		System.out.println("status impl "+ip);
		
		if(infoipdbBean == null) {
			System.out.println("NULL");
		} else {
			System.out.println("NOT NULL");
		}
		return infoipdbBean.showStatusIp(ip);
	}

	@Override
	public void sendIPMask(String ip, String mask) {
		NetworkIpGen ipGen = new NetworkIpGen();
		String[] ips = ipGen.generateIps(ip, Integer.parseInt(mask));
		/*for(String i:ips) {
			TestRuntime test = new TestRuntime();
			boolean t = test.execPing(i);*/

			infoipdbBean.showInfoIp(ips);
		
	}

}
