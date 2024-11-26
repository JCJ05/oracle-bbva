package com.bbva.puta.dto.tb.sub1.sub2;

import java.io.Serializable;
import java.util.Date;


/**
 * The CustomerDTO class...
 */
public class CustomerDTO implements Serializable  {
	private static final long serialVersionUID = 2931699728946643245L;

	private String customerId;
	private String firstName;
	private String lastName;
	private String gender;
	private String documentNumber;
	private String documentType;
	private Date birthDate;
	private String address;
	private String nationality;
	private String email;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerDTO{" +
				"customerId='" + customerId + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender='" + gender + '\'' +
				", documentNumber='" + documentNumber + '\'' +
				", documentType='" + documentType + '\'' +
				", birthDate=" + birthDate +
				", address='" + address + '\'' +
				", nationality='" + nationality + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
