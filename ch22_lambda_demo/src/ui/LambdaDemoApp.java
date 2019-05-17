package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import business.Contact;
import business.TestContact;

public class LambdaDemoApp {

	public static void main(String[] args) {
		List<Contact> contacts = new ArrayList<>();
		
		System.out.println("Hello");
		
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		// no lambda: pull contacts with no email address:
		List<Contact> contactsWithoutEmail = new ArrayList<>();
		for (Contact c : contacts) {
			if (c.getEmail() == null) {
				contactsWithoutEmail.add(c);
			}
		}
		
		System.out.println("Contacts with no email (no lambda):");
		for (Contact c : contactsWithoutEmail) {
			System.out.println(c);
		}
		
		// no lambda: contacts without phone
		List<Contact> contactsWithoutPhone = new ArrayList<>();
		for (Contact c : contacts) {
			if (c.getPhone() == null) {
				contactsWithoutPhone.add(c);
			}
		}
		
		System.out.println("Contacts with no phone (no lambda):");
		for (Contact c : contactsWithoutPhone) {
			System.out.println(c);
		}
		
		//using lambdas
		System.out.println("Lambdas!");
		System.out.println("Contacts with no phone:");
		contactsWithoutPhone = filterContacts(contacts, c -> c.getPhone() == null);
		
		for(Contact c : contactsWithoutPhone) {
			System.out.println(c);
		}
		
		//using lambdas
		System.out.println("Lambdas!");
		System.out.println("Contacts with no email:");
		contactsWithoutEmail = filterContacts(contacts, c -> c.getEmail() == null);
		
		for(Contact c : contactsWithoutEmail) {
			System.out.println(c);
		}
		
		
		System.out.println("Goodbye!");

	}
	
	private static List<Contact> filterContacts(List<Contact> contacts,
			Predicate<Contact> condition) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact c : contacts) {
			if (condition.test(c)) {
				filteredContacts.add(c);
			}
		}
		
		return filteredContacts;
	}

}
