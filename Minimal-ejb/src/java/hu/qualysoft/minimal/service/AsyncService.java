package hu.qualysoft.minimal.service;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author zsolt
 */
@Stateless
public class AsyncService implements AsyncServiceLocal {

    @Override
    @Asynchronous
    public Future<String> doJob() {
        String returnValue = "Hello";
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new AsyncResult<>(returnValue);
    }

}
