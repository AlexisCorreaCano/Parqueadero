package co.com.ceiba.parqueadero.pages;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.BaseTest;

public class CarPage extends BaseTest {

    private final int EDIT_TEXT_ID = R.id.txt_license_plate_car;
    private final int BUTTON_ID = R.id.fab;
    private final int TEXT_ID = R.id.lbl_license_plate;
    private final int RECYCLER_ID = R.id.rv_cars;
    private final String MESSAGE_ALERT_ID = "message";

    public CarPage enterLicencePlateCorrect(String text){
        super.enterText(EDIT_TEXT_ID,text);
        return this;
    }

    public CarPage enterLicencePlateIncorrect(String text){
        super.enterText(EDIT_TEXT_ID,text);
        return this;
    }

    public CarPage clickAddCar(){
        super.clickButton(BUTTON_ID);
        return this;
    }

    public CarPage verityCarInList(String text){
        super.verifyTextDisplay(TEXT_ID,text);
        return this;
    }

    public CarPage verityAlert(){
        super.verifyTextDisplay(MESSAGE_ALERT_ID);
        return this;
    }

    public CarPage deleteItem(int position){
        super.deleteItem(RECYCLER_ID,position);
        return this;
    }

}
