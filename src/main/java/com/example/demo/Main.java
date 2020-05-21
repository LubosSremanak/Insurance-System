package com.example.demo;


import com.example.demo.api.UserManager;
import com.example.demo.contract.insurance.life.accident.AccidentInsurance;
import com.example.demo.contract.insurance.life.accident.TerritorialValidity;
import com.example.demo.contract.insurance.nonLife.TypeOfRealEstate;
import com.example.demo.contract.insurance.nonLife.home.HomeInsurance;
import com.example.demo.controller.SpringController;
import com.example.demo.user.User;
import com.example.demo.user.personalInformation.Address;
import com.example.demo.user.personalInformation.Contact;
import com.example.demo.user.personalInformation.Identification;
import com.example.demo.user.personalInformation.Place;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


@SpringBootApplication
public class Main extends SpringController implements CommandLineRunner {


    public Main(UserManager userManager) {
        super(userManager);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        log.print("Open in browser: http://localhost:8081");
    }


    @Override
    public void run(String... args) {
        testUser();
        testUser1();
    }

    private void testUser() {
        User user = new User(0);

        Identification identification = new Identification("Lubos", "Sremanak",
                "990621/2508");
        user.setIdentification(identification);

        Contact contact = new Contact("0983215269", "sremanak.lubos@gmail.com");
        user.setContact(contact);

        Place place = new Place("Slovakia", "Presov", "Jungmanova");
        Address address = new Address(place, 11, "085101");
        user.setAddress(address);
        Address correspondenceAddress = new Address(address);
        user.setCorrespondenceAddress(correspondenceAddress);

        AccidentInsurance contract = new AccidentInsurance(0);
        contract.setMonthlyPayment(100);
        contract.setIndemnity(100);
        contract.setBeginInsurance(LocalDate.of(2020, 8, 7));
        contract.setEndInsurance(LocalDate.of(2025, 8, 6));
        contract.setFormation(LocalDate.of(2020, 8, 6));
        contract.setInsured(user);
        contract.setTerritorialValidity(TerritorialValidity.SLOVAKIA);
        contract.setInsurer(user);
        userManager.addUser(user);
        userManager.createContract(0, contract);


    }

    private void testUser1() {
        User user = new User(1);

        Identification identification = new Identification("Lopi", "Poko",
                "797621/2338");
        user.setIdentification(identification);

        Contact contact = new Contact("0913215262", "sikolopik.lubos@gmail.com");
        user.setContact(contact);

        Place place = new Place("Hungary", "Budapest", "Romaron");
        Address address = new Address(place, 21, "048122");
        user.setAddress(address);
        Address correspondenceAddress = new Address(address);
        user.setCorrespondenceAddress(correspondenceAddress);

        AccidentInsurance contract = new AccidentInsurance(1);
        contract.setMonthlyPayment(100);
        contract.setIndemnity(100);
        contract.setBeginInsurance(LocalDate.of(2020, 8, 7));
        contract.setEndInsurance(LocalDate.of(2025, 8, 6));
        contract.setFormation(LocalDate.of(2020, 8, 6));
        contract.setInsured(userManager.editUser(0));
        contract.setTerritorialValidity(TerritorialValidity.SLOVAKIA);
        contract.setInsurer(user);

        Place place1 = new Place("Slovakia", "Presov", "Mukacevska");
        Address address1 = new Address(place1, 21, "085122");
        HomeInsurance homeInsurance = new HomeInsurance(2);
        homeInsurance.setMonthlyPayment(100);
        homeInsurance.setIndemnity(100);
        homeInsurance.setBeginInsurance(LocalDate.of(2020, 8, 7));
        homeInsurance.setEndInsurance(LocalDate.of(2025, 8, 6));
        homeInsurance.setFormation(LocalDate.of(2020, 8, 6));
        homeInsurance.setValueOfHousehold(1000);
        homeInsurance.setRealEstateValue(25);
        homeInsurance.setTypeOfRealEstate(TypeOfRealEstate.BRICK_HOUSE);
        homeInsurance.setInsurer(user);
        homeInsurance.setAddress(address1);


        userManager.addUser(user);
        userManager.createContract(1, contract);
        userManager.createContract(1, homeInsurance);


    }


}

