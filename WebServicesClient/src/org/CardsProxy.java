package org;

public class CardsProxy implements org.Cards {
  private String _endpoint = null;
  private org.Cards cards = null;
  
  public CardsProxy() {
    _initCardsProxy();
  }
  
  public CardsProxy(String endpoint) {
    _endpoint = endpoint;
    _initCardsProxy();
  }
  
  private void _initCardsProxy() {
    try {
      cards = (new org.CardsServiceLocator()).getCards();
      if (cards != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cards)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cards)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cards != null)
      ((javax.xml.rpc.Stub)cards)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.Cards getCards() {
    if (cards == null)
      _initCardsProxy();
    return cards;
  }
  
  public boolean validateCard(long in0, float in1) throws java.rmi.RemoteException{
    if (cards == null)
      _initCardsProxy();
    return cards.validateCard(in0, in1);
  }
  
  
}