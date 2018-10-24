gradle: TestNG and JUnit in a single project
============================================

This is a test project for a gradle build that executes both JUnit and TestNG tests.

For testing the test execution, there is both a failing JUnit and a failing TestNG test.

It relies on gradle's "finalizedBy" feature as well as the "TestReport" task type
(both of which are still incubating in gradle 4.10.2).

Comments are welcome.

Problem
-------

gradle's "test" task support either TestNG or JUnit, but cannot execute tests of both types.

On the other hand maven's Surefire plugin can easily run both test types.
We need good acceptance from developers in our team when migrating from maven to gradle, so
there should not be any additional hurdles.

Requirements
------------

1) **DONE:** Both TestNG and JUnit tests are executed

   It's easy to to just add another task of type test to the gradle build file, but, see 2: 

2) **DONE:** Always run both JUnit and TestNG tests - even if a test of the first type fails

   This would be very bad developer experience 
   * push a change (to gerrit)
   * have the Jenkins job fail with a JUnit test failure
   * fix the test
   * push a new version of the change
   * have the job fail again, this time with a TestNG test failure

3) **DONE:** There is a single, consolidated test report

   People should not be forced to look at two separate test reports.
   
4) **DONE:** Sane gradle behaviour must be preserved
   * after a successful "gradle build" all tasks are up-to-date on following "gradle build" invocations unless relevant files were changed
   * In case of test failures the corresponding test task is executed again in subsequent "gradle build" invocation
