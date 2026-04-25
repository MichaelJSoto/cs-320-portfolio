/**
 * Michael Soto
 * Southern New Hampshire University
 * Professor Jonathan Norman
 * CS-320 Software Test, Automation QA
 * April 11, 2026
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    // Requirement 1: Add contacts with a unique ID
    @Test
    void testAddContact() {
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        service.addContact(contact);
        // No exception means it was added successfully
    }

    @Test
    void testAddDuplicateContact() {
        Contact contact1 = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Doe", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // Requirement 2: Delete contacts per contact ID
    @Test
    void testDeleteContact() {
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1234567890");
        // No exception means it was deleted successfully
    }

    @Test
    void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("nonexistent");
        });
    }

    // Requirement 3: Update contact fields per contact ID
    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("1234567890", "NewFirst");
    }

    @Test
    void testUpdateLastName() {
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateLastName("1234567890", "NewLast");
    }

    @Test
    void testUpdatePhone() {
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updatePhone("1234567890", "0987654321");
    }

    @Test
    void testUpdateAddress() {
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateAddress("1234567890", "456 Elm St");
    }

    @Test
    void testUpdateContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("nonexistent", "Name");
        });
    }
}
