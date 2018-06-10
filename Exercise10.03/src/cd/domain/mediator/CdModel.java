package cd.domain.mediator;

import cd.domain.model.Cd;
import cd.domain.model.CdList;

public interface CdModel {
	public CdList getAll();

	public void addCD(Cd cd);

	public Cd removeCD(String title);

	public Cd getCD(int index);

	public CdList getCDds(String title);

	public int getNumberOfCDs();

}
