package org.springframework.samples.petclinic.service;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExtendedDescription;
import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.owner.PetType;

import java.util.Collection;

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
public class WhenSearchPetsStage extends Stage<WhenSearchPetsStage> {

    @Autowired
    protected PetRepository pets;
    @ScenarioState
    Collection<PetType> petTypes;

    @ScenarioState
    PetType petType1;
    @ScenarioState
    Pet pet7;

    @ExtendedDescription("this is very great feature for me!")
    public void
    find_pet_byID_$_(@Quoted int id) {
        pet7 = this.pets.findById(7);
    }

    public void get_petType_by_ID_$_(@Quoted int entityID) {
         petType1 = EntityUtils.getById(petTypes, PetType.class, entityID);
    }
}
