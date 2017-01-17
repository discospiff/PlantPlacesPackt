package jonesbl.packt.com.plantplacespackt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import jonesbl.packt.com.dao.BDDTestPlantDAO;

/**
 * Run a series of JUnit tests together, as a suite.
 *
 * This is handy when you want to add this as a prerequisite task before running or debugging the
 * Android app on the emulator.
 *
 * To enable automatic test running, choose Run - Edit Configurations - App - Before Launch, then
 * add this class as a dependency.
 *
 * Created by jonesb on 12/31/2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BDDTestPlantDAO.class,
        TestNetworkDAO.class
})
public class DAOTestSuite {
}
