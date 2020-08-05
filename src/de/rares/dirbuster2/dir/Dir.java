package de.rares.dirbuster2.dir;

import java.util.List;

public class Dir {
    public Dir(String name) {
        this.name = name;
    }

    public List<Dir> childs;
    public String name;

}
