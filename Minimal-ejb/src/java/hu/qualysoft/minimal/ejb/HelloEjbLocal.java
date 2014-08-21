/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.qualysoft.minimal.ejb;

import javax.ejb.Local;

/**
 *
 * @author zsolt
 */
@Local
public interface HelloEjbLocal {

    String createHello(String name);
    
}
