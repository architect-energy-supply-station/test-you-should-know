package org.springframework.samples.petclinic.service;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
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
 * @Date 2019/10/14 17:44
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@JGivenStage
public class GivenPetStage<SELF extends GivenPetStage<SELF>> extends Stage<SELF> {
    @Autowired
    protected PetRepository pets;

    @ScenarioState
    Collection<PetType> petTypes;

    @ProvidedScenarioState
    Pet pet;

    @As(value = "an pet should find byID $ and updated with his new name $")
    public void find_an_pet_findById_$_and_updated_with_new_name_$(@Quoted int id,@Quoted String name) {
        pet = this.pets.findById(id);
        pet.setName(name);
        this.pets.save(pet);
    }

    public void pet_Types() {
         petTypes = this.pets.findPetTypes();
    }

}
