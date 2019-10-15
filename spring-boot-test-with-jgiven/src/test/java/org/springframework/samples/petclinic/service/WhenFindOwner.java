package org.springframework.samples.petclinic.service;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import java.util.Collection;

/**
 * @author bill-smith liuwb
 * @Package org.springframework.samples.petclinic.service
 * @Date 2019/10/14 10:41
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@JGivenStage
public class WhenFindOwner extends Stage<WhenFindOwner> {
    @Autowired
    protected OwnerRepository ownerRepository;
    @ScenarioState
    Collection<Owner> owners;
    @ScenarioState
    Owner owner;

    public WhenFindOwner find_By_Last_Name(String lastName) {
        owners = this.ownerRepository.findByLastName(lastName);
        return this;
    }

    public WhenFindOwner retrieving_new_name_from_database_with_indexOfRecords_$(@Quoted int indexOfRecords) {
        owner = this.ownerRepository.findById(indexOfRecords);
        return this;
    }
}
