package guru.springframwork.msscbrewery.web.controller;

import guru.springframwork.msscbrewery.web.model.BeerDto;
import guru.springframwork.msscbrewery.web.model.CustomerDto;
import guru.springframwork.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId")UUID customerId){
    return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto saveDto = customerService.saveNewCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","/api/v1/customer" + saveDto.getCustomerId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }
    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);
        return null;
    }


}
