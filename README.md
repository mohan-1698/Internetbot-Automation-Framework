# InternetBot Automation

## Project Overview

InternetBot Automation is a **Selenium-based test automation framework** designed to automate testing for various web UI modules. The project uses **TestNG** for test execution and reporting, following the **Page Object Model (POM)** design pattern to ensure maintainability and scalability.

This framework automates testing for key web application features including:
- User authentication (Login)
- Alert handling
- Checkbox interactions
- Dropdown selections
- File uploads
- Dynamic element interactions

---

## Key Features

-  **Selenium 4.34.0** - Latest WebDriver API for web automation
-  **TestNG 7.10.2** - Powerful testing framework with parallel execution support
-  **WebDriverManager 5.9.2** - Automatic driver management
-  **Apache POI 5.4.1** - Excel file handling for test data
-  **Extent Reports 5.1.1** - Rich HTML test reporting
-  **Parallel Test Execution** - Run multiple tests concurrently (5 threads)
-  **Screenshot Capture** - Automatic screenshots on test failures
-  **Configuration Management** - Externalized configuration via ConfigReader
-  **Custom Listeners** - Event-driven test execution monitoring

---

## Technologies Used

| Technology | Version | Purpose |
|---|---|---|
| Java | - | Programming Language |
| Selenium | 4.34.0 | Web UI Automation |
| TestNG | 7.10.2 | Test Framework |
| Maven | - | Build Tool |
| WebDriverManager | 5.9.2 | Driver Management |
| Apache POI | 5.4.1 | Excel Handling |
| Extent Reports | 5.1.1 | HTML Reporting |

---

## Project Structure

```
internetbot-automation/
│
├── pom.xml                                         # Maven configuration & dependencies
├── testng.xml                                      # TestNG suite configuration
├── README.md                                       # Project documentation
├── .gitignore                                      # Git ignore rules
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/srm/hackathon/internetbot/
│   │   │       ├── base/
│   │   │       │   └── BasePage.java               # Base page class for page objects
│   │   │       │
│   │   │       ├── factory/
│   │   │       │   ├── DriverFactory.java          # Driver factory pattern
│   │   │       │   └── DriverManager.java          # WebDriver instance management
│   │   │       │
│   │   │       ├── pages/
│   │   │       │   ├── LoginPage.java              # Login page object model
│   │   │       │   ├── HomePage.java               # Home page object model
│   │   │       │   ├── AlertPage.java              # Alert handling page object
│   │   │       │   ├── CheckboxPage.java           # Checkbox interactions page object
│   │   │       │   ├── DropdownPage.java           # Dropdown selections page object
│   │   │       │   ├── UploadPage.java             # File upload page object
│   │   │       │   ├── DynamicPage.java            # Dynamic elements page object
│   │   │       │   └── SecureAreaPage.java         # Secure area page object
│   │   │       │
│   │   │       └── utils/
│   │   │           ├── ConfigReader.java           # Read configuration properties
│   │   │           ├── ScreenshotUtil.java         # Screenshot capture utility
│   │   │           └── ExtentManager.java          # Extent Reports configuration
│   │   │
│   │   └── resources/
│   │       └── config.properties                   # Application configuration
│   │
│   └── test/
│       ├── java/
│       │   └── com/srm/hackathon/internetbot/
│       │       ├── base/
│       │       │   └── BaseTest.java               # Base test class (setup/teardown)
│       │       │
│       │       ├── listeners/
│       │       │   └── TestListener.java           # TestNG listener for test events
│       │       │
│       │       └── tests/
│       │           ├── LoginTest.java              # Authentication & login tests
│       │           ├── AlertTest.java              # Alert handling tests
│       │           ├── CheckboxTest.java           # Checkbox interaction tests
│       │           ├── DropdownTest.java           # Dropdown selection tests
│       │           ├── UploadTest.java             # File upload tests
│       │           └── DynamicTest.java            # Dynamic element tests
│       │
│       └── resources/
│           └── testdata/
│               ├── sample.txt                      # Sample test data file
│               └── sample.bat                      # Sample batch file
│
├── reports/
│   └── extent-report.html                          # Extent HTML report (generated)
│
├── screenshots/
│   ├── testInvalidLogin_20_20260417_134540.png     # Test failure screenshots
│   └── testSelectOption1_24_20260417_152145.png    # Test failure screenshots
│
├── test-output/                                    # TestNG generated reports
│   ├── index.html                                  # Main TestNG report
│   ├── emailable-report.html                       # Emailable test report
│   ├── testng-failed.xml                           # Failed tests XML
│   ├── testng-results.xml                          # Test results XML
│   ├── testng-reports.css                          # Report styling
│   ├── testng-reports.js                           # Report scripts
│   ├── testng-reports1.css                         # Additional styling
│   ├── testng-reports2.js                          # Additional scripts
│   │
│   ├── Default suite/                              # Default suite reports
│   │   └── Default test.html & .xml
│   │
│   ├── InternetBot Suite/                          # Custom suite reports
│   │   ├── Alert Tests.html & .xml
│   │   ├── Checkbox Tests.html & .xml
│   │   ├── Dropdown Tests.html & .xml
│   │   ├── Dynamic Tests.html & .xml
│   │   ├── Login Tests.html & .xml
│   │   ├── Upload Tests.html & .xml
│   │   ├── All Tests.html & .xml
│   │   └── testng-failed.xml
│   │
│   ├── junitreports/                               # JUnit format reports
│   │   └── TEST-*.xml (for each test class)
│   │
│   └── (other report assets: images, scripts)
│
├── target/                                         # Build output directory
│   ├── classes/
│   │   ├── config.properties                       # Compiled config
│   │   ├── com/srm/hackathon/internetbot/          # Compiled main classes
│   │   └── META-INF/                               # Maven metadata
│   │
│   ├── test-classes/
│   │   ├── com/srm/hackathon/internetbot/          # Compiled test classes
│   │   └── testdata/                               # Test data resources
│   │
│   ├── generated-sources/annotations/              # Generated annotation sources
│   ├── generated-test-sources/test-annotations/    # Generated test annotation sources
│   │
│   ├── maven-status/                               # Maven compiler status
│   │   └── maven-compiler-plugin/
│   │       ├── compile/
│   │       └── testCompile/
│   │
│   └── surefire-reports/                           # Surefire test reports
│       ├── TEST-*.xml (each test class)
│       └── (HTML reports & assets)
```

---

## Module Overview

### 1. **Login Tests** (`LoginTest.java`)
   - Test valid user login
   - Test invalid credentials
   - Test session management

### 2. **Alert Tests** (`AlertTest.java`)
   - Handle simple JavaScript alerts
   - Dismiss and accept alert boxes
   - Extract alert messages

### 3. **Checkbox Tests** (`CheckboxTest.java`)
   - Select/deselect checkboxes
   - Verify checkbox states
   - Multiple checkbox handling

### 4. **Dropdown Tests** (`DropdownTest.java`)
   - Select by visible text
   - Select by value
   - Select by index
   - Verify dropdown options

### 5. **Upload Tests** (`UploadTest.java`)
   - File upload functionality
   - Multiple file uploads
   - Validate uploaded files

### 6. **Dynamic Tests** (`DynamicTest.java`)
   - Handle dynamically loaded elements
   - Wait for element visibility
   - Interact with AJAX-based elements

---

## Setup & Installation

### Prerequisites
- **Java 8+** installed and configured
- **Maven 3.6+** installed
- **Chrome/Firefox/Edge** browser installed

### Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-repo/internetbot-automation.git
   cd internetbot-automation
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

3. **Configure Application URL**
   Edit `src/main/resources/config.properties`:
   ```properties
   app.url=https://your-application-url
   browser=chrome
   ```

4. **Run Tests**
   ```bash
   mvn test
   ```

5. **View Reports**
   - Extent Report: `reports/extent-report.html`
   - TestNG Report: `test-output/index.html`

---

## Test Execution

### Run All Tests
```bash
mvn test
```

### Run Specific Test Suite
```bash
mvn test -Dsuite=testng.xml
```

### Run Specific Test Class
```bash
mvn test -Dtest=LoginTest
```

### Run Tests in Parallel
The framework is configured to run 5 tests in parallel by default. This is set in `testng.xml`:
```xml
<suite name="InternetBot Suite" parallel="tests" thread-count="5">
```

---

## Configuration

### `config.properties` (Main Configuration)
```properties
# Base URL
app.url=https://your-application-url

# Browser Configuration
browser=chrome
headless.mode=false

# Timeout (in seconds)
implicit.wait=10
explicit.wait=15

# Screenshot Settings
take.screenshot=true
screenshot.on.failure=true

# Reporting
extent.report.path=reports/extent-report.html
```

---

## Test Data

Test data is maintained in Excel files (`src/test/resources/test-data.xlsx`):
- Column A: Test Case ID
- Column B: Test Data
- Column C: Expected Result

The `ExcelUtil` utility class reads and provides data to tests.

---

## Reporting

### Extent Reports
- **Location**: `reports/extent-report.html`
- **Features**: Screenshots, execution timeline, test categorization
- **Generated**: Automatically after test execution

### TestNG Reports
- **Location**: `test-output/index.html`
- **Features**: Test results, execution summary, pass/fail statistics

---

## Best Practices

1.  Follow **Page Object Model (POM)** pattern
2.  Use **meaningful test method names**
3.  Implement **proper waits** instead of Thread.sleep()
4.  Use **data-driven testing** for multiple scenarios
5.  Maintain **test independence** - tests should not depend on each other
6.  Capture **screenshots on failures** for debugging
7.  Use **custom listeners** for test event handling
8.  Keep **configurations externalized** in property files

---

## Troubleshooting

| Issue | Solution |
|---|---|
| **WebDriver not found** | Run `mvn clean install` to download dependencies |
| **Element not found** | Increase wait time or check element locators |
| **Stale element reference** | Re-locate the element or refresh the page |
| **Port already in use** | Kill the process or use a different port |
| **Screenshot not captured** | Verify write permissions in screenshot folder |

---

## Team & Support

**Project Lead**: SRM Hackathon Team

For issues or questions:
- Create an issue in the repository
- Contact the development team

---

## License

This project is proprietary and intended for SRM Hackathon use only.

---

**Last Updated**: April 17, 2026
