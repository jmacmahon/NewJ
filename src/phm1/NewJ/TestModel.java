package phm1.NewJ;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TestModel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean save = false;

		Model myModel = new Model();

		if(save){
			NJField myField = new NJField("test", "int", NJAccessModifier.PRIVATE);

			NJArgument myArgument = new NJArgument("herpaderp", "String");
			ArrayList<NJArgument> myArguments = new ArrayList<NJArgument>();
			myArguments.add(myArgument);

			NJMethod myMethod = new NJMethod("aMethod", "void", NJAccessModifier.PUBLIC, myArguments);

			ArrayList<NJField> myFields = new ArrayList<NJField>();
			myFields.add(myField);

			ArrayList<NJMethod> myMethods = new ArrayList<NJMethod>();
			myMethods.add(myMethod);

			NJClass myTestClass = new NJClass("TestName", myFields, myMethods);
			myModel.addClass(myTestClass);

			System.out.println(myModel.getClasses().get(0).getFields().get(0) == myField);

			try {
				myModel.save("newjtest.xml");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				myModel.load("newjtest.xml");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			NJClass c = myModel.getClasses().get(0);
			System.out.println(c);
		}
	}

}
