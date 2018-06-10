package cd.view;

import cd.controller.CdController;
import cd.domain.model.CdList;

public interface CdView
{
   void start(CdList cdList);
   void show(String value);
   String get(String what);

	void start(CdController controller);
}
