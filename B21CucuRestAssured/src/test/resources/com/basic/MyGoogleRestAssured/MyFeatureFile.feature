Feature: Testing basics

Scenario: 1.I want to test google is up and running
Given google have website
When I hit google application
Then I validate status code


Scenario: 2.I want to test ergast is up and running
When I hit F1 race application
Then I validate the status code of F1 app