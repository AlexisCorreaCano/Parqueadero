package co.com.ceiba.domain.model;

import java.util.Date;

import co.com.ceiba.domain.common.constant.ErrorCode;
import co.com.ceiba.domain.common.constant.ErrorMessage;
import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.domain.common.exception.BusinessException;

public class Vehicle {
    private String licensePlate;
    private Integer cylinderCapacity;
    private VehicleType type;
    private Date checkInDate;

    public Vehicle(String licensePlate, Integer cylinderCapacity, VehicleType type, Date checkInDate) throws BusinessException {
        setLicensePlate(licensePlate);
        setCylinderCapacity(cylinderCapacity);
        this.type = type;
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

    public Integer getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(Integer cylinderCapacity) throws BusinessException {
        if (cylinderCapacity<=0){
            throw new BusinessException(ErrorMessage.MESSAGE_CYLINDER_CAPACITY, ErrorCode.CODE_CYLINDER_CAPACITY);
        }
        this.cylinderCapacity = cylinderCapacity;
    }

    public VehicleType getType() {
        return type;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

}
