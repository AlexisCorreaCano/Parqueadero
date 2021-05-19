package co.com.ceiba.domain.model;

import java.util.Date;

import co.com.ceiba.domain.common.constant.ErrorCode;
import co.com.ceiba.domain.common.constant.ErrorMessage;
import co.com.ceiba.domain.common.exception.BusinessException;

public abstract class Vehicle {
    private String licensePlate;
    private final Date checkInDate;

    public Vehicle(String licensePlate, Date checkInDate) throws BusinessException {
        setLicensePlate(licensePlate);
        this.checkInDate = checkInDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    private void setLicensePlate(String licensePlate) throws BusinessException {
        if (licensePlate.length()<6){
            throw new BusinessException(ErrorMessage.MESSAGE_LICENSE_PLATE, ErrorCode.CODE_LICENSE_PLATE);
        }
        this.licensePlate = licensePlate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

}
