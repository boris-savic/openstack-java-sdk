package org.openstack.api.compute;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;
import org.openstack.model.compute.nova.NovaFlavorList;

public class FlavorsResource extends Resource {
	
	public FlavorsResource(Target target, Properties properties) {
		super(target, properties);
	}

    public FlavorList get() {
		return target.path("/detail").request(MediaType.APPLICATION_JSON).get(NovaFlavorList.class);
    }
    
    public Flavor post(Flavor flavor) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(flavor, MediaType.APPLICATION_JSON), Flavor.class);
	}

    public FlavorResource flavor(String id) {
    	return new FlavorResource(target.path("/{id}").pathParam("id", id), properties);
    }

	

}
