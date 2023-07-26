package org.junit.experimental.theories.internal;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.PotentialAssignment;

import java.util.List;

public class DataPointsValues {
    private Class<?> type;
    private ParameterSignature sig;
    private String name;
    private List<PotentialAssignment> list;
    private Object value;
    public DataPointsValues(Class<?> type, ParameterSignature sig, String name,
                            List<PotentialAssignment> list, Object value) {
        this.type = type;
        this.sig = sig;
        this.name = name;
        this.list = list;
        this.value = value;
    }
    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public ParameterSignature getSig() {
        return sig;
    }

    public void setSig(ParameterSignature sig) {
        this.sig = sig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PotentialAssignment> getList() {
        return list;
    }

    public void setList(List<PotentialAssignment> list) {
        this.list = list;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
}
