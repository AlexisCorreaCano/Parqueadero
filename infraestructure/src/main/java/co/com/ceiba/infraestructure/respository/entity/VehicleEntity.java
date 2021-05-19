package co.com.ceiba.infraestructure.respository.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import co.com.ceiba.domain.common.constant.VehicleType;

@Entity
public class VehicleEntity {

    @PrimaryKey
    @NonNull
    public String licensePlate;

    @ColumnInfo(name = "cylinder_capacity")
    public Integer cylinderCapacity;

    @ColumnInfo(name = "type")
    public VehicleType type;

    @ColumnInfo(name = "check_in_date")
    public Long checkInDate;
}
