package ie.cit.cloud.mvc.event;

//public class mvcApplicationEventListener implements ApplicationListener<RequestHandledEvent> {

import org.springframework.context.ApplicationListener;

import org.springframework.web.context.support.RequestHandledEvent;

import org.springframework.stereotype.Component;


@Component
public class mvcApplicationEventListener 
   implements ApplicationListener<RequestHandledEvent>{

   public void onApplicationEvent(RequestHandledEvent event) {
      System.out.println("ContextStartedEvent ********************** Received" + event);
      System.out.println("ContextStartedEvent ********************** Received");
      System.out.println("ContextStartedEvent ********************** Received");
      System.out.println("ContextStartedEvent ********************** Received");
      System.out.println("ContextStartedEvent ********************** Received");
      System.out.println("ContextStartedEvent ********************** Received");
      System.out.println("ContextStartedEvent ********************** Received");
      System.out.println("ContextStartedEvent ********************** Received" + event);
   }
}