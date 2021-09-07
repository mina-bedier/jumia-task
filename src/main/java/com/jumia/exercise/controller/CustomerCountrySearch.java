package com.jumia.exercise.controller;

import com.jumia.exercise.dto.CustomSearchDto;
import com.jumia.exercise.dto.SearchResultDto;
import com.jumia.exercise.service.CountryService;
import com.jumia.exercise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/jumia")
public class CustomerCountrySearch {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CountryService countryService;
    private List<String> countries;


    @GetMapping("search")
    public String getCountries (Model model){
        CustomSearchDto customSearchDto = new CustomSearchDto();
        List<SearchResultDto> searchResultList = customerService.getAllCustomers();
        //Generate dropdown list for all countries.
        countries = countryService.getCountryNames();

        model.addAttribute("customSearchDto", customSearchDto);
        model.addAttribute("searchResultList",searchResultList);
        model.addAttribute("countries",countries);
        return "search";
    }

    @PostMapping("/search")
    public String submitAction (@ModelAttribute("customSearchDto") CustomSearchDto customSearchDto,
                                Model model){
        String countryName = customSearchDto.getCountryName();
        String phoneNumberstatus = customSearchDto.getStatus();
        List<SearchResultDto> searchResultList;
        /*
       trying to validate the request sent by the user
         */
        if (!countryName.equals("null") && phoneNumberstatus.equals("null"))
            searchResultList = customerService.searchCustomersByCountry(countryName);
        else if (countryName.equals("null") && !phoneNumberstatus.equals("null"))
            //search by status
            searchResultList = customerService.searchCustomersByStatus(phoneNumberstatus);
        else if (!countryName.equals("null") && !phoneNumberstatus.equals("null"))
            //search by both options
            searchResultList = customerService.searchCustomersByCountryStatus(countryName,phoneNumberstatus);
        else //get all customers
            searchResultList = customerService.getAllCustomers();

        model.addAttribute("countries",countries);
        model.addAttribute("searchResultList",searchResultList);
        model.addAttribute("country",countryName);
        model.addAttribute("status",phoneNumberstatus);
        return "search";
    }
}
