package co.com.ceiba.infraestructure.respository.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;

@Entity
public class CarEntity {
    @PrimaryKey
    @NonNull
    public String licensePlate;

    @ColumnInfo(name = "check_in_date")
    public Long checkInDate;
}
