package cd.domain.mediator;

import java.io.IOException;

import cd.domain.model.Cd;
import cd.domain.model.CdList;

public class CdModelManager implements CdModel {
private CdList cdList;
private CdPersistence storage;
private String cds = "src/cds.txt";

public CdModelManager()
{
	 try
     {
        storage = new CdTextFile("src/cds.txt");
        cdList = storage.load();

     }
     catch (IOException e)
     {
        e.printStackTrace();
     }
}
	@Override
	public CdList getAll() {
		return cdList;
	}

	@Override
	public void addCD(Cd cd) {
		cdList.addCd(cd);
	}

	@Override
	public Cd removeCD(String title) {
		return cdList.removeFirstCdByTitle(title);
	}

	@Override
	public Cd getCD(int index) {
		return cdList.getCD(index);
	}

	@Override
	public CdList getCDds(String title) {
		return cdList.getCdsByTitle(title);
	}

	@Override
	public int getNumberOfCDs() {
		return cdList.getNumberOfCds();
	}

}
