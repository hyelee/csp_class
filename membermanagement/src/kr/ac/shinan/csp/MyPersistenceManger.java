package kr.ac.shinan.csp;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

public class MyPersistenceManger {

	public static PersistenceManager getManager() {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		return pm;
	}

}