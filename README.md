# CS-320 Portfolio – Software Test, Automation & QA

**Michael Soto**  
Southern New Hampshire University  
CS-320: Software Test, Automation & QA  
Professor Jonathan Norman  
Spring 2026

---

## About This Repository

This repository contains portfolio artifacts from CS-320: Software Test, Automation, and Quality Assurance. The work demonstrates skills in requirements-based software design, defensive programming, unit testing with JUnit 5, and quality assurance analysis.

### Included Files

| File | Description |
|------|-------------|
| `Contact.java` | Data model class for a contact with field-level validation |
| `ContactService.java` | Service class supporting add, delete, and update operations |
| `ContactTest.java` | JUnit 5 unit tests for the Contact class (25 tests) |
| `ContactServiceTest.java` | JUnit 5 unit tests for the ContactService class (9 tests) |
| `7-2 Project Two.docx` | Summary and Reflections Report — testing approaches, techniques, and analysis |

---

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

To ensure functionality and security, I rely on input validation, unit testing, and defensive programming applied together from the start of design. In the Contact Service project, every field in the `Contact` class is validated at the point of construction and mutation — null values are rejected and string lengths are strictly enforced against the written requirements. Making the `contactId` field `final` with no setter ensures that a contact's unique identifier can never be changed after creation, which protects data integrity at the design level rather than relying on callers to behave correctly.

On the testing side, I wrote JUnit 5 unit tests that cover both valid ("happy path") inputs and invalid boundary conditions — strings that are one character too long, strings that are one character too short, and null values for every field. Across the full project (Contact, Task, and Appointment services), this produced 71 passing tests with zero failures and 100% line coverage on all six production source files. As I described in the Project Two report, catching bugs through unit tests early in development is far cheaper than discovering them later in production (Pressman & Maxim, 2020), and that discipline is what gives me real confidence in the software rather than just hoping it works.

### How do I interpret user needs and incorporate them into a program?

Interpreting user needs starts with treating requirements as the source of truth and tracing every validation rule and test case back to a specific requirement. In this project, the requirements defined precise constraints for each field — for example, a phone number must be exactly 10 digits and a contact address cannot exceed 30 characters. Rather than treating these as suggestions, I encoded them directly into validation methods in the `Contact` class and verified each one with dedicated tests.

I also used black-box testing principles to keep my test cases grounded in what the requirements said rather than in how I happened to implement the code internally. As I noted in the Project Two report, basing tests on written requirements rather than on internal implementation knowledge is an effective guard against confirmation bias — the tendency to write tests that only confirm what you already believe works. Equivalence partitioning and boundary value analysis (Black et al., 2012) were the specific techniques I used to systematically derive test cases from the requirements, ensuring coverage of the edges where off-by-one errors are most likely to occur.

### How do I approach designing software?

My approach centers on separation of concerns, single responsibility, and designing for testability from the beginning. In the Contact Service project, I separated the data model (`Contact.java`) from the business logic (`ContactService.java`). The `Contact` class is responsible only for holding and validating its own data, while `ContactService` manages the collection and enforces uniqueness rules. This separation made it straightforward to test each class in isolation and to pinpoint exactly which layer a failure came from — because `ContactService.updateFirstName()` calls `Contact.setFirstName()`, which calls `validateFirstName()`, a bug at any point in that chain surfaces at the correct level when each layer has its own tests.

I also applied the DRY (Don't Repeat Yourself) principle by extracting repeated validation logic into private helper methods. If I had duplicated the same `if`-statement in both the constructor and the setter, a future requirement change would require updating both locations — and missing one is exactly how inconsistency bugs happen. More broadly, the Project Two report reflects how I think about the full landscape of testing approaches. Unit testing was the right fit for this in-memory service, but I also analyzed when integration testing, system testing, performance testing, and regression testing would each become necessary as a system grows. Choosing the right technique for the scope of the problem is just as important as executing it well.

---

**References**

Black, R., van Veenendaal, E., & Graham, D. (2012). *Foundations of software testing: ISTQB certification* (3rd ed.). Cengage Learning.

Calikli, G., & Bener, A. (2015). An empirical analysis of the effects of confirmation bias on software development and testing. In *Proceedings of the International Workshop on Cooperative and Human Aspects of Software Engineering* (pp. 10–13). IEEE.

Pressman, R. S., & Maxim, B. R. (2020). *Software engineering: A practitioner's approach* (9th ed.). McGraw-Hill Education.

---

*This portfolio was submitted as part of the CS-320 Module Eight Journal assignment.*
