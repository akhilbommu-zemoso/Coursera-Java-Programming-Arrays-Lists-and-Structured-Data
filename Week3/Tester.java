package Week3;

import java.util.*;

public class Tester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("src/short-test_log.txt");
        la.printAll();
    }
    public void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("src/short-test_log.txt");
        System.out.println("There are " + la.countUniqueIPs() + " unique IPs");
        la.uniqueIPVisitsOnDay("Sep 30");
        System.out.println("Unique ip's in range 200-299: "+la.countUniqueIPsInRange(200,299));
    }

    public  void countingWebsiteVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("src/short-test_log.txt");
        System.out.println(la.countVisitsPerIP());
        System.out.println(la.iPsForDays());
    }

    public static void main(String[] args) {
        Tester obj = new Tester();
        obj.testLogAnalyzer();
        obj.testUniqueIP();
        obj.countingWebsiteVisits();
    }
}