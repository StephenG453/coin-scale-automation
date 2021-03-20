# coin-scale-automation:
This is a quickly built Selenium-Cucumber automation framework written in java to automate
this web app: http://ec2-54-208-152-154.compute-1.amazonaws.com/

## Project setup:
1. Once this project is cloned into your local, run a maven clean/install to refresh the project
2. Download a chromedriver version that compatible with your current google chrome version here : https://chromedriver.chromium.org/downloads
3. inside BaseTest.java , adjust "System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");" to point to
the location of chromedriver on your local machine
   
### Notes

- This framework can easily be added into a CI/CD server like Team City or Jenkins with
user friendly and concise reporting
- Edge and sad path test cases not automated in this framework include, but are not limited to:
  1. hitting the refresh button during a test scenario
    2. Spamming the 'weigh' and 'reset' buttons
    3. attempting to input a negative number into a cell
    4. attempting to input a double digit number (or any number not in the list) into a cell
    5. attempting to input any other invalid character into a cell