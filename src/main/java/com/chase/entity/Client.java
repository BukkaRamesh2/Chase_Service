package com.chase.entity;

public class Client 
{
	public long clientId;
	private String clientName;
	private String clientAddress;
	protected boolean clientStatus;
	
	public String getClientName()
	{
		return this.clientName;
	}
	public void setClientName(String clientName)
	{
		this.clientName=clientName;
	}
	public long getClientId() 
	{
		return clientId;
	}
	public void setClientId(long clientId) 
	{
		this.clientId = clientId;
	}
	public String getClientAddress() 
	{
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) 
	{
		this.clientAddress = clientAddress;
	}
	public boolean isClientStatus() 
	{
		return clientStatus;
	}
	public void setClientStatus(boolean clientStatus) 
	{
		this.clientStatus = clientStatus;
	}
	
}
