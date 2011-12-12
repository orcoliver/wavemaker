/*
 Copyright  2002-2007 MySQL AB, 2008 Sun Microsystems

 This program is free software; you can redistribute it and/or modify
 it under the terms of version 2 of the GNU General Public License as 
 published by the Free Software Foundation.

 There are special exceptions to the terms and conditions of the GPL 
 as it is applied to this software. View the full text of the 
 exception in file EXCEPTIONS-CONNECTOR-J in the directory of this 
 software distribution.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA



 */
package com.mysql.jdbc;

import java.sql.SQLException;

/**
 * An exception to represent communications errors with the database.
 * 
 * Attempts to provide 'friendler' error messages to end-users, including last
 * time a packet was sent to the database, what the client-timeout is set to,
 * and whether the idle time has been exceeded.
 * 
 * @author Mark Matthews
 * 
 * @version $Id: CommunicationsException.java,v 1.1.2.1 2005/05/13 18:58:37
 *          mmatthews Exp $
 */
public class CommunicationsException extends SQLException implements StreamingNotifiable {

	
	private String exceptionMessage = null;

	private boolean streamingResultSetInPlay = false;
	
	private ConnectionImpl conn;
	private long lastPacketSentTimeMs;
	private long lastPacketReceivedTimeMs;
	private Exception underlyingException;

	public CommunicationsException(ConnectionImpl conn, long lastPacketSentTimeMs,
			long lastPacketReceivedTimeMs, Exception underlyingException) {
		
		// store this information for later generation of message
		this.conn = conn;
		this.lastPacketReceivedTimeMs = lastPacketReceivedTimeMs;
		this.lastPacketSentTimeMs = lastPacketSentTimeMs;
		this.underlyingException = underlyingException;
		
		if (underlyingException != null) {
			initCause(underlyingException);
		}
	}

	

	
	public String getMessage() {
		// Get the message at last possible moment, but cache it 
		// and drop references to conn, underlyingException
		if(this.exceptionMessage == null){
			this.exceptionMessage = SQLError.createLinkFailureMessageBasedOnHeuristics(this.conn,
					this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, this.underlyingException, 
					this.streamingResultSetInPlay);
			this.conn = null;
			this.underlyingException = null;
		}
		return this.exceptionMessage;
	}

	
	public String getSQLState() {
		return SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE;
	}

	
	public void setWasStreamingResults() {
		this.streamingResultSetInPlay = true;
	}

}