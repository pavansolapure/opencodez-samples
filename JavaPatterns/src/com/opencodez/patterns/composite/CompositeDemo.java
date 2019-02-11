package com.opencodez.patterns.composite;

public class CompositeDemo {

	public static void main(String[] args) {
		Developer dev1 = new Developer("Developer 1");
		Developer dev2 = new Developer("Developer 2");
		Developer dev3 = new Developer("Developer 3");
		Developer dev4 = new Developer("Developer 4");
		
		Manager mgr1 = new Manager("Manager 1");
		Manager mgr2 = new Manager("Manager 2");
		
		GeneralManager gmgr = new GeneralManager("General Manager");
		
		gmgr.addReportee(mgr1);
		gmgr.addReportee(mgr2);
		
		gmgr.addReportee(dev3);
		
		mgr1.addReportee(dev1);
		mgr1.addReportee(dev4);
		
		mgr2.addReportee(dev2);
		
		gmgr.print();
		
	}

}
