/**
 * Michael Soto
 * Southern New Hampshire University
 * Professor Jonathan Norman
 * CS-320 Software Test, Automation QA
 * April 11, 2026
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    // Test successful creation of a Contact with valid fields
    @Test
    void testContactCreationSuccess() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("FirstName", contact.getFirstName());
        assertEquals("LastName", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Contact ID tests
    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "FirstName", "LastName", "1234567890", "123 Main St");
        });
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "FirstName", "LastName", "1234567890", "123 Main St");
        });
    }

    // First name tests
    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "12345678901", "LastName", "1234567890", "123 Main St");
        });
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "LastName", "1234567890", "123 Main St");
        });
    }

    // Last name tests
    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "FirstName", "12345678901", "1234567890", "123 Main St");
        });
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "FirstName", null, "1234567890", "123 Main St");
        });
    }

    // Phone tests (must be exactly 10 digits)
    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "FirstName", "LastName", "123456789", "123 Main St");
        });
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "FirstName", "LastName", "12345678901", "123 Main St");
        });
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "FirstName", "LastName", null, "123 Main St");
        });
    }

    // Address tests
    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "FirstName", "LastName", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "FirstName", "LastName", "1234567890", null);
        });
    }

    // Setter tests — firstName
    @Test
    void testSetFirstName() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        contact.setFirstName("NewFirst");
        assertEquals("NewFirst", contact.getFirstName());
    }

    @Test
    void testSetFirstNameTooLong() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("12345678901");
        });
    }

    @Test
    void testSetFirstNameNull() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    // Setter tests — lastName
    @Test
    void testSetLastName() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        contact.setLastName("NewLast");
        assertEquals("NewLast", contact.getLastName());
    }

    @Test
    void testSetLastNameTooLong() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("12345678901");
        });
    }

    @Test
    void testSetLastNameNull() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    // Setter tests — phone
    @Test
    void testSetPhone() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void testSetPhoneTooShort() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123456789");
        });
    }

    @Test
    void testSetPhoneTooLong() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345678901");
        });
    }

    @Test
    void testSetPhoneNull() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    // Setter tests — address
    @Test
    void testSetAddress() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    void testSetAddressTooLong() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901");
        });
    }

    @Test
    void testSetAddressNull() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
}
