package com.chase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name="Clients")
public class Client 
{
	@Id
	@GeneratedValue()
	private long clientId;
	private String clientName;
	private String clientAddress;
	protected boolean clientStatus;
	
	public Client() {
		super();
	}
	
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public boolean isClientStatus() {
		return clientStatus;
	}
	public void setClientStatus(boolean clientStatus) {
		this.clientStatus = clientStatus;
	}
	public void addUser() {
		clientName = "Ashwanth";
	}
	public void display() {
		System.out.println(clientName);
	}
	
	
	
}
