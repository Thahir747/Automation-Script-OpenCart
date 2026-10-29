# OpenCart Test Automation Framework (Hybrid POM + Selenium WebDriver)

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.x-43B02A?style=for-the-badge&logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-FF7F00?style=for-the-badge&logo=testng&logoColor=white)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Apache%20Maven-3.9%2B-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/Docker%20Grid-Enabled-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)

An enterprise-grade, end-to-end test automation framework built for the **OpenCart** e-commerce application. The framework implements the **Page Object Model (POM)** design pattern with a hybrid data-driven architecture, supporting parallel execution, cross-browser compatibility, Docker Grid orchestration, and automated CI/CD execution via Jenkins.

---

## Architecture Overview

```text
OpenCart Automation Framework
 ├── Page Object Model (POM)       -> Decoupled page locators & user actions
 ├── Data-Driven Testing           -> Apache POI integration with testData/ Excel sheets
 ├── Cross-Browser & Grid Support  -> Local & Selenium Grid execution via Docker Compose
 ├── Test Orchestration            -> TestNG XML suites (grouping, cross-browser, master)
 ├── Reporting & Logging           -> ExtentReports, Log4j2, automated screenshot capture
 └── CI/CD Integration             -> Jenkins Freestyle pipeline automation
```

## 🛠️ Tech Stack & Dependencies

- **Language:** Java 17 / 21
- **Automation Tool:** Selenium WebDriver (`4.x`)
- **Test Runner & Framework:** TestNG (`7.x`)
- **Design Pattern:** Page Object Model (POM)
- **Data-Driven Engine:** Apache POI (`5.x`)
- **Logging:** Log4j2 (`2.x`)
- **Reporting:** ExtentReports (`5.x`)
- **Build Management:** Apache Maven (`3.9+`)
- **Containerization & Grid:** Docker & Selenium Grid
- **Utilities:** Apache Commons Lang3, Commons IO

---

## Repository Structure

```text
Automation-Script-OpenCart/
├── .github/                      # Repository metadata and workflows
├── src/
│   └── test/
│       ├── java/
│       │   └── ...               # Page objects, test cases, and utility helpers
│       └── resources/            # Config properties, log4j2.xml, test data mappings
├── testData/                     # Excel sheets for data-driven test scenarios
├── auto.sh                       # Automated Git synchronization script
├── crossbrowser.xml              # Cross-browser execution suite configuration
├── docker-compose.yaml           # Selenium Grid (Hub, Chrome, Firefox) orchestration
├── grid-docker.xml               # Remote WebDriver Grid execution suite
├── grouping.xml                  # Sanity, Regression, and Master grouping suite
├── master.xml                    # Complete master test suite
├── pom.xml                       # Maven dependencies and Surefire plugin configuration
└── README.md                     # Framework documentation
```

---

## Features & Highlights

* **Page Object Model (POM):** Ensures clean separation between test scripts and web element locators, maximizing code reusability and minimizing maintenance overhead.
* **Hybrid Data-Driven Engine:** Powered by Apache POI to parse external test datasets from the `testData/` directory.
* **Flexible TestNG XML Runners:** Pre-configured suites ready for different execution scopes:
  * `master.xml` — Executes the complete regression and end-to-end test cycle.
  * `grouping.xml` — Executes isolated test categories (Sanity, Regression, Functional).
  * `crossbrowser.xml` — Validates browser parity across Chrome, Firefox, and Edge.
  * `grid-docker.xml` — Routes test sessions through distributed remote nodes.
* **Dockerized Selenium Grid:** Includes `docker-compose.yaml` to spin up isolated container nodes for headless or scalable parallel testing.
* **Automatic Failure Artifacts:** Automatic full-page screenshot capture upon test failure to facilitate root-cause analysis.
* **CI/CD Ready:** Fully compatible with Jenkins for local and remote build automation.

---

## Prerequisites

Before running the project locally or via CI/CD, ensure the following tools are installed:

* **Java Development Kit (JDK):** Version 17 or 21 (LTS recommended)
* **Build Tool:** Apache Maven 3.8+
* **Browsers:** Google Chrome, Mozilla Firefox, Microsoft Edge (latest stable)
* **Docker Desktop:** (Optional, required only for Docker Grid execution)
* **Git:** Version 2.30+

---

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/Thahir747/Automation-Script-OpenCart.git
cd Automation-Script-OpenCart
```

### 2. Configure Execution Settings
Review or modify global run properties (e.g., target URL, default browser, execution mode) inside:
```text
src/test/resources/config.properties
```

---

## Execution Guide

### Run via Maven CLI

* **Run all tests via Maven Surefire:**
  ```bash
  mvn clean test
  ```

* **Execute a specific TestNG XML suite:**
  ```bash
  # Run Master Suite
  mvn clean test -Dsurefire.suiteXmlFiles=master.xml

  # Run Grouping Suite
  mvn clean test -Dsurefire.suiteXmlFiles=grouping.xml

  # Run Cross-Browser Suite
  mvn clean test -Dsurefire.suiteXmlFiles=crossbrowser.xml
  ```

* **Run specific groups via command line:**
  ```bash
  mvn clean test -Dgroups="Sanity"
  mvn clean test -Dgroups="Regression"
  ```

---

## Distributed Execution via Docker

To execute the test suite against a containerized Selenium Grid:

1. **Spin up the Docker Grid:**
   ```bash
   docker-compose up -d
   ```
2. **Verify Grid Hub:**
   Open [http://localhost:4444](http://localhost:4444) in your browser to confirm active browser nodes.

3. **Run Grid Suite:**
   ```bash
   mvn clean test -Dsurefire.suiteXmlFiles=grid-docker.xml
   ```

4. **Tear down containers:**
   ```bash
   docker-compose down
   ```

---

## CI/CD Jenkins Pipeline Configuration

To execute this project inside Jenkins:

1. Create a **Freestyle project** in Jenkins.
2. Select **Source Code Management** > **Git**:
   * **Repository URL:** `https://github.com/Thahir747/Automation-Script-OpenCart.git`
   * **Branch Specifier:** `*/master`
3. Under **Build Steps**, select **Invoke top-level Maven targets**:
   * **Maven Version:** Select your configured Maven installation
   * **Goals:** `clean test -Dsurefire.suiteXmlFiles=master.xml`
4. Run **Build Now** to execute the pipeline.

---

## Git Workflow Automation (`auto.sh`)

A helper synchronization shell script is included in the project root to automate local Git staging, commit generation, and remote pushing.

```bash
# Execute with auto-generated timestamp
bash auto.sh

# Or provide a custom commit message
bash auto.sh "Updated login page locators and assertion checks"
```

## 🔄 CI/CD & Live Build Validation (GitHub Actions)

To ensure continuous stability and code quality, this repository is fully integrated with **GitHub Actions**. An automated CI/CD pipeline acts as a live build check, instantly validating the framework's health against every code update.

* **Automated Trigger:** The pipeline automatically initiates on every `push` to the `master` branch.
* **Headless Execution:** Tests are compiled via Maven and executed on an ephemeral, headless `ubuntu-latest` remote runner, ensuring the framework operates flawlessly outside of local environments.
* **Live Commit Status:** The build status (Pass/Fail) is attached directly to your commit history, providing immediate feedback if a recent change breaks locators, configurations, or test assertions.
* **Artifact Retention:** Upon completion, the pipeline dynamically generates and uploads the Extent HTML report as a downloadable build artifact directly to the GitHub run dashboard.

---

## Author

* **Thahir Hussain M** — Test Automation Engineer / QA Specialist  
* **GitHub:** [@Thahir747](https://github.com/Thahir747)