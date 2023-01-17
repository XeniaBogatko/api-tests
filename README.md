# Test automation project for [reqres.in](https://reqres.in/)

##	Content

- [Technologies and tools](#technologist-technologies-and-tools)
- [Implemented checks](#bookmark_tabs-implemented-checks)
- [Running tests from the terminal](#computer-running-tests-from-the-terminal)
- [Running tests in Jenkins](#-running-tests-in-jenkins)
- [Test results report in Allure Report](#-test-results-report-in-Allure-report)
- [Integration with Allure TestOps](#-integration-with-allure-testops)
- [Telegram notifications using a bot](#-telegram-notifications-using-a-bot)

## :technologist: Technologies and tools
<p  align="center">
<code><img width="5%" title="IntelliJ IDEA" src="media/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="media/logo/Java.svg"></code>
<code><img width="5%" title="Gradle" src="media/logo/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="media/logo/Junit5.svg"></code>
<code><img width="5%" title="RestAssured" src="media/logo/RestAssured.svg"></code>
<code><img width="5%" title="Allure Report" src="media/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="media/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="media/logo/Jenkins.svg"></code>
<code><img width="5%" title="Telegram" src="media/logo/Telegram.svg"></code>
</p>

## :bookmark_tabs: Implemented checks:

- Get an user by id number
- User not found by not existed id number
- Check that user is created with correct data
- Check unsuccessful user creation
- Delete an user by id number

## :computer: Running tests from the terminal

```bash
gradle clean test
```

## <img width="4%" title="Jenkins" src="media/logo/Jenkins.svg"> Running tests in [Jenkins](https://jenkins.autotests.cloud/job/xenia_api_tests/)

Click the button <code><strong>*Collect*</strong></code> to start the build.

<p align="center">
  <img src="media/jenkins.png" alt="Jenkins" width="800">
</p>

After build is completed, in the <code><strong>*Builds history*</strong></code> opposite the build number will appear the *Allure Report* icon, clicking on which will open the page with the generated html-report.

## <img width="4%" title="Allure Report" src="media/logo/Allure.svg"> Test results report in [Allure Report](https://jenkins.autotests.cloud/job/xenia_api_tests/1/allure/)

<p align="center">
  <img src="media/allure-report.png" alt="allure-report" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="media/logo/Allure_TO.svg"> Integration with [Allure TestOps](https://allure.autotests.cloud/launch/18447)

### Main dashboard

<p align="center">
  <img src="media/dashboard.png" alt="dashboard" width="900">
</p>

### List of tests with run results

<p align="center">
  <img src="media/tree.png" alt="tree" width="900">
</p>

## <img width="4%" title="Telegram" src="media/logo/Telegram.svg"> Telegram notifications using a bot
After the build is completed, a special bot created in Telegram, automatically processes and sends a test run report message.

<p align="center">
<img title="Telegram Notifications" src="media/telegram.png">