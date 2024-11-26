package com.bbva.puta;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.puta.dto.tb.sub1.sub2.CustomerDTO;
import com.bbva.puta.lib.r083.PUTAR083;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create Customer
 *
 */
public class PUTAT08301PETransaction extends AbstractPUTAT08301PETransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(PUTAT08301PETransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		PUTAR083 papxR083 = this.getServiceLibrary(PUTAR083.class);
		LOGGER.info("[APX-1] Instancia PAPXR002  : {}", papxR083);

		CustomerDTO oRequest = this.getEntitycustomer();
		Integer idCustomer;

		if (oRequest == null) {
			LOGGER.warn("[APX-2] CustomerDTO es null");
			idCustomer = null;
		} else {
			LOGGER.info("[APX-2] CustomerDTO : {}", oRequest.toString());
			idCustomer = papxR083.executeCreateCustomer(oRequest);
			LOGGER.info("[APX-3] idCustomer  : {}", idCustomer);
		}


		if (idCustomer == null) {

			LOGGER.info("[APX-4] Save Not Success id : {}", idCustomer);
			this.setSeverity(Severity.ENR);

		} else if(!this.getAdviceList().isEmpty()) {
			LOGGER.info("[APX-5] Save Not Success id : {}", idCustomer);
			this.setSeverity(Severity.EWR);
		} else {
			LOGGER.info("[APX-6] Save Success :{}", idCustomer);
			this.setSeverity(Severity.OK);
		}

	}

}
