import cd.domain.mediator.*;
import cd.view.*;
import cd.controller.*;
public class Main
{
 public static void main(String args[])
 {
 CdModel model = new CdModelManager();
 CdView view = new CdGUI();
 CdController controller = new CdController(model, view);
 view.start(controller);
 }
}