/**
 * 
 */
package com.anwar.phonebook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anwar.phonebook.entities.Contact;

/**
 * @author MD MOZAMMIL ANWAR
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
