package by.dziomin.task1.entity;

public class WorkingVoucher extends Voucher {
   /**
    * workName.
    */
   private String workName;
   /**
    * getter method for workName field.
    *
    * @return workName.
    */
   public String getWorkName() {
      return workName;
   }

   /**
    * setter method for workName field.
    *
    * @param newWorkName newWorkName.
    */
   public void setWorkName(final String newWorkName) {
      workName = newWorkName;
   }

}
