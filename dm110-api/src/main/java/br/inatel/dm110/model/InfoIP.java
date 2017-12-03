package br.inatel.dm110.model;

import java.io.Serializable;

public class InfoIP implements Serializable {
	

	private static final long serialVersionUID = -5257137523889483239L;
	private Integer id;
	private String ip;
	private boolean status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
