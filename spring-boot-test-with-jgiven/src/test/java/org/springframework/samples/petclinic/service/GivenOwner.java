package org.springframework.samples.petclinic.service;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.*;

import java.time.LocalDate;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author bill-smith liuwb
 * @Package org.springframework.samples.petclinic.service
 * @Date 2019/10/14 10:37
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@JGivenStage
public class GivenOwner extends Stage<GivenOwner> {
    @Autowired
    protected OwnerRepository repository;
    @Autowired
    protected PetRepository pets;

    @ScenarioState
    Collection<Owner> owners;
    @ScenarioState
    Owner owner;

    @ExpectedScenarioState
    Pet pet;




    public GivenOwner an_owner_with_last_name(@Quoted String lastName) {
        owners = this.repository.findByLastName(lastName);
        Owner owner = new Owner();
        owner.setFirstName("Sam");
        owner.setLastName(lastName);
        owner.setAddress("4, Evans Street");
        owner.setCity("Wollongong");
        owner.setTelephone("4444444444");

        this.repository.save(owner);
        assertThat(owner.getId().longValue()).isNotEqualTo(0);
        return this;
    }

    public GivenOwner an_onwer_with_new_lastName_$_and_indexOfRecords_$(@Quoted String lastName, @Quoted int indexOfRecords) {
        owner = this.repository.findById(indexOfRecords);

        owner.setLastName(lastName);
        this.repository.save(owner);
        return this;
    }

    public GivenOwner an_onwer_with_record_index(@Quoted int indexOfRecords) {
        owner = this.repository.findById(indexOfRecords);
        return this;
    }

    public GivenOwner an_onwer_by_record_index_$_updated_with_his_pet(int indexOfRecord,int entityID) {
        owner = this.repository.findById(indexOfRecord);
        int found = owner.getPets().size();

        pet = new Pet();
        pet.setName("bowser");
        Collection<PetType> types = this.pets.findPetTypes();
        pet.setType(EntityUtils.getById(types, PetType.class, entityID));
        pet.setBirthDate(LocalDate.now());
        owner.addPet(pet);

        this.pets.save(pet);
        this.repository.save(owner);

        assertThat(owner.getPets().size()).isEqualTo(found + 1);
        return this;
    }
}
