package criticalTools.convert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.criticalTools.agent.MySQLCnx;

class MySQLCnxTestUnit {

	@Test
	void makeCnxUrl() {
		
		// jdbc:mysql://192.168.1.12/code_test?user=root&password=1a2b3c4d
		MySQLCnx.setBddServeur("192.168.1.12");
		MySQLCnx.setBddUtilisateur("root");
		MySQLCnx.setBddMdp("1a2b3c4d");
		MySQLCnx.setBddNom("code_test");
		MySQLCnx.makeCnxUrl();
		assertEquals("jdbc:mysql://192.168.1.12/code_test?user=root&password=1a2b3c4d", MySQLCnx.getCnxUrl());
	}

}
