package it.unibo.radarSystem22_4.comm.interfaces;

public interface Interaction2021  {	 
	public void forward(  String msg ) throws Exception;
	public String request(  String msg ) throws Exception;
 	public void reply(  String reqid ) throws Exception;
 	public String receiveMsg(  ) throws Exception ;
	public void close( )  throws Exception;
}
