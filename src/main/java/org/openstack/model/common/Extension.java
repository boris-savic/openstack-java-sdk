package org.openstack.model.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.atom.Link;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("extension")
public class Extension implements Serializable {

    @XmlAttribute
    private String alias;

    @XmlAttribute
    private String updated;

    @XmlAttribute
    private String namespace;

    @XmlAttribute
    private String name;

    @XmlElement
    private String description;
    
    private List<Link> links = new ArrayList<Link>();

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
    public String toString() {
        return "Extension [alias=" + alias + ", updated=" + updated + ", namespace=" + namespace + ", name=" + name + ", description=" + description + "]";
    }

}
