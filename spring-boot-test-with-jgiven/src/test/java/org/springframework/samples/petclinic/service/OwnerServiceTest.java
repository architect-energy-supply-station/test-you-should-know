/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.service;

import com.tngtech.jgiven.annotation.JGivenConfiguration;
import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.system.JGivenConfig;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Integration test of the Service and the Repository layer.
 * <p>
 * ClinicServiceSpringDataJpaTests subclasses benefit from the following services provided by the Spring
 * TestContext Framework: </p> <ul> <li><strong>Spring IoC container caching</strong> which spares us unnecessary set up
 * time between test execution.</li> <li><strong>Dependency Injection</strong> of test fixture instances, meaning that
 * we don't need to perform application context lookups. See the use of {@link Autowired @Autowired} on the <code>{@link
 * OwnerServiceTest#clinicService clinicService}</code> instance variable, which uses autowiring <em>by
 * type</em>. <li><strong>Transaction management</strong>, meaning each test method is executed in its own transaction,
 * which is automatically rolled back by default. Thus, even if tests insert or otherwise change database state, there
 * is no need for a teardown or cleanup script. <li> An {@link org.springframework.context.ApplicationContext
 * ApplicationContext} is also inherited and can be used for explicit bean lookup if necessary. </li> </ul>
 *
 * @author Ken Krebs
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Dave Syer
 */
@RunWith(SpringRunner.class)
@JGivenConfiguration(JGivenConfig.class)
@DataJpaTest()
@ComponentScan(basePackages = {"org.springframework.samples.petclinic"})
public class OwnerServiceTest extends SpringScenarioTest<GivenOwner, WhenFindOwner, ThenFindResult> {

    @Autowired
    protected OwnerRepository owners;

    @Autowired
    protected PetRepository pets;

    @Autowired
    protected VisitRepository visits;

    @Autowired
    protected VetRepository vets;

    @ScenarioStage
    GivenPetStage petStage;

    //region refactoring with BDD
    @Test
    public void shouldFindOwnersByLastName() {
        when().find_By_Last_Name("Davis");
        then().return_$_owners_form_database(2);

        when().find_By_Last_Name("Daviss");
        then().owners_from_database_isEmpty();
    }

    @Test
    public void shouldFindSingleOwnerWithPet() {
        given().an_onwer_with_record_index(1);
        then().lastName_startWith_$_and_have_$_pets_and_petsType_isEualTo_$("Franklin", 1, "cat");
    }

    @Test
    @Transactional
    public void shouldInsertOwner() {
        given().an_owner_with_last_name("Schultz");
        when().find_By_Last_Name("Schultz");
        then().exactly_$_owner_is_inserted(1);
    }

    @Test
    @Transactional
    public void shouldUpdateOwner() {
        given().an_onwer_with_new_lastName_$_and_indexOfRecords_$("Bill",1);
        when().retrieving_new_name_from_database_with_indexOfRecords_$(1);
        then().return_updatedOwner_with_new_lastName("Bill");

    }
    //endregion


    @Test
    @Transactional
    public void shouldInsertPetIntoDatabaseAndGenerateId() {
        //given an owner by id 6 and given all petTypes and new a pet and add pet into owner6 and save pet,owner
        given().an_onwer_by_record_index_$_updated_with_his_pet(6,2);
        when().retrieving_new_name_from_database_with_indexOfRecords_$(6);
        then().owner6_has_$_pets_and_pet_id_isNotNull(3);
    }


    @Test
    public void shouldFindVets() {
        Collection<Vet> vets = this.vets.findAll();

        Vet vet = EntityUtils.getById(vets, Vet.class, 3);
        assertThat(vet.getLastName()).isEqualTo("Douglas");
        assertThat(vet.getNrOfSpecialties()).isEqualTo(2);
        assertThat(vet.getSpecialties().get(0).getName()).isEqualTo("dentistry");
        assertThat(vet.getSpecialties().get(1).getName()).isEqualTo("surgery");
    }

    @Test
    @Transactional
    public void shouldAddNewVisitForPet() {
        Pet pet7 = this.pets.findById(7);
        int found = pet7.getVisits().size();
        Visit visit = new Visit();
        pet7.addVisit(visit);
        visit.setDescription("test");
        this.visits.save(visit);
        this.pets.save(pet7);

        pet7 = this.pets.findById(7);
        assertThat(pet7.getVisits().size()).isEqualTo(found + 1);
        assertThat(visit.getId()).isNotNull();
    }

    @Test
    public void shouldFindVisitsByPetId() throws Exception {
        Collection<Visit> visits = this.visits.findByPetId(7);
        assertThat(visits).hasSize(2);
        Visit[] visitArr = visits.toArray(new Visit[visits.size()]);
        assertThat(visitArr[0].getDate()).isNotNull();
        assertThat(visitArr[0].getPetId()).isEqualTo(7);
    }

}



