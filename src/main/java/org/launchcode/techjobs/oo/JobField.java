package org.launchcode.techjobs.oo;

import java.util.Objects;

abstract public class JobField {
    int id;
    static int nextId = 1;
    private String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        if(value.isEmpty()){
            value ="Data not available";
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        if (value.isEmpty()) {
            value = "Data not available";
        }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
