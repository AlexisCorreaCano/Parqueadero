package co.com.ceiba.infraestructure.respository.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

import co.com.ceiba.domain.common.VehicleType;

@Entity
public class VehicleEntity {

    @PrimaryKey
    private String licensePlate;

    @ColumnInfo(name = "cylinder_capacity")
    private Integer cylinderCapacity;

    @ColumnInfo(name = "type")
    private VehicleType type;

    @ColumnInfo(name = "check_in_date")
    private Date checkInDate;
}
