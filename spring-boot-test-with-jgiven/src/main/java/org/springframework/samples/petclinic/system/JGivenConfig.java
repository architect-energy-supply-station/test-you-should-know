package org.springframework.samples.petclinic.system;

import com.tngtech.jgiven.config.AbstractJGivenConfiguration;
import com.tngtech.jgiven.integration.spring.EnableJGiven;
import org.springframework.context.annotation.Configuration;

/**
 * @author bill-smith liuwb
 * @Package org.springframework.samples.petclinic.system
 * @Date 2019/10/14 15:06
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@EnableJGiven
@Configuration
public class JGivenConfig extends AbstractJGivenConfiguration {
    @Override
    public void configure() {

    }
}
