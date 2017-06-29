package com.test.runner;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Runner {

	private static String RUN_ENV="RUNTIME_ENV_PARAMETER";
	public static String env;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		env=args[0];
		System.out.println("Data="+RUN_ENV+args[0]);
		
			TestListenerAdapter tla = new TestListenerAdapter();
			 TestNG testng = new TestNG();
			 List<String> suites = Lists.newArrayList();
			 //suites.add("c:/tests/testng1.xml");//path to xml..
			 suites.add("D:/TestathonWorkspace/TestathonUITest/testng.xml");
			 
			 testng.setTestSuites(suites);
			 testng.run();
		// }

	}

}
