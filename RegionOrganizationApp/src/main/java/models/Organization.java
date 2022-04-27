package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import utils.JacksonUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {
    @JsonProperty("ID")
    long id;

    @JsonProperty("Name")
    String name;

    @JsonProperty("INN")
    String inn;

    @JsonProperty("Residence")
    String residence;

    @JsonProperty("StoreDate")
    String storeDate;

    @JsonProperty("BlockDate")
    String blockDate;

    public Date getStoreDate() {
        try{
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            return format.parse(storeDate);
        } catch (ParseException ignored) {
            return null;
        }
    }

    public Date getBlockDate() {
        try{
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            return format.parse(blockDate);
        } catch (ParseException ignored) {
            return null;
        }
    }

}
