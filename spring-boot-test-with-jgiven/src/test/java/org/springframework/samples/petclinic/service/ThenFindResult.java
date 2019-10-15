package org.springframework.samples.petclinic.service;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author bill-smith liuwb
 * @Package org.springframework.samples.petclinic.service
 * @Date 2019/10/14 10:42
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@JGivenStage
public class ThenFindResult<SELF extends ThenFindResult<SELF>>  extends Stage<SELF> {

    @ScenarioState
    Collection<Owner> owners;
    @ScenarioState
    Owner owner;
    @ExpectedScenarioState
    Pet pet;

    public ThenFindResult exactly_$_owner_is_inserted(int i) {
                assertThat(owners.size()).isEqualTo(i);
        return this;
    }

    public ThenFindResult return_updatedOwner_with_new_lastName(@Quoted String newLastName) {
        assertThat(owner.getLastName()).isEqualTo(newLastName);
        return this;
    }

    public void lastName_startWith_$_and_have_$_pets_and_petsType_isEualTo_$(@Quoted String startWith,@Quoted int sizeOfPets, @Quoted String petType) {          assertThat(owner.getLastName()).startsWith(startWith);
        assertThat(owner.getPets()).hasSize(sizeOfPets);
        assertThat(owner.getPets().get(0).getType()).isNotNull();
        assertThat(owner.getPets().get(0).getType().getName()).isEqualTo(petType);

    }

    public void return_$_owners_form_database(int countOfOwners) {
        assertThat(owners).hasSize(2);
    }

    public void owners_from_database_isEmpty() {
        assertThat(owners).isEmpty();
    }

    public void owner6_has_$_pets_and_pet_id_isNotNull(int petCount) {
        assertThat(owner.getPets().size()).isEqualTo(petCount);
        assertThat(pet.getId()).isNotNull();
    }
}
