Feature: To login in site

@Regression
 Scenario Outline: login with invalid valid credentials
Given login page is given
When enter invalid "<username>" and "<password>"
And match assertion for invalid login
Then login should not sucessfull

Examples:

|username | password|
|dhirendravikramsingh93@gmail.com| Test@12345|



@Regression
 Scenario Outline: login with valid credentials
Given login page is given
When enter valid "<username>" and "<password>"
And match assertion for valid login
Then login should sucessfull

Examples:

|username | password|
|dhirendravikramsingh93@gmail.com| Test@1234|