/**
 * CardsService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org;

public interface CardsService extends javax.xml.rpc.Service {
    public java.lang.String getCardsAddress();

    public org.Cards getCards() throws javax.xml.rpc.ServiceException;

    public org.Cards getCards(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
