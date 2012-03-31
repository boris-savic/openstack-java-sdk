package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerList;
import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotList;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.nova.volume.NovaVolumeForCreate;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateVolumeActivity extends AbstractActivity implements CreateVolumeView.Presenter {
	
	private static final CreateVolumeView VIEW = new CreateVolumeView();
	
	public interface Presenter {
		
	}
	
	private Presenter presenter;
	
	//create volume from snapshot
	private Snapshot snapshot;
	
	public CreateVolumeActivity() {
		
	}
	
	public CreateVolumeActivity(Snapshot snapshot) {
		this.snapshot = snapshot;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		OpenStackClient.COMPUTE.listSnapshots(new DefaultAsyncCallback<SnapshotList>() {
			
			@Override
			public void onSuccess(SnapshotList result) {
				VIEW.snapshotId.addItem("Select a snapshot", "");
				int idx = 0;
				for(Snapshot s : result.getList()) {
					VIEW.snapshotId.addItem(s.getName() + " " + s.getId(), s.getId().toString());
					if(snapshot != null && s.getId().equals(snapshot.getId())) {
						VIEW.snapshotId.setSelectedIndex(idx + 1);
					}
					idx++;
				}
				panel.setWidget(VIEW);
				UI.MODAL.center();
			}
			
		});
	}

	@Override
	public void createVolume(NovaVolumeForCreate volume) {
		OpenStackClient.COMPUTE.createVolume(volume, new DefaultAsyncCallback<Volume>() {

			@Override
			public void onSuccess(Volume result) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
