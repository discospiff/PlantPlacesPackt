package jonesbl.packt.com.plantplacespackt;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import jonesbl.packt.com.dao.NetworkDAO;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jonesb on 1/8/2017.
 */

public class TestNetworkDAO {

    NetworkDAO networkDAO;

    @Before
    public void setup() {
        networkDAO = new NetworkDAO();
    }

    @Test
    public void fetchShouldSucceedWhenGivenValidURI() throws IOException {
        String result = networkDAO.fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=akjdf;lajksdf");
        System.out.println(result);
        assertEquals("{\"plants\":[]}-1", result);
    }
}
