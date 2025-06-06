package com.scm.eis.helper;

import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.constant.State;
import com.scm.eis.constant.TaskType;
import com.scm.eis.entity.*;
import com.scm.eis.exception.EmployeeCreateException;
import com.scm.eis.repository.EmployeeRepository;
import com.scm.eis.request.EmployeeRequest;
import com.scm.eis.request.EmployeeUpdateRequest;
import com.scm.eis.response.EmployeeListResponse;
import com.scm.eis.response.EmployeeLoginResponse;
import com.scm.eis.response.EmployeeResponse;
import com.scm.eis.response.UserLoginResponse;
import com.scm.eis.service.*;
import com.scm.eis.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeHelper {

    @Autowired
    NationalUniqueIdentifierService nationalUniqueIdentifierService;

    @Autowired
    CompanyService companyService;

    @Autowired
    AddressService addressService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ChatBoatService chatBoatService;

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;


    public Employee getEntity(EmployeeRequest request) throws EmployeeCreateException {
        Company company = companyService.findCompanyById(request.getCompanyId());
        Optional<NationalUniqueIdentifier> nationalUniqueIdentifier = nationalUniqueIdentifierService
                .findByPanNumberOrAdharNumber(
                        request.getEmpNationalUnIdnRequest().getPanNumber(),
                        request.getEmpNationalUnIdnRequest().getAdharNumber()
                );

        if (nationalUniqueIdentifier.isPresent()) {
            throw new EmployeeCreateException();
        }

        NationalUniqueIdentifier newNationalUniqueIdentifier = new NationalUniqueIdentifier();
        Employee employee = new Employee();

        employee.setFirstName(request.getFirstName());
        employee.setMiddleName(request.getMiddleName());
        employee.setLastName(request.getLastName());
        employee.setSapCard(CommonUtil.generateEmployeeSapId());
        employee.setSalary(request.getSalary());
        employee.setJoiningDate(request.getJoiningDate());
        employee.setDob(request.getDob());
        employee.setCompanyEmailId(request.getCompanyEmailId());
        employee.setPersonalEmailId(request.getPersonalEmailId());
        employee.setMobileNumber(request.getMobileNumber());
        employee.setPassword(request.getPassword());
        employee.setGenderType(request.getGenderType());
        employee.setAnyDisability(request.getAnyDisability());
        employee.setBloodGroup(request.getBloodGroup());
        employee.setEmployeeDepartment(request.getEmployeeDepartment());
        employee.setEmployeeCategory(request.getEmployeeCategory());
        employee.setEmployeeLevel(request.getEmployeeLevel());
        employee.setCompany(company);
        employee.setCountryEnum(request.getCountryEnum());
        employee.setCreatedOn(LocalDateTime.now());
        newNationalUniqueIdentifier.setAdharNumber(request.getEmpNationalUnIdnRequest().getAdharNumber());
        newNationalUniqueIdentifier.setPanNumber(request.getEmpNationalUnIdnRequest().getPanNumber());
        newNationalUniqueIdentifier.setCreatedOn(LocalDateTime.now());
        newNationalUniqueIdentifier.setEmployee(employee);

        Address address = new Address();
        address.setHouseNumber(request.getAddressRequest().getHouseNumber());
        address.setCity(request.getAddressRequest().getCity());
        address.setState(request.getAddressRequest().getState());
        address.setDistrict(request.getAddressRequest().getDistrict());
        address.setPostOfficeName(request.getAddressRequest().getPostOfficeName());
        address.setPinCode(request.getAddressRequest().getPinCode());
        address.setCountry(request.getCountryEnum());
        address.setPoliceStation(request.getAddressRequest().getPoliceStation());
        address.setStreetName(request.getAddressRequest().getStreetName());
        address.setApartmentNumber(request.getAddressRequest().getApartmentNumber());
        address.setLandmarkNBYL(request.getAddressRequest().getLandmarkNBYL());
        address.setAddressType(request.getAddressRequest().getAddressType());
        address.setEmployee(employee);
        addressService.createAddress(address);
        nationalUniqueIdentifierService.createNationalUniqueIdentifier(newNationalUniqueIdentifier);

        return employee;
    }

    public EmployeeResponse getresponse(Optional<Employee> employee){
        return EmployeeResponse.builder()
                .id(employee.get().getId())
                .firstName(employee.get().getFirstName())
                .middleName(employee.get().getMiddleName())
                .lastName(employee.get().getLastName())
                .sapCard(employee.get().getSapCard())
                .salary(employee.get().getSalary())
                .joiningDate(employee.get().getJoiningDate())
                .dob(employee.get().getDob())
                .companyEmailId(employee.get().getCompanyEmailId())
                .anyDisability(employee.get().getAnyDisability())
                .bloodGroup(employee.get().getBloodGroup())
                .companyId(employee.get().getCompany().getId())
                .personalEmailId(employee.get().getPersonalEmailId())
                .mobileNumber(employee.get().getMobileNumber())
                .employeeCategory(employee.get().getEmployeeCategory())
                .employeeDepartment(employee.get().getEmployeeDepartment())
                .genderType(employee.get().getGenderType())
                .countryEnum(employee.get().getCountryEnum())
                .build();
    }
    public List<EmployeeListResponse> getAllEmployee(List<Employee> employees){
        List<EmployeeListResponse> responses= new ArrayList<>();
        employees.forEach(employee ->{
            responses.add(EmployeeListResponse.builder()
                    .id(employee.getId())
                    .firstName(employee.getFirstName())
                    .middleName(employee.getMiddleName())
                    .lastName(employee.getLastName())
                    .sapCard(employee.getSapCard())
                            .salary(employee.getSalary())
                            .joiningDate(employee.getJoiningDate())
                            .dob(employee.getDob())
                            .companyEmailId(employee.getCompanyEmailId())
                            .anyDisability(employee.getAnyDisability())
                            .bloodGroup(employee.getBloodGroup())
                            .companyId(employee.getCompany().getId())

                    .personalEmailId(employee.getPersonalEmailId())
                    .mobileNumber(employee.getMobileNumber())
                    .employeeCategory(employee.getEmployeeCategory())
                    .employeeDepartment(employee.getEmployeeDepartment())
                    .genderType(employee.getGenderType())
                    .countryEnum(employee.getCountryEnum())
                    .build());
        } );
        return responses;
    }

    public Employee updateEmployeeContact(EmployeeUpdateRequest request) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(request.getId());

        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException("Employee not found with ID: " + request.getId());
        }

        Employee employee = optionalEmployee.get();
        employee.setPersonalEmailId(request.getPersonalEmailId());
        employee.setMobileNumber(request.getMobileNumber());

        return employeeRepository.save(employee);

    }
    public EmployeeLoginResponse logInEmployee(String companyEmailId,String sapCard, String password){
        Optional<Employee> employee= employeeService.findEmployeeByCompanyEmailIdOrSapCardAndPassword(companyEmailId,sapCard,password);

        if (employee.isPresent()){
            return EmployeeLoginResponse.builder()
                    .employeeLoginId(employee.get().getId())
                    .loginSapId(employee.get().getSapCard())
                    .loginResponse("Employee has been login successfully.....!")
                    .build();
        } else {
            throw new RuntimeException("Employee not found......!");
        }
    }
    public String resetPassword(String companyEmailId,String sapCard,String password ) {
        Optional<Employee> employee = employeeService.findEmployeeByCompanyEmailIdOrSapCard(companyEmailId,sapCard);
        employee.get().setPassword(password);
        employeeService.createEmployee(employee.get());
        return "Password has been successfully updated...!";
    }

    public  String taskUpdate(TaskType taskType, String ticketNumber, SolutionStatus solutionStatus){
    ChatBoat chatBoat =chatBoatService.findByTicketNumberAndActiveTrue(ticketNumber);
    UserServiceRegistration userSerReg= userServiceRegistrationService.findByTicketNumberAndActiveTrue(ticketNumber);
    if (taskType.equals(TaskType.CHAT_BOAT)){
        chatBoat.setSolutionStatus(solutionStatus);
        chatBoatService.userAskedQueryByChatBoat(chatBoat);
    } else if (taskType.equals(TaskType.MANUAL)) {
        userSerReg.setSolutionStatus(solutionStatus);
        userServiceRegistrationService.createUserServiceRegistration(userSerReg);
    }
    else {
      return "Please select at least one task type.";
    }
        return null;
    }
}
