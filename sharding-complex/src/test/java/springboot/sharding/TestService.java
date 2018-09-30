package springboot.sharding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.sharding.service.TestShardingService;

/**
 * Created by Mr.PanYang on 2018/9/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {

    @Autowired
    private TestShardingService testShardingService;

    @Test
    public void dropAllTables() {
        testShardingService.dropAllTables();
    }

    @Test
    public void initData() {
        testShardingService.initData();
    }

    @Test
    public void testInsert() {
        testShardingService.insertOrder();
    }

    @Test
    public void testSelect() {
        testShardingService.selectAllOrderItems();
    }

    @Test
    public void testSelectIn() {
        testShardingService.selectIn();
    }

    @Test
    public void testSelectBetween() {
        testShardingService.selectBetween();
    }

}
