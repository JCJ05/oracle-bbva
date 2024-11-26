package com.bbva.puta;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.puta.dto.tb.sub1.sub2.CustomerDTO;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractPUTAT08301PETransaction extends AbstractTransaction {

	public AbstractPUTAT08301PETransaction(){
	}


	/**
	 * Return value for input parameter EntityCustomer
	 */
	protected CustomerDTO getEntitycustomer(){
		return (CustomerDTO)this.getParameter("EntityCustomer");
	}
}
