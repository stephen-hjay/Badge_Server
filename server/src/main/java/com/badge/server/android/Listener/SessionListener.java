//package com.badge.server.android.Listener;
//
//import javax.servlet.ServletContext;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.*;
//import java.util.HashSet;
//
//@WebListener
//public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
//
//
//
//
//    @Override
//    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
//
//        @SuppressWarnings("unused")
//        HttpSession session = httpSessionBindingEvent.getSession();
//        String key = httpSessionBindingEvent.getName();
//
//        if (key.equals("badge")){
//            System.out.println( "badge:"+ httpSessionBindingEvent.getValue()+"login successfully");
//            ServletContext application = session.getServletContext();
//            HashSet<HttpSession> sessions = (HashSet<HttpSession>) application.getAttribute("sessions");
//
//        }
//
//    }
//
//    @Override
//    public void sessionCreated(HttpSessionEvent httpSessionBindingEvent) {
//        HttpSession session = httpSessionBindingEvent.getSession();
//        ServletContext application = session.getServletContext();
//        HashSet<HttpSession> sessions = (HashSet<HttpSession>) application.getAttribute("sessions");
//
//        if (sessions == null){
//            sessions = new HashSet<HttpSession>();
//        }
//        sessions.add(session);
//        application.setAttribute("sessions",sessions);
//        HashSet<String> badges = (HashSet<String>) application.getAttribute("badgesOnline");
//        if (badges==null){
//            badges = new HashSet<String>();
//            application.setAttribute("badgesOnline",badges);
//        }
//    }
//
//    @Override
//    public void sessionDestroyed(HttpSessionEvent se) {
//
//    }
//
//
//}
