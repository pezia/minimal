/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.qualysoft.minimal.service;

import java.util.concurrent.Future;
import javax.ejb.Local;

/**
 *
 * @author zsolt
 */
@Local
public interface AsyncServiceLocal {

    Future<String> doJob();
    
}
