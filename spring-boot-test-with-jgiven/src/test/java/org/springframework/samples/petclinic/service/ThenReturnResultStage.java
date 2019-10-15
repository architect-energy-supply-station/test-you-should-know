package org.springframework.samples.petclinic.service;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author bill-smith liuwb
 * @Package org.springframework.samples.petclinic.service
 * @Date 2019/10/14 17:46
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@JGivenStage
public class ThenReturnResultStage extends Stage<ThenReturnResultStage> {

    @ScenarioState
    Pet pet7;
    @ScenarioState
    PetType petType1;

    public void pet7_getName_will_EqualTo_$_(@Quoted String name) {
        assertThat(pet7.getName()).isEqualTo(name);
    }

    public void pet7_getName_will_startsWith_$_and_EqualTo_$_(@Quoted String startsWith,@Quoted String firstName) {
                assertThat(pet7.getName()).startsWith("Samantha");
        assertThat(pet7.getOwner().getFirstName()).isEqualTo("Jean");

    }

    public void petType1_getName_isEqualTO(@Quoted String typeName) {
        assertThat(petType1.getName()).isEqualTo(typeName);
    }
}
