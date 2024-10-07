package net.bankapp.banking.Mapper;

import net.bankapp.banking.dto.BranchDto;
import net.bankapp.banking.entity.Branch;

public class BranchMapper {

    public static Branch mapToBranch(BranchDto branchDto){
        return new Branch(
                branchDto.getName(),
                branchDto.getCode(),
                branchDto.getAddress(),
                branchDto.getPhoneNumber()
        );
    }

    public static BranchDto mapToBranchDto(Branch branch){
        return new BranchDto(
                branch.getBranchName(),
                branch.getBranchCode(),
                branch.getAddress(),
                branch.getPhoneNumber()
        );
    }

}
