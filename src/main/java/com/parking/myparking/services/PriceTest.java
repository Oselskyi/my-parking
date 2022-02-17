package com.parking.myparking.services;

import com.parking.myparking.model.Price;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PriceTest {

    @PostConstruct
    public Price init() {
        Price price = new Price();
        Properties property = new Properties();

        try (
                InputStream input = new FileInputStream("src/main/resources/application.properties")) {

            property.load(input);

            price.setPriceForHalfDay(Integer.parseInt(property.getProperty("price.priceForHalfDay")));
            price.setPriceForDay(Integer.parseInt(property.getProperty("price.priceForDay")));
            price.setPriceForLost(Integer.parseInt(property.getProperty("price.priceForLost")));
            price.setPriceMoreThenDay(Integer.parseInt(property.getProperty("price.priceMoreThenDay")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }
}
