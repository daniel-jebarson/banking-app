package net.bankapp.banking.service.Impl;

import net.bankapp.banking.Error.CustomException;
import net.bankapp.banking.Mapper.BranchMapper;
import net.bankapp.banking.Mapper.PersonMapper;
import net.bankapp.banking.dto.Branch.BranchDataDto;
import net.bankapp.banking.dto.Branch.BranchDto;
import net.bankapp.banking.entity.Branch;
import net.bankapp.banking.entity.Person;
import net.bankapp.banking.repository.BranchRepo;
import net.bankapp.banking.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepo branchRepo;

    public BranchServiceImpl(BranchRepo branchRepo) {
        this.branchRepo = branchRepo;
    }

    @Override
    public BranchDataDto createBranch(BranchDto branchDto) {
        Branch branch= BranchMapper.mapToBranch(branchDto);
        Branch savedBranch= branchRepo.save(branch);
        return BranchMapper.BranchToBranchDataDto(savedBranch);
    }

    @Override
    public BranchDataDto getBranchById(Integer id) throws CustomException {
        Branch branch=branchRepo.findById(id).orElse(null);
        if(branch!=null)
            return BranchMapper.BranchToBranchDataDto(branch);
        throw new CustomException(400,"Invalid branch id");
    }

    @Override
    public List<BranchDataDto> getAllBranches() {
        List<Branch> persons=branchRepo.findAll();
        return persons.stream()
                .map(BranchMapper::BranchToBranchDataDto) // Use method reference for clarity
                .collect(Collectors.toList());
    }

    @Override
    public BranchDto updateBranch(BranchDataDto branchDto) throws CustomException {
        Optional<Branch> existingBranchOptional = branchRepo.findById(branchDto.getId());

        if (existingBranchOptional.isPresent()) {
            Branch existingBranch = existingBranchOptional.get();

            // Set the updated values from the DTO
            existingBranch.setBranchName(branchDto.getName());
            existingBranch.setBranchCode(branchDto.getCode());
            existingBranch.setAddress(branchDto.getAddress());
            existingBranch.setPhoneNumber(branchDto.getNumber());

            // Save the updated branch entity
            Branch updatedBranch = branchRepo.save(existingBranch);

            // Convert the entity to DTO and return it
            return BranchMapper.mapToBranchDto(updatedBranch);
        } else {
            throw new CustomException(400, "Branch with ID " + branchDto.getId() + " not found.");
        }
    }


    @Override
    public void deleteBranch(Integer id) throws CustomException {
        Optional<Branch> existingBranch = branchRepo.findById(id);

        if (existingBranch.isPresent()) {
            // Branch exists, delete it
            branchRepo.deleteById(id);
        } else {
            // Branch with the given ID is not found
            System.out.println("Error occured --> "+"Branch with ID " + id + " not found.");
            throw new CustomException(404, "Branch with ID " + id + " not found.");
        }
    }



}
