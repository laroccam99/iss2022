package it.unibo.radarSystem22_4.comm;

import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import it.unibo.radarSystem22_4.comm.interfaces.IApplMessage;
import it.unibo.radarSystem22_4.comm.interfaces.Interaction2021;
import it.unibo.radarSystem22_4.comm.utils.ColorsOut;



public class ApplMessage implements IApplMessage {
    protected String msgId       = "";
    protected String msgType     = null;
    protected String msgSender   = "";
    protected String msgReceiver = "";
    protected String msgContent  = "";
    protected int msgNum         = 0;
    
    protected Interaction2021 conn;		//not null for request
	
	public ApplMessage( 
			String MSGID, String MSGTYPE, String SENDER, String RECEIVER, String CONTENT, String SEQNUM ) {
        msgId 		= MSGID;
        msgType 	= MSGTYPE;
        msgSender 	= SENDER;
        msgReceiver = RECEIVER;
        msgContent 	= CONTENT;
        msgNum      = Integer.parseInt(SEQNUM);		
	}
	
	public void setConn( Interaction2021 conn ) {
		if( isRequest() ) this.conn = conn;
		else ColorsOut.out("WARNING: setting conn in a non-request message");
	}
	public Interaction2021 getConn(   ) {
		return conn;
	}	
	
    public ApplMessage( String msg ) {
        //msg( MSGID, MSGTYPE, SENDER, RECEIVER, CONTENT, SEQNUM )
    	Struct msgStruct = (Struct) Term.createTerm(msg);
        setFields(msgStruct);
    }
	
    private void setFields( Struct msgStruct ) {
        msgId 		= msgStruct.getArg(0).toString();
        msgType 	= msgStruct.getArg(1).toString();
        msgSender 	= msgStruct.getArg(2).toString();
        msgReceiver = msgStruct.getArg(3).toString();
        msgContent 	= msgStruct.getArg(4).toString();
        msgNum 		= Integer.parseInt(msgStruct.getArg(5).toString());
    }

    public String msgId() {   return msgId; }
    public String msgType() { return msgType; }
    public String msgSender() { return msgSender; }
    public String msgReceiver() { return msgReceiver;  }
    public String msgContent() { return msgContent;  }
    public String msgNum() { return "" + msgNum; } 
    
    
    public boolean isEvent(){
        return msgType.equals( ApplMessageType.event.toString() );
    }
    public boolean isDispatch(){
        return msgType.equals( ApplMessageType.dispatch.toString() );
    }
    public boolean isRequest(){
        return msgType.equals( ApplMessageType.request.toString() );
    }
    public boolean isInvitation(){
        return msgType.equals( ApplMessageType.invitation.toString() );
    }
    public boolean isReply(){
        return msgType.equals( ApplMessageType.reply.toString() );
    }   
    
    public String toString() {
    	return "msg($msgId,$msgType,$msgSender,$msgReceiver,$msgContent,$msgNum)"
    			.replace("$msgId",msgId).replace("$msgType",msgType)
    			.replace("$msgSender",msgSender).replace("$msgReceiver",msgReceiver)
    			.replace("$msgContent",msgContent).replace("$msgNum",""+msgNum);
    }

}
