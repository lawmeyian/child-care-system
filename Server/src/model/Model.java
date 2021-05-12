package model;

import utility.observer.subject.LocalSubject;

import java.rmi.RemoteException;

public interface Model extends LocalSubject<Booking, Booking>
{
  void addBooking(Booking booking) throws IllegalArgumentException;

  boolean isPasswordCorrect(String userName, String password) throws RemoteException;


  void close();
}
