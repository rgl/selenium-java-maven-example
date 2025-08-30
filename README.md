# About

[![test](https://github.com/rgl/selenium-java-maven-example/workflows/test/badge.svg)](https://github.com/rgl/selenium-java-maven-example/actions?query=workflow%3Atest)

This is a Selenium Java example running inside a Dev Container.

# Usage

Install the dependencies:

* [Visual Studio Code](https://code.visualstudio.com).
* [Dev Container plugin](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers).

Open this project directory with the Dev Container plugin.

Access the Selenium Grid WebDriver:

http://localhost:4444

Access the noVNC console (use the `secret` password):

http://localhost:7900

In Visual Studio Code, select the `Testing` icon, and execute the tests. Observe the browser session in the noVNC interface.

Open the Visual Studio Code Terminal.

Execute the tests:

```bash
mvn test
```

The test results will be stored in the `target/surefire-reports` directory.
