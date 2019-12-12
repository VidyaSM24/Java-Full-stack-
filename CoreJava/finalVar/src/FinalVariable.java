
public class FinalVariable {
      final double PI;
      public FinalVariable(double PI)
      {
    	  this.PI=PI;
      }
      public FinalVariable(int a,double PI)
      {
    	  this.PI=PI;
      }
      void piValue()
      {
    	  System.out.println(PI);
    	  //System.out.println(a);
      }
}
