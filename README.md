# Testing-Selenium-Java
Learning about the Selenium WebDriver with Java with the test automation university course

![image](https://user-images.githubusercontent.com/78630957/182267841-a7a2eb4e-7633-4995-ab43-6e5e7912a19f.png)

First run after setting up and creating the first class


![image](https://user-images.githubusercontent.com/78630957/182273533-308d5e3c-5a97-4b53-bb5d-48baeaec9c49.png)

Following test convention where the framework is on the "src" folder and also creating the files to follow the page object model design pattern

When using the page object model each time that the page changes due to interaction made with it a handle to the new page must be returned. This new page should have its proper page object model

![image](https://user-images.githubusercontent.com/78630957/182285873-86c85a07-0b27-4c6b-b900-9a3a9e219fdd.png)
In this case, after clicking you enter the login page, therefore you must return the handle of said page


![image](https://user-images.githubusercontent.com/78630957/182501600-0a7fbbd7-87c3-4064-ac92-e7948553a13f.png)

After first test run we can see how how it reports the results


## Pop-ups 2 File Upload

To "interact" with these sort of elements with Selenium Webdriver, one must bypass the pop-up window by passing the absolute path of the file directly to the "pick file" element on the page, shown on the picture below

![image](https://user-images.githubusercontent.com/78630957/182991292-efd57d7a-c3eb-4e1d-9545-6cf0dbfaa1e5.png)

## Pop-ups 3 Modals

Unlike Javascript alerts and File upload pop-ups, modals actually do appear in the DOM of the page, so if one wishes to interact with the modal window just get the correct selector and carry on as normal. An important thing to take into account is that while a modal window is active or visible nothing else will be available to interact with, trying that will create an exception

## Waits

### Implicit waits
![image](https://user-images.githubusercontent.com/78630957/183272224-357f3358-734c-4412-a93c-6e9b5dcdd9db.png)

As seen in the picture this command takes in a duration object and that object dictates the unit of time or whatever you need for your test, however, implicit waits can make your test slower because it will be triggered befored every interaction



