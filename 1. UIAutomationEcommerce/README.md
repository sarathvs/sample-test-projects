This file describes testing of eCommerce website

Website chosen for testing: http://automationpractice.com/index.php

1. Test cases for the identified scenarios are in eCommerceTestcases.xlsx

2. Defect identified during testing is in eCommerceBugs.docx

3. Test cases are automated using Selenium tool with Java as the programming language and TestNG as the framework
The framework follows Page Object Model and uses data driven approach.

"src/com/ecommerce" folder includes
- pageobjects" package - has objects for the pages needed for the tests (following POM model)
- reusableModules" package - has modules that are reused (hides logic details from user who would create test scripts)
- "tests" package - has actual tests
- "utilities" packages - has constants defined

"lib" folder includes all dependent jars (selenium, testng, apache poi,..)

"dataFiles" folder includes xlsx files that have data for registraion, login

"test-output" folder has testng report with "emailable-report.html" having the summary report

4. To run the tests in a CI/CD pipeline, following batch/script can be added to the job pipeline:

java -cp ".\lib\*;.\out\production\eCommerce;" org.testng.TestNG testng.xml