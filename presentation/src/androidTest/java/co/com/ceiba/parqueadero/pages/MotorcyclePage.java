package co.com.ceiba.parqueadero.pages;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.BaseTest;

public class MotorcyclePage extends BaseTest {

    private final int EDIT_TEXT_LICENSE_PLATE_ID = R.id.txt_license_plate;
    private final int EDIT_TEXT_CYLINDER_CAPACITY_ID = R.id.txt_cylinder_capacity;
    private final int BUTTON_ID = R.id.fab_motorcycle;
    private final int TEXT_ID = R.id.lbl_license_plate;
    private final String TAB_MOTORCYCLE = "MOTORCYCLES";
    private final String MESSAGE_ALERT_ID = "message";

    public MotorcyclePage navigateToMotorcyclePage(){
        super.clickButton(TAB_MOTORCYCLE);
        return this;
    }

    public MotorcyclePage enterLicensePlate(String text){
        super.enterText(EDIT_TEXT_LICENSE_PLATE_ID,text);
        return this;
    }

    public MotorcyclePage enterLicensePlateBad(String text){
        super.enterText(EDIT_TEXT_LICENSE_PLATE_ID,text);
        return this;
    }

    public MotorcyclePage enterCylinderCapacity(String text){
        super.enterText(EDIT_TEXT_CYLINDER_CAPACITY_ID,text);
        return this;
    }

    public MotorcyclePage clickAddMotorcycle(){
        super.clickButton(BUTTON_ID);
        return this;
    }

    public MotorcyclePage verityCarInList(String text){
        super.verifyTextDisplay(TEXT_ID,text);
        return this;
    }

    public MotorcyclePage verityAlert(){
        super.verifyTextDisplay(MESSAGE_ALERT_ID);
        return this;
    }

}
