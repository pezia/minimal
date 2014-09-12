package hu.qualysoft.minimal.worker;

import java.util.concurrent.Callable;

/**
 *
 * @author zsolt
 */
public class AsyncWorker implements Callable<String> {
    
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "Hello World!!!";
    }
    
}
