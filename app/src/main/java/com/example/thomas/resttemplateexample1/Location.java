package com.example.thomas.resttemplateexample1;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by thomas on 20.03.18.
 */

@Root(strict=false)
public class Location {

    @Element
    private String name;

    @Element
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
