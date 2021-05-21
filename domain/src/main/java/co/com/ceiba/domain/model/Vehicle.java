package co.com.ceiba.domain.model;

import java.util.Date;
import java.util.regex.Pattern;

import co.com.ceiba.domain.common.constant.ErrorCode;
import co.com.ceiba.domain.common.constant.ErrorMessage;
import co.com.ceiba.domain.common.exception.BusinessException;

public abstract class Vehicle {
    private String licensePlate;
    private final Date checkInDate;

    public Vehicle(String licensePlate, Date checkInDate) {
        setLicensePlate(licensePlate);
        this.checkInDate = checkInDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    private void setLicensePlate(String licensePlate){
        String regexp = "^[a-zA-Z]{3}[\\d]{3}$";
        if (!Pattern.matches(regexp, licensePlate)){
            throw new BusinessException(ErrorMessage.MESSAGE_LICENSE_PLATE, ErrorCode.CODE_LICENSE_PLATE);
        }
        this.licensePlate = licensePlate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

}
