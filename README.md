**Project for automated testing of the [BluOr Bank's](https://www.bluorbank.lv/)  web application**


<img alt="BluOr Bank" src="/media/logos/bob-logo.png">

## Content:

- <a href="#tools"> Tools</a>
- <a href="#cases"> Test Cases</a>
- <a href="#autotests"> Running Automated Tests</a>
- <a href="#jenkins"> Jenkins Build</a>
- <a href="#allureReport"> Example of Allure Report</a>
- <a href="#allure"> Integration with Allure TestOps</a>
- <a href="#jira"> Integration with Jira</a>
- <a href="#tg"> Telegram notifications</a>
- <a href="#video"> Example of test execution using Selenoid</a>

____
<a id="tools"></a>
## Tools

<p align="center">
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/icons/Java.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/icons/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/icons/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/icons/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/icons/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/icons/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/icons/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/icons/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/icons/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/icons/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="media/icons/Jira.svg"></a>
</p>

____
Tests are implemented in [Java](https://www.java.com/) using the [Selenide](https://selenide.org/) framework, with [Gradle](https://gradle.org/) serving as the build tool. [JUnit5](https://junit.org) is adopted for modular testing, and [Selenoid](https://aerokube.com/selenoid/) facilitates remote test execution.

Within the [Jenkins](https://www.jenkins.io/) job, an [Allure report](https://allurereport.org/) is generated, and the results are communicated to [Telegram](https://web.telegram.org/) through a dedicated bot. The testing environment also integrates seamlessly with [Allure TestOps](https://qameta.io/) and [Jira](https://www.atlassian.com/software/jira) for comprehensive test management and issue tracking.

The Allure report for each test includes:
- Test steps and their execution results
- Screenshot of the page on the last step
- Page Source (ability to open the source page in a new tab)
- Browser console logs
- Video of the test execution.

____
<a id="cases"></a>
## :male_detective: Test Cases

Automated:
- Check top menu options in any language (Parametrized)
- Check company logo exist and verifies href in any language (Parametrized) 
- Check Internet bank login button exists and verifies href in any language (Parametrized)
- Check that 'scroll to top' element appears by scrolling page down
- Check that overdraft section contains apply button and verify it in any language (Parametrized)

Manual:
- Check main menu images are uploaded
- Check button style (color and hover/click effects)
- Check font size and style
  <a id="autotests"></a>
____
## :arrow_forward: Running Automated Tests

### Running Tests from the Terminal

Local execution. From the project's root directory, run:
```
gradle clean test //Runs all the tests
gradle clean menu_test //Runs all the tests w @Tag(RunTags.MENU))
gradle clean main_test //Runs all the tests w @Tag(RunTags.MAIN_PAGE))
```
____
<a id="jenkins"></a>
## <img width="10%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> </a> Jenkins Build <a target="_blank" href="https://jenkins.autotests.cloud/job/BirdsAutotests/"> [Link] </a>

Registration on the [Jenkins](https://jenkins.autotests.cloud/) resource is required for access to Jenkins.

To start the build, go to the "Build with parameters" section, select the necessary parameters, and click "Build".
### Jenkins Build Parameters:
- TASK (set of tests to run)
- URL (tested base url)
- SELENOID (address of the remote host for test execution)
- SIZE (browser window size, 1920x1080 by default)
- VERSION (browser version, 100.0 by default. Supports execution in Firefox on versions 98.0 and 97.0, as well as Chrome 99.0 and 100.0)
- BROWSER (browser, chrome by default)
<p align="center">
<img title="Jenkins Build" src="media/screenshots/Jenkins.png">
</p>
After the build is completed, icons for "Allure Report" and "Allure TestOps" will appear next to the build number in the "Build History" section. Clicking on these icons opens pages with the generated HTML report and test documentation, respectively.

____
<a id="allureReport"></a>
## <img width="8%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> </a> Example <a target="_blank" href="https://jenkins.autotests.cloud/job/BirdsAutotests/6/allure/"> [Allure Report] </a>

<p align="center">
<img title="Allure Overview" src="media/screenshots/Allure.png">
</p>

____
<a id="allure"></a>
## <img width="8%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> </a> Integration with <a target="_blank" href="https://allure.autotests.cloud/project/3872/dashboards"> [Allure TestOps] </a>

On the *Dashboard* in **Allure TestOps**, you can see the statistics of the number of tests: how many of them are added and executed manually, how many are automated. New tests and test run results are sent through the integration with each build.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screenshots/AllureTestOps.png">
</p>

____
<a id="jira"></a>
## <img width="8%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> </a> Integration with <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1000"> [Jira] </a>

Integration with **Allure TestOps

** and **Jira** is implemented. In the Jira task, you can see which test cases were written as part of the task and their execution results.

<p align="center">
<img title="Jira Task" src="media/screenshots/JiraTask.png">
</p>

____
<a id="tg"></a>
## <img width="10%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> </a> Notifications in Telegram Using a Bot

After the build is complete, a bot created in **Telegram** automatically processes and sends a message with the test run report to a specifically configured chat.

<p align="center">
<img width="50%" title="Telegram Notifications" src="media/screenshots/TelegramBot.png">
</p>

____
<a id="video"></a>
## <img width="10%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> </a> Video attachment example

In the Allure reports for each test, a video of the test execution is attached along with a screenshot.

<p align="center">
  <img title="Selenoid Video" src="media/screenshots/Video.gif">
</p>