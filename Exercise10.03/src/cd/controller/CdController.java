package cd.controller;

import cd.domain.mediator.CdModel;
import cd.view.CdView;

public class CdController {
private CdModel model;
private CdView view;
public CdController(CdModel model, CdView view)
{
this.model = model;
this.view = view;
}

public void execute(String what)
{
switch (what) {
case "List all CD's":
	view.show(model.getAll().toString());
	break;
case "Add new CD":
	view.show("not implemented");
	break;
case "Remove CD":
	model.removeCD(view.get("title"));
	break;
case "Search CD by title":
	model.getCDds(view.get("title"));
	break;
case "Quit":
	System.exit(0);
	break;
default:
	break;
}
}
}
