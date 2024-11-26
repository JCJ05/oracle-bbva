package com.bbva.puta.lib.r083.impl;

import com.bbva.apx.exception.db.DuplicateKeyException;
import com.bbva.apx.exception.db.NoResultException;
import com.bbva.puta.dto.tb.sub1.sub2.CustomerConstant;
import com.bbva.puta.dto.tb.sub1.sub2.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The PUTAR083Impl class...
 */
public class PUTAR083Impl extends PUTAR083Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(PUTAR083Impl.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		// TODO - Implementation of business logic
	}

	@Override
	public Integer executeCreateCustomer(CustomerDTO customer) {

		LOGGER.info("[APX] call method executeCreateAccount");
		LOGGER.info("[APX-R1] data customer : {}", customer);
		int iResultSQL = 0;
		validEmail(customer.getEmail());
		if (this.getAdviceList().isEmpty()){
			Map<String, Object> requestSQL = new HashMap<>();
			requestSQL.put("customerId", customer.getCustomerId());
			requestSQL.put("firstName", customer.getFirstName());
			requestSQL.put("lastName", customer.getLastName());
			requestSQL.put("gender", customer.getGender());
			requestSQL.put("documentNumber", customer.getDocumentNumber());
			requestSQL.put("documentType", customer.getDocumentType());
			requestSQL.put("birthDate", customer.getBirthDate());
			requestSQL.put("address", customer.getAddress());
			requestSQL.put("nationality", customer.getNationality());
			requestSQL.put("email", customer.getEmail());

			LOGGER.info("[APX-R2] Map Save Record customer: {}", requestSQL);

			try{
				LOGGER.info("[APX-R3] Access jdbcUtils ");
				iResultSQL = this.jdbcUtils.update(CustomerConstant.SQL_INSERT_CUSTOMER, requestSQL);
			} catch (DuplicateKeyException duplicateKeyException) {
				LOGGER.info(String.format("[APX-R4] Error, customer id is already registered : {}", duplicateKeyException.getMessage()));
				this.addAdvice(CustomerConstant.ERR_EXISTE_DATA);
			} catch (NoResultException noResultException) {
				LOGGER.info(String.format("[APX-R5] Error de procesamiento : {}", noResultException.getMessage()));
				this.addAdvice(CustomerConstant.ERR_NO_RESULT);
			}
			LOGGER.info("[APX-R6] Customer registration result  : {}", iResultSQL);
			return iResultSQL;
		}


		return null;
	}

	private void validEmail(final String email){
		LOGGER.info("[APX] call method validEmail");
		String regx = "^[A-Za-z0-9+_.-]+@(.+)$";
		LOGGER.info("[APX validEmail - R1] data email : {}", email);
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher  = pattern.matcher(email);
		if (!matcher.matches()){
			LOGGER.info("email {} is not valid", email);
			this.addAdvice(CustomerConstant.ERR_PARAMETERS_EMAIL);
		}
	}
}
