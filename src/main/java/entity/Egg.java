package entity;


import lombok.Getter;
import lombok.Setter;
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
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "collectedDate")
    private String collectedDate;

    @ManyToOne
    @JoinColumn(name="userId",referencedColumnName="id")
    private User user;

    public Date generateNextDate(int time){

        Date collected = null;
        try {
            collected = new SimpleDateFormat("dd/MM/yyyy").parse( getCollectedDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(collected);
        calendar.add(Calendar.DAY_OF_YEAR,time);
        Date nextDate = calendar.getTime();
       return nextDate;
    }
    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
