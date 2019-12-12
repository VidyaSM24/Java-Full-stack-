
public class TestG {

	public static void main(String[] args) {
		//FirstG fg=new FirstG();
		//fg.call();
		//fg.msg();
	 	//SecondG sg =new SecondG();
	//	sg.call();
		//sg.msg();
		//sg.radio();
//		ThirdG tg=new ThirdG();
	//	tg.call();
		//tg.msg();
	//	tg.radio();
//		tg.camera();
		FirstG fg= new ThirdG();
		fg.call();
		fg.msg();
		SecondG sg=new ThirdG();
		sg.call();
		sg.msg();
		sg.radio();
		ThirdG tg =new ThirdG();
		tg.call();
		tg.msg();
	    tg.radio();
        tg.camera();

	}

}
