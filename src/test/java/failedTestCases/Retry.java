package failedTestCases;

import config.BaseConfig;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int maxTry = Integer.parseInt(BaseConfig.getInstance().getMaxRetryCountForFailedScenarios());
    int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                return true;
            }
        }
        return false;
    }
}
