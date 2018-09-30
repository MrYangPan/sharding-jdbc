package springboot.sharding.strategy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Range;
import io.shardingsphere.core.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.Collection;
import java.util.HashSet;

import org.slf4j.Logger;

public class EndWithRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(RangeShardingAlgorithm.class);

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Integer> shardingValue) {
        logger.info("Range collection:" + JSON.toJSONString(availableTargetNames) + ",rangeShardingValue:" + JSON.toJSONString(shardingValue));
        Collection<String> collect = new HashSet<>();
        Range<Integer> valueRange = shardingValue.getValueRange();
        for (Integer i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String each : availableTargetNames) {
                if (each.endsWith(i % availableTargetNames.size() + "")) {
                    collect.add(each);
                }
            }
        }
        return collect;
    }
}
