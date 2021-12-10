/**
 * 
 */
package com.anwar.phonebook.bindings;

import java.time.LocalDate;

import lombok.Data;

/**
 * @author MD MOZAMMIL ANWAR
 *
 */
@Data
public class ContactForm {
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private String contactNumber;
	private Boolean isActive;
	private LocalDate createdDate;
	private LocalDate updatedDate;
}
