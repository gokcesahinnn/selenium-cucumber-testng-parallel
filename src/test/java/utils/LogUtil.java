package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LogUtil implements ITestListener {

    private static final Logger LOG = LoggerFactory.getLogger(LogUtil.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("Test Started => {}", result.getParameters());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info("Test Success");
    }

    public void onTestFailure(ITestResult result) {
        LOG.error("Test Failed => ", result.getThrowable());
    }

}