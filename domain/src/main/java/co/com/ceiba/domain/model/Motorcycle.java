package co.com.ceiba.domain.model;

import java.util.Date;

import co.com.ceiba.domain.common.constant.ErrorCode;
import co.com.ceiba.domain.common.constant.ErrorMessage;
import co.com.ceiba.domain.common.exception.BusinessException;

public class Motorcycle extends Vehicle{
    private Integer cylinderCapacity;

    public Motorcycle(String licensePlate, Date checkInDate, Integer cylinderCapacity) throws BusinessException {
        super(licensePlate, checkInDate);
        setCylinderCapacity(cylinderCapacity);
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
}
