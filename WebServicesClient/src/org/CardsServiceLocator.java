/**
 * CardsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org;

public class CardsServiceLocator extends org.apache.axis.client.Service implements org.CardsService {

    public CardsServiceLocator() {
    }


    public CardsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CardsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Cards
    private java.lang.String Cards_address = "http://localhost/WebServicesDemo/services/Cards";

    public java.lang.String getCardsAddress() {
        return Cards_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CardsWSDDServiceName = "Cards";

    public java.lang.String getCardsWSDDServiceName() {
        return CardsWSDDServiceName;
    }

    public void setCardsWSDDServiceName(java.lang.String name) {
        CardsWSDDServiceName = name;
    }

    public org.Cards getCards() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Cards_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCards(endpoint);
    }

    public org.Cards getCards(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.CardsSoapBindingStub _stub = new org.CardsSoapBindingStub(portAddress, this);
            _stub.setPortName(getCardsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCardsEndpointAddress(java.lang.String address) {
        Cards_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.Cards.class.isAssignableFrom(serviceEndpointInterface)) {
                org.CardsSoapBindingStub _stub = new org.CardsSoapBindingStub(new java.net.URL(Cards_address), this);
                _stub.setPortName(getCardsWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Cards".equals(inputPortName)) {
            return getCards();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://org", "CardsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://org", "Cards"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Cards".equals(portName)) {
            setCardsEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
