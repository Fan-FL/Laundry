package com.quoll.model;

import javax.persistence.*;
import java.io.Serializable;

public class Resources implements Serializable{
    private static final long serialVersionUID = -6812242071705361506L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * resource name
     */
    private String name;


    /**
     * url resource
     */
    @Column(name = "resUrl")
    private String resurl;

    /**
     * resource type   1: Menu 2: Button
     */
    private Integer type;

    /**
     * parent resource
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * sorting
     */
    private Integer sort;

    @Transient
    private String checked;//check whether is selected
    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * obtain resource name
     *
     * @return name - resource name
     */
    public String getName() {
        return name;
    }

    /**
     * set up resource name
     *
     * @param name - resource name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * obtain url
     *
     * @return resUrl - url resource
     */
    public String getResurl() {
        return resurl;
    }

    /**
     * set up url
     *
     * @param resurl - url resource
     */
    public void setResurl(String resurl) {
        this.resurl = resurl;
    }

    /**
     * obtain resource type   1:Menu    2：Button
     *
     * @return type 
     */
    public Integer getType() {
        return type;
    }

    /**
     * set up resource type   1:Menu    2：Button
     *
     * @param type 
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * obtain parent resource
     *
     * @return parentId 
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * set up parent resource
     *
     * @param parentid 
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * obtain sorting 
     *
     * @return sort - sorting
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * set up sorting
     *
     * @param sort 
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resurl='" + resurl + '\'' +
                ", type=" + type +
                ", parentid=" + parentid +
                ", sort=" + sort +
                '}';
    }
}