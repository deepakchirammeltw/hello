// IHelloService.aidl
package com.tw.helloservice;

interface IHelloService {
    /** When greeted, returns by saying 'Hello and Welcome to TW' **/
    String hello();

    /** When pinged, returns by saying 'pong' for Health Checks **/
    String ping();

    /** When called 'bye', returns by saying 'Thank You. See you again' **/
    String bye();
}
