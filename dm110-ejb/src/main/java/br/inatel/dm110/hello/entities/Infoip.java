package br.inatel.dm110.hello.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_infoip", sequenceName = "seq_infoip", allocationSize = 1)
public class Infoip {

	@Id
	@GeneratedValue(generator = "seq_infoip", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String ip;
	private boolean status;
	
	public String getIp() {
		return ip;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
