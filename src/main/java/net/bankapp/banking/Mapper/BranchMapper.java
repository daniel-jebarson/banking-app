package net.bankapp.banking.Mapper;

import net.bankapp.banking.dto.Branch.BranchDataDto;
import net.bankapp.banking.dto.Branch.BranchDto;
import net.bankapp.banking.entity.Branch;

public class BranchMapper {

    public static Branch mapToBranch(BranchDto branchDto){
        return new Branch(
                branchDto.getName(),
                branchDto.getCode(),
                branchDto.getAddress(),
                branchDto.getNumber()
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

    public static BranchDataDto BranchToBranchDataDto(Branch branch){
        return new BranchDataDto(
                branch.getBranchId(),
                branch.getBranchName(),
                branch.getBranchCode(),
                branch.getAddress(),
                branch.getPhoneNumber()
        );
    }

    public static Branch BranchToBranchDataDto(BranchDataDto branchDataDto){
        return new Branch(
                branchDataDto.getId(),
                branchDataDto.getName(),
                branchDataDto.getCode(),
                branchDataDto.getAddress(),
                branchDataDto.getNumber()
        );
    }

}
