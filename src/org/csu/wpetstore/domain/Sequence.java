package org.csu.wpetstore.domain;

import java.io.Serializable;

/**
 * Created by WZF on 2018/4/30.
 */
public class Sequence implements Serializable{
    private static final long serialVersionUID = 8278780133180137281L;

    private String name;
    private int nextId;

    public Sequence() {
    }

    public Sequence(String name, int nextId) {
        this.name = name;
        this.nextId = nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

}
