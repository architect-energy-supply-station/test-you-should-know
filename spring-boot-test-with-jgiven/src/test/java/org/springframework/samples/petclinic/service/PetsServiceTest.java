package org.springframework.samples.petclinic.service;

import com.tngtech.jgiven.annotation.JGivenConfiguration;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.system.JGivenConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bill-smith liuwb
 * @Package org.springframework.samples.petclinic.service
 * @Date 2019/10/14 17:28
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@RunWith(SpringRunner.class)
@JGivenConfiguration(JGivenConfig.class)
@DataJpaTest
@ComponentScan("org.springframework.samples.petclinic")
public class PetsServiceTest extends SpringScenarioTest<GivenPetStage,WhenSearchPetsStage,ThenReturnResultStage> {

    @Autowired
    protected PetRepository pets;


    @Test
    @Transactional
    public void shouldUpdatePetName() throws Exception {
        given().find_an_pet_findById_$_and_updated_with_new_name_$(7,"cindy");

        when().find_pet_byID_$_(7);

        then().pet7_getName_will_EqualTo_$_("cindy");
    }

    @Test
    public void shouldFindPetWithCorrectId() {
        when().find_pet_byID_$_(7);
        then().pet7_getName_will_startsWith_$_and_EqualTo_$_("Samantha","Jean");

    }

    @Test
    public void shouldFindAllPetTypes() {
        given().pet_Types();

        when().get_petType_by_ID_$_(1);
        then().petType1_getName_isEqualTO("cat");

        when().get_petType_by_ID_$_(4);
        then().petType1_getName_isEqualTO("snake");
    }

}
