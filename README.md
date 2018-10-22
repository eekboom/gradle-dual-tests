gradle: TestNG and JUnit in a single project
============================================

This is a test project for a gradle build that executes both JUnit and TestNG tests.

For testing the test execution, there is both a failing JUnit and a failing TestNG test.

The build setup is currently **BROKEN:** 

The first "./gradlew build" (initial or after "./gradlew clean") will correctly fail (because there are two failing tests).

However the next invocation of "./gradlew build" will not execute the failing tests again and will incorrectly report BUILD SUCCESSFUL.

**ANY IDEA?**

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
   
4) Sane gradle behaviour must be preserved
   * after a successful "gradle build" all tasks are up-to-date on following "gradle build" invocations unless relevant files were changed
   * **CURRENTLY BROKEN:** Failing tests are executed again in subsequent "gradle build" invocation
