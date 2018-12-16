package entity;


import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Egg")
@Table(name = "Eggs")
public class Egg {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "perUserId")
    private int perUserId;

    @Column(name = "collectedDate")
    private String collectedDate;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    public Date generateNextDate(int time) {
        Logger logger = LogManager.getLogger(this.getClass());
        Date collected = null;
        try {
            collected = new SimpleDateFormat("yyyy-mm-dd").parse(getCollectedDate());

        } catch (ParseException e) {
            logger.debug(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(collected);
        calendar.add(Calendar.DAY_OF_YEAR, time);
        return calendar.getTime();
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
